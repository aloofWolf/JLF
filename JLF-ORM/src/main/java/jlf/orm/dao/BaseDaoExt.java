package jlf.orm.dao;

import com.alibaba.fastjson.JSONObject;
import jlf.orm.metadata.entity.BaseEntity;
import jlf.orm.metadata.entityMetadata.EntityMetadata;
import jlf.orm.metadata.entityMetadata.EntityMetadataUtil;
import jlf.util.GenericityUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @param <T>
 * @author Lone Wolf
 * @ClassName: BaseDaoExt
 * @Description: DAO扩展类
 * @date 2023年9月18日
 */
@Slf4j
@Component
public class BaseDaoExt<T> {

    private static BaseDaoExt<?> instance;

    protected static BaseDaoExt<?> get() {
        return instance;
    }

    public BaseDaoExt() {
        BaseDaoExt.instance = this;
    }

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private RedissonClient redssion;

    /**
     * daocls与EntityMetadata对象的映射关系
     */
    @SuppressWarnings("rawtypes")
    private static Map<Class<? extends BaseDao>, EntityMetadata> daoToMetadataMap = new ConcurrentHashMap<>();

    /**
     * @param dao
     * @param id
     * @return
     * @Title: getById
     * @Description: 根据id查询实体，如果实体被@Cache注解标注，则会优先去缓存中查询
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected BaseEntity getById(BaseDao dao, Long id) {
        Class<? extends BaseDao> daoCls = (Class<? extends BaseDao>) dao.getClass().getInterfaces()[0];
        EntityMetadata metadata = getEntityMetadataByDaoCls(daoCls);
        boolean isNeedCache = metadata.isNeedCache();
        if (isNeedCache) {
            return getByCache(metadata, dao, id, 1);
        } else {

            return getByDataBase(dao, id);
        }

    }

    @SneakyThrows
    @SuppressWarnings({"rawtypes", "unchecked"})
    private BaseEntity getByCache(EntityMetadata metadata, BaseDao dao, Long id, int count) {
        if (count >= 5) {
            return null; // 递归6次，返回null
        }

        String cacheValue = getByCache(metadata, id); // 从缓存中查询，从缓存中查询回来的可能是空串，getByCache方法中会对空串做处理
        if ("".equals(cacheValue)) {
            return null;
        } else if (cacheValue != null) {
            return JSONObject.parseObject(cacheValue, metadata.getEntityCls());
        }
        RLock lock = getLock(metadata, id);

        boolean flag = tryLock(lock); // 获取锁
        if (!flag) {  // 竞争锁失败，睡眠50毫秒，进入下一次递归
            Thread.sleep(50);
            return getByCache(metadata, dao, id, count + 1);
        }
        BaseEntity entity = getByDataBase(dao, id); // 查询数据库
        writeBackToCache(metadata, entity, id); // 回写至缓存，如果数据库中没有查到数据，则在缓存中回写空串
        unLock(lock); // 释放锁
        return entity;

    }


    /**
     * @param daoCls
     * @return
     * @Title: getEntityMetadataByDaoCls
     * @Description: 根据daocls，获取EntityMetadata对象
     */
    @SuppressWarnings("rawtypes")
    protected EntityMetadata getEntityMetadataByDaoCls(Class<? extends BaseDao> daoCls) {
        EntityMetadata metadata = daoToMetadataMap.get(daoCls);
        if (metadata == null) {
            metadata = genEntityMetadataByDaoCls(daoCls);
        }
        return metadata;
    }

    /**
     * @param daoCls
     * @return
     * @Title: genEntityMetadataByDaoCls
     * @Description: 根据daocls，生成EntityMetadata对象
     */
    @SuppressWarnings("rawtypes")
    private EntityMetadata genEntityMetadataByDaoCls(Class<? extends BaseDao> daoCls) {
        synchronized (daoCls) {
            EntityMetadata metadata = daoToMetadataMap.get(daoCls);
            if (metadata == null) {
                Class<? extends BaseEntity> entityCls = GenericityUtil.getObjSuperInterGenerCls(daoCls);
                metadata = EntityMetadataUtil.getEntityMetadata(entityCls);
                daoToMetadataMap.put(daoCls, metadata);
            }
            return metadata;
        }
    }

    /**
     * @param metadata
     * @param id
     * @return
     * @Title: getByCache
     * @Description: 根据id去缓存中查询实体
     */
    private String getByCache(EntityMetadata metadata, Long id) {
        String cacheKey = metadata.genEntityCacheKey(id);
        String result = stringRedisTemplate.opsForValue().get(cacheKey);
        return result;

    }

    /**
     * @param dao
     * @param id
     * @return
     * @Title: getByDataBase
     * @Description: 根据id去数据库中查询实体
     */
    private BaseEntity getByDataBase(BaseDao<? extends BaseEntity> dao, Long id) {
        BaseEntity entity = dao.selectById(id);
        return entity;
    }

    /**
     * @param metadata
     * @param entity
     * @Title: writeBackToCache
     * @Description: 将实体信息回写是缓存
     */
    private void writeBackToCache(EntityMetadata metadata, BaseEntity entity, Long id) {
        if (metadata.isNeedCache()) {
            String cacheKey;
            if (entity != null) {
                cacheKey = metadata.genEntityCacheKey(entity.getId());
                long begin = System.currentTimeMillis();
                stringRedisTemplate.opsForValue().set(cacheKey, JSONObject.toJSONString(entity),
                        metadata.genEntityCacheTimeout(), TimeUnit.MINUTES);
                long end = System.currentTimeMillis();
                long time = end - begin;
                log.info("writeBackToCache-redis耗时：" + time);
            } else {
                cacheKey = metadata.genEntityCacheKey(id);
                stringRedisTemplate.opsForValue().set(cacheKey, "", metadata.genEntityCacheTimeout(), TimeUnit.MINUTES);
            }
        }
    }


    protected void unLock(RLock lock) {
        lock.unlock();
    }

    protected RLock getLock(EntityMetadata metadata, Long id) {
        String cacheKeyLock = metadata.genEntityCacheLockKey(id);
        RLock lock = redssion.getLock(cacheKeyLock);
        return lock;
    }


    @SneakyThrows
    protected boolean tryLock(RLock lock) {
        return lock.tryLock(200, TimeUnit.MILLISECONDS);
    }

}
