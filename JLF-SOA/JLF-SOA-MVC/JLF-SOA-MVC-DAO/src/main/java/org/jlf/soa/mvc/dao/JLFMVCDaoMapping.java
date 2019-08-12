package org.jlf.soa.mvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.jlf.core.exception.JLFException;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: JLFMVCDaoMapping
 * @Description: 数据库表名、实体、DAO 三者之间的映射关系
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class JLFMVCDaoMapping {

	/**
	 * 数据库表与实体之间的映射,如果有分表情况,可向此map中添加映射
	 */
	private static Map<String, Class<? extends JLFMVCEntity>> tableNameEntityMapping = new HashMap<String, Class<? extends JLFMVCEntity>>(
			512);

	/**
	 * 实体与dao之间的映射
	 */
	private static Map<Class<? extends JLFMVCEntity>, JLFMVCDao<?>> entityDaoMapping = new HashMap<Class<? extends JLFMVCEntity>, JLFMVCDao<?>>(
			512);

	/**
	 * 数据库表与dao之间的映射
	 */
	private static Map<String, JLFMVCDao<?>> tableNameDaoMapping = new HashMap<String, JLFMVCDao<?>>(
			512);

	/**
	 * 
	 * @Title: addTableNameEntityMapping
	 * @Description:添加数据库表与实体之间的映射
	 * @param tableName
	 * @param entityCls
	 */
	public static <ENTITY extends JLFMVCEntity> void addTableNameEntityMapping(String tableName,
			Class<ENTITY> entityCls) {
		JLFMVCDao<ENTITY> dao = getDao(entityCls);
		if (dao == null) {
			throw new JLFException(String.format("未能找到该实体映射的dao,%s", entityCls.getName()));
		}
		tableNameEntityMapping.put(tableName, entityCls);
		tableNameDaoMapping.put(tableName, dao);

	}

	/**
	 * 
	 * @Title: addEntityDaoMapping
	 * @Description:添加实体与dao之间的映射
	 * @param beanCls
	 * @param dao
	 */
	protected static <ENTITY extends JLFMVCEntity> void addEntityDaoMapping(Class<ENTITY> beanCls,
			JLFMVCDao<ENTITY> dao) {
		entityDaoMapping.put(beanCls, dao);

	}

	/**
	 * 
	 * @Title: getEntityCls
	 * @Description:根据表名获取实体cls
	 * @param tableName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <ENTITY extends JLFMVCEntity> Class<ENTITY> getEntityCls(String tableName) {
		return (Class<ENTITY>) tableNameEntityMapping.get(tableName);
	}

	/**
	 * 
	 * @Title: getDao
	 * @Description:根据表名获取dao
	 * @param tableName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <ENTITY extends JLFMVCEntity> JLFMVCDao<ENTITY> getDaoCls(String tableName) {
		return (JLFMVCDao<ENTITY>) tableNameDaoMapping.get(tableName);
	}

	/**
	 * 
	 * @Title: getDao
	 * @Description:根据实体cls获取dao
	 * @param entityCls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <ENTITY extends JLFMVCEntity> JLFMVCDao<ENTITY> getDao(Class<ENTITY> entityCls) {
		return (JLFMVCDao<ENTITY>) entityDaoMapping.get(entityCls);
	}
}
