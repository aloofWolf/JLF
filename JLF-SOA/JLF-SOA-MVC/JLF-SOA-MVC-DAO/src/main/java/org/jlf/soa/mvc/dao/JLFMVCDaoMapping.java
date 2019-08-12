package org.jlf.soa.mvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.jlf.core.exception.JLFException;
import org.jlf.soa.mvc.metadata.entity.JLFMVCEntity;

/**
 * 
 * @ClassName: JLFMVCDaoMapping
 * @Description: ���ݿ������ʵ�塢DAO ����֮���ӳ���ϵ
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class JLFMVCDaoMapping {

	/**
	 * ���ݿ����ʵ��֮���ӳ��,����зֱ����,�����map�����ӳ��
	 */
	private static Map<String, Class<? extends JLFMVCEntity>> tableNameEntityMapping = new HashMap<String, Class<? extends JLFMVCEntity>>(
			512);

	/**
	 * ʵ����dao֮���ӳ��
	 */
	private static Map<Class<? extends JLFMVCEntity>, JLFMVCDao<?>> entityDaoMapping = new HashMap<Class<? extends JLFMVCEntity>, JLFMVCDao<?>>(
			512);

	/**
	 * ���ݿ����dao֮���ӳ��
	 */
	private static Map<String, JLFMVCDao<?>> tableNameDaoMapping = new HashMap<String, JLFMVCDao<?>>(
			512);

	/**
	 * 
	 * @Title: addTableNameEntityMapping
	 * @Description:������ݿ����ʵ��֮���ӳ��
	 * @param tableName
	 * @param entityCls
	 */
	public static <ENTITY extends JLFMVCEntity> void addTableNameEntityMapping(String tableName,
			Class<ENTITY> entityCls) {
		JLFMVCDao<ENTITY> dao = getDao(entityCls);
		if (dao == null) {
			throw new JLFException(String.format("δ���ҵ���ʵ��ӳ���dao,%s", entityCls.getName()));
		}
		tableNameEntityMapping.put(tableName, entityCls);
		tableNameDaoMapping.put(tableName, dao);

	}

	/**
	 * 
	 * @Title: addEntityDaoMapping
	 * @Description:���ʵ����dao֮���ӳ��
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
	 * @Description:���ݱ�����ȡʵ��cls
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
	 * @Description:���ݱ�����ȡdao
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
	 * @Description:����ʵ��cls��ȡdao
	 * @param entityCls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <ENTITY extends JLFMVCEntity> JLFMVCDao<ENTITY> getDao(Class<ENTITY> entityCls) {
		return (JLFMVCDao<ENTITY>) entityDaoMapping.get(entityCls);
	}
}
