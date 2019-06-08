package org.jlf.soa.mvc.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: JLFMVCServiceSign
 * @Description:service������Ĺ���
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCDaoStruc {

	private static final Map<Class<?>, Object> daosMap = new HashMap<Class<?>, Object>();// �ѹ���õ�daoʵ��

	/**
	 * 
	 * @Title: getDao
	 * @Description:��ȡdaoʵ��
	 * @param daoCls
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <DAO extends JLFMVCDao<?>> DAO getDao(Class<DAO> daoCls) throws Exception {
		DAO dao = (DAO) daosMap.get(daoCls);
		if (dao == null) {
			dao = daoCls.newInstance();
			dao.init();
			daosMap.put(daoCls, dao);
		}
		return dao;
	}
}
