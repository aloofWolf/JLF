package jlf.orm.metadata.entityMetadata;

import jlf.util.StringUtil;
import lombok.Data;
import jlf.orm.metadata.ann.Cache;
import jlf.orm.metadata.config.OrmConfig;
import jlf.orm.metadata.entity.BaseEntity;

/**
 * @author Lone Wolf
 * @ClassName: EntityMetadata
 * @Description: 实体类的元数据信息
 * @date 2019年9月10日
 */
@Data
public class EntityMetadata {

    private Class<? extends BaseEntity> entityCls; // 实体类的class类型

    private boolean isNeedCache; // 是否需要缓存

    private Cache cache; // 缓存注解对象

    private String clsName; // 实体类名

    public EntityMetadata(Class<? extends BaseEntity> entityCls, Cache cache) {
        super();
        this.entityCls = entityCls;
        this.cache = cache;
        this.clsName = entityCls.getSimpleName();
        if (cache != null) {
            this.isNeedCache = true;
        } else {
            this.isNeedCache = false;
        }
    }

    /**
     * @param id
     * @return
     * @Title: genEntityCacheKey
     * @Description: 生成需要存储到缓存的实体的key
     */
    public String genEntityCacheKey(Long id) {
        String cacheKey = StringUtil.appendWithUnSafe(this.clsName, "-", id);
        return cacheKey;
    }

    /**
     * @param id
     * @return
     * @Title: genEntityCacheKey
     * @Description: 生成需要存储到缓存的实体的key
     */
    public String genEntityCacheLockKey(Long id) {
        String cacheKeyLock = StringUtil.appendWithUnSafe(this.clsName, "-", id, "-lock");
        return cacheKeyLock;
    }

    /**
     * @return
     * @Title: genEntityCacheTimeout
     * @Description: 获取需要存储到缓存的实体的过期时间
     */
    public int genEntityCacheTimeout() {
        int period = this.cache.period();
        if (period <= 0) {
            period = OrmConfig.get().getCachePeriod();
        }
        return period;
    }

}
