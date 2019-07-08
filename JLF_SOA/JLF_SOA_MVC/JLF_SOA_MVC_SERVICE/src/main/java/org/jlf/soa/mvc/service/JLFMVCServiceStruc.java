package org.jlf.soa.mvc.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.ReflectUtil;
import org.jlf.plugin.aop.client.JLFAopClient;
import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.dao.JLFMVCDaoStruc;
import org.jlf.soa.mvc.metadata.ann.JLFMVCService;

/**
 * 
 * @ClassName: JLFMVCServiceSign
 * @Description:service������Ĺ���
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCServiceStruc {

	private static final Map<Class<?>, Object> servicesMap = new HashMap<Class<?>, Object>();

	/**
	 * 
	 * @Title: getService
	 * @Description:��ȡserviceʵ��
	 * @param serviceCls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <SERVICE> SERVICE getService(Class<SERVICE> serviceCls) {
		try {
			SERVICE service = (SERVICE) servicesMap.get(serviceCls);
			if (service == null) {
				service = JLFAopClient.get().getProxy(serviceCls, new JLFMVCServiceAopDo());
				servicesMap.put(serviceCls, service);
				inject(service);
			}
			return service;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

	/**
	 * 
	 * @Title: inject
	 * @Description:��service����ע��
	 * @param t
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	private static <SERVICE> void inject(SERVICE service) throws Exception {
		Class<? extends Object> cls = service.getClass();
		List<Field> fields = ReflectUtil.getAllFields(cls);
		for (Field field : fields) {
			Class<?> fieldCls = field.getType();
			JLFMVCService serviceAnn = (JLFMVCService) fieldCls.getAnnotation(JLFMVCService.class);
			if (serviceAnn != null) {
				SERVICE fieldServiceValue = getService((Class<SERVICE>) fieldCls);
				field.setAccessible(true);
				field.set(service, fieldServiceValue);
			}else if(JLFMVCDao.class.isAssignableFrom(fieldCls)){
				JLFMVCDao<?> fieldDaoValue = JLFMVCDaoStruc.getDao((Class<? extends JLFMVCDao<?>>) fieldCls);
				field.setAccessible(true);
				field.set(service, fieldDaoValue);
			}
		}

	}
}
