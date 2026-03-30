package jlf.orm.metadata.entityMetadata;


import jlf.orm.metadata.ann.Cache;
import jlf.orm.metadata.entity.BaseEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lone Wolf
 * @ClassName: EntityMetadataUtil
 * @Description: 实体类元数据信息的工具类
 * @date 2019年9月10日
 */
public class EntityMetadataUtil {

    /**
     * 实体类的class与对应得EntityMetadata对象的对应关系的map，因为此map为全局变量，会有线程安全问题，
     * 所以采用ConcurrentHashMap
     */
    private static Map<Class<? extends BaseEntity>, EntityMetadata> metadatas = new ConcurrentHashMap<Class<? extends BaseEntity>, EntityMetadata>();

    /**
     * @param entityCls
     * @return
     * @Title: getEntityMetadata
     * @Description: 根据实体的class获取对应的元数据对象
     */
    public static EntityMetadata getEntityMetadata(Class<? extends BaseEntity> entityCls) {
        EntityMetadata metadata = metadatas.get(entityCls);
        if (metadata == null) {
            metadata = genEntityMetadata(entityCls);
        }
        return metadata;
    }

    /**
     * @param entityCls
     * @return
     * @Title: genEntityMetadata
     * @Description: 根据实体的class生成对应的元数据对象
     */
    private static EntityMetadata genEntityMetadata(Class<? extends BaseEntity> entityCls) {
        synchronized (entityCls) {
            EntityMetadata metadata = metadatas.get(entityCls);
            if (metadata == null) {
                Cache cache = entityCls.getDeclaredAnnotation(Cache.class);
                metadata = new EntityMetadata(entityCls, cache);
                metadatas.put(entityCls, metadata);
            }
            return metadata;
        }
    }

}
