package org.jlf.soa.mvc.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.ReflectUtil;
import org.jlf.plugin.aop.client.JLFAopClient;

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
	public static <SERVICE extends JLFMVCService<?, ?>> SERVICE getService(Class<SERVICE> serviceCls) {
		try{
			SERVICE service = (SERVICE) servicesMap.get(serviceCls);
			if (service == null) {
				service = JLFAopClient.get().getProxy(serviceCls, new JLFMVCServiceAopDo());
				service.init();
				servicesMap.put(serviceCls, service);
				inject(service);
			}
			return service;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
		
	}

	/**
	 * 
	 * @Title: inject
	 * @Description:��service����ע��
	 * @param t
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked" })
	private static <SERVICE extends JLFMVCService<?, ?>> void inject(SERVICE service) throws Exception {
		Class<? extends Object> cls = service.getClass();
		List<Field> fields = ReflectUtil.getAllFields(cls);
		for (Field field : fields) {
			Class<?> fieldCls = field.getType();
			if (JLFMVCService.class.isAssignableFrom(fieldCls)) {
				JLFMVCService<?, ?> fieldValue = (JLFMVCService<?, ?>) JLFMVCServiceStruc
						.getService((Class<SERVICE>) fieldCls);
				field.setAccessible(true);
				field.set(service, fieldValue);
			}
		}

	}
}
