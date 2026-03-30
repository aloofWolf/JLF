package jlf.canal.service.process.impl.redis.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import jlf.canal.metadata.bean.BinLogBean;
import jlf.canal.service.process.impl.redis.api.CanalProcessRedisApi;
import jlf.orm.metadata.ann.Cache;
import jlf.orm.metadata.entity.BaseEntity;
import jlf.orm.metadata.entityMetadata.EntityMetadata;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @ClassName: CanalProcessRedisDefaultImpl
 * @Description: CanalProcessRedisApi的默认实现
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Component
public class CanalProcessRedisDefaultImpl implements CanalProcessRedisApi {

	@Autowired
	private RedisTemplate<String, String> redis;

	/**
	 * tableEntitys是否已经被初始化
	 * 本来可以根据tableEntitys是否为null来判断是否被初始化，但是在初始化时，需要对tableEntitys加锁
	 * 如果tableEntitys为null的话，无法加锁，所以新增此变量来判断tableEntitys是否被初始化
	 */
	private static boolean isInitTableEntitys = false;

	/**
	 * 表名与medata的映射
	 */
	private static Map<String, EntityMetadata> tableEntitys = new HashMap<String, EntityMetadata>();

	/**
	 * 
	 * @Title: isHotSpotData
	 * @Description: 根据afterJson判断此数据是否为热点数据，默认为false，可被子类重写
	 * @param afterJson
	 * @return
	 */
	protected boolean isHotSpotData(JSONObject afterJson) {
		return false;
	}

	/**
	 * 
	 * @Title: insertOtherProcess
	 * @Description: 插入数据时，需要做的其他的处理，默认为空实现，可被子类重新
	 * @param afterJson
	 */
	protected void insertOtherProcess(JSONObject afterJson) {
	}

	/**
	 * 
	 * @Title: updateOtherProcess
	 * @Description: 更新数据时，需要做的其他的处理，默认为空实现，可被子类重新
	 * @param afterJson
	 */
	protected void updateOtherProcess(JSONObject afterJson) {
	}

	/**
	 * 
	 * @Title: deleteOtherProcess
	 * @Description: 删除数据时，需要做的其他的处理，默认为空实现，可被子类重新
	 * @param afterJson
	 */
	protected void deleteOtherProcess(JSONObject afterJson) {
	}

	/**
	 * 判断是否为热点数据，如果是则写入缓存，如果不是则删除缓存
	 */
	@Override
	public void insert(BinLogBean binLogBean) {
		if (!isNeedProcessCache(binLogBean)) {
			return;
		}
		EntityMetadata metadata = tableEntitys.get(binLogBean.getTable());
		List<JSONObject> afters = binLogBean.getData();
		for (JSONObject afterJson : afters) {
			Long id = afterJson.getLong("id");
			if (isHotSpotData(afterJson)) {
				save(metadata, afterJson, id);

			} else {
				delete(metadata, id);
			}
			insertOtherProcess(afterJson);
		}
	}

	/**
	 * 判断是否为热点数据，如果是则写入缓存，如果不是则删除缓存
	 */
	@Override
	public void update(BinLogBean binLogBean) {
		if (!isNeedProcessCache(binLogBean)) {
			return;
		}
		EntityMetadata metadata = tableEntitys.get(binLogBean.getTable());
		List<JSONObject> afters = binLogBean.getData();
		for (JSONObject afterJson : afters) {
			Long id = afterJson.getLong("id");
			if (isHotSpotData(afterJson)) {
				save(metadata, afterJson, id);

			} else {
				delete(metadata, id);
			}
			updateOtherProcess(afterJson);
		}

	}

	/**
	 * 直接删除缓存
	 */
	@Override
	public void delete(BinLogBean binLogBean) {
		if (!isNeedProcessCache(binLogBean)) {
			return;
		}
		EntityMetadata metadata = tableEntitys.get(binLogBean.getTable());
		List<JSONObject> afters = binLogBean.getData();
		for (JSONObject afterJson : afters) {
			Long id = afterJson.getLong("id");
			delete(metadata, id);
			deleteOtherProcess(afterJson);
		}

	}

	/**
	 * 
	 * @Title: isNeedProcessCache
	 * @Description: 根据binLogBean对象中的tableName判断此表是否需要缓存
	 *               如果tableEntitys没有被初始化，需要加同步锁初始化tableEntitys
	 * @param binLogBean
	 * @return
	 */
	protected boolean isNeedProcessCache(BinLogBean binLogBean) {

		if (!isInitTableEntitys) {
			synchronized (tableEntitys) {
				if (!isInitTableEntitys) {
					initTableEntitys();
				}
			}
		}

		String tableName = binLogBean.getTable();
		EntityMetadata metadata = tableEntitys.get(tableName);
		if (metadata == null) {
			return false;
		}
		if (metadata.isNeedCache()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Title: initTableEntitys
	 * @Description: 初始化tableEntitys
	 */
	@SuppressWarnings("unchecked")
	@SneakyThrows
	private void initTableEntitys() {
		Class<?> clazz = TableInfoHelper.class;
		Field field = clazz.getDeclaredField("TABLE_INFO_CACHE");
		field.setAccessible(true);
		Map<Class<?>, TableInfo> tables = (Map<Class<?>, TableInfo>) field.get(clazz);
		field.setAccessible(false);
		Iterator<Entry<Class<?>, TableInfo>> entries = tables.entrySet().iterator();
		while (entries.hasNext()) {

			Entry<Class<?>, TableInfo> entry = entries.next();
			parseEntry(entry);
		}
	}

	/**
	 * 
	 * @Title: parseEntry
	 * @Description: 初始化tableEntitys
	 * @param entry
	 */
	@SuppressWarnings("unchecked")
	private void parseEntry(Entry<Class<?>, TableInfo> entry) {
		try {
			Class<? extends BaseEntity> entityCls = (Class<? extends BaseEntity>) entry.getKey();
			String tableName = entry.getValue().getTableName().toLowerCase();
			Cache cache = entityCls.getDeclaredAnnotation(Cache.class);
			EntityMetadata metadata = new EntityMetadata(entityCls, cache);
			tableEntitys.put(tableName, metadata);
		} catch (Exception e) {

		}
	}

	/**
	 * 
	 * @Title: save
	 * @Description: 写入缓存
	 * @param metadata
	 * @param afterJson
	 * @param id
	 */
	protected <ENTITY extends BaseEntity> void save(EntityMetadata metadata, JSONObject afterJson, Long id) {
		String key = metadata.genEntityCacheKey(id);
		ENTITY entity = parseJsonToEntity(metadata, afterJson);
		long timeout = metadata.genEntityCacheTimeout();
		redis.opsForValue().set(key, JSONObject.toJSONString(entity), timeout);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除缓存
	 * @param metadata
	 * @param id
	 */
	protected <ENTITY extends BaseEntity> void delete(EntityMetadata metadata, Long id) {
		String key = metadata.genEntityCacheKey(id);
		redis.delete(key);
	}

	/**
	 * 
	 * @Title: parseJsonToEntity
	 * @Description: 将afterJson转换为实体对象
	 * @param metadata
	 * @param afterJson
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <ENTITY extends BaseEntity> ENTITY parseJsonToEntity(EntityMetadata metadata, JSONObject afterJson) {
		return (ENTITY) JSONObject.toJavaObject(afterJson, metadata.getEntityCls());
	}

}
