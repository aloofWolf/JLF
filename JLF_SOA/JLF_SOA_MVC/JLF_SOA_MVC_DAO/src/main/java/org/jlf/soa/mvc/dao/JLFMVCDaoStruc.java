package org.jlf.soa.mvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.jlf.common.exception.JLFException;

/**
 * 
 * @ClassName: JLFMVCServiceSign
 * @Description:service单例类的构造
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMVCDaoStruc {

	private static final Map<Class<?>, Object> daosMap = new HashMap<Class<?>, Object>();// 已构造好的dao实例

	/**
	 * 
	 * @Title: getDao
	 * @Description:获取dao实例
	 * @param daoCls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <DAO extends JLFMVCDao<?>> DAO getDao(Class<DAO> daoCls) {
		DAO dao = (DAO) daosMap.get(daoCls);
		if (dao == null) {
			try {
				dao = daoCls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
			dao.init();
			daosMap.put(daoCls, dao);
		}
		return dao;
	}
}
