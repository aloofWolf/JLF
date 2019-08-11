package org.jlf.soa.mvc.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jlf.common.util.ReflectUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.soa.mvc.container.ann.JLFMVCBean;
import org.jlf.soa.mvc.container.ann.JLFMVCBeanManager;
import org.jlf.soa.mvc.container.generate.JLFMVCBeanGenerate;

/**
 * 
 * @ClassName: JLFMVCBeanContainer
 * @Description: bean����
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class JLFMVCBeanContainer {

	/**
	 * ���bean��map
	 */
	private static final Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>(1024);

	/**
	 * ���bean��������map
	 */
	private static final Map<Class<?>, Object> generateMap = new HashMap<Class<?>, Object>();

	private static final Set<Class<? extends Annotation>> beanAnns = JLFMVCBeanManager.getAnns();

	private static <T> Object putBean(Class<T> cls, JLFMVCBean beanAnn) {

		try {
			/**
			 * ����������Ѿ����ڸ�cls,ֱ�ӷ���
			 */
			if (beanMap.containsKey(cls)) {
				return beanMap.get(cls);
			}

			/**
			 * ��ȡbean������
			 */
			Class<?> generateCls = beanAnn.generate();
			if (!JLFMVCBeanGenerate.class.isAssignableFrom(generateCls)) {
				throw new JLFException("bean������ָ������:" + cls.getName());
			}
			JLFMVCBeanGenerate generate = (JLFMVCBeanGenerate) generateMap.get(generateCls);
			if (generate == null) {
				generate = (JLFMVCBeanGenerate) generateCls.newInstance();
				generateMap.put(generateCls, generate);
			}

			/**
			 * ����bean��������������
			 */
			T obj = generate.beanGenerate(cls);

			/**
			 * �������������
			 */
			beanMap.put(cls, obj);

			/**
			 * �Զ���������ע��
			 */
			injects(cls,obj);
			return obj;

		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

	/**
	 * 
	 * @Title: injects
	 * @Description:�������ֶν�������ע��
	 * @param beanCls
	 * @param bean
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> void injects(Class<T> beanCls, T bean) throws IllegalArgumentException, IllegalAccessException {
		List<Field> fields = ReflectUtil.getAllFields(beanCls);
		for (Field field : fields) {
			/**
			 * �޸��ֶη���Ȩ��
			 */
			boolean isAccessible = field.isAccessible();
			if (!isAccessible) {
				field.setAccessible(true);
			}

			/**
			 * ��ȡ�ֶ�value,���valueΪ��,��ע��,����ע��
			 */
			Object fieldValue = field.get(bean);
			if (fieldValue == null) {
				fieldValue = inject(field.getType());
				if (fieldValue != null) {
					field.set(bean, fieldValue);
				}
			}

			/**
			 * �޸��ֶη���Ȩ��
			 */
			if (!isAccessible) {
				field.setAccessible(false);
			}

		}
	}

	/**
	 * 
	 * @Title: inject
	 * @Description:��ָ���ֶν�������ע��
	 * @param fieldCls
	 * @return
	 */
	public static Object inject(Class<?> fieldCls) {

		/**
		 * fieldClsΪע�⡢�����ࡢ�ӿڡ�ע�ⲻɨ��
		 */
		if (fieldCls.isAnnotation() || fieldCls.isAnonymousClass() || fieldCls.isInterface() || fieldCls.isEnum()) {
			return null;
		}

		/**
		 * ��JLFMVCBeanע���ע��fieldCls���г�ʼ��
		 */
		JLFMVCBean jJLFMVCBean = (JLFMVCBean) fieldCls.getAnnotation(JLFMVCBean.class);
		if (jJLFMVCBean != null) {
			return putBean(fieldCls, jJLFMVCBean);
		}

		/**
		 * ������Ҫ��ɨ���bean��ע��,���fieldCls������һ��ע���ע,���г�ʼ��
		 */
		Annotation beanAnnPer;
		for (Class<? extends Annotation> beanAnnCls : beanAnns) {
			beanAnnPer = fieldCls.getAnnotation(beanAnnCls);
			if (beanAnnPer != null) {
				jJLFMVCBean = beanAnnCls.getAnnotation(JLFMVCBean.class);
				return putBean(fieldCls, jJLFMVCBean);
			}
		}
		return null;

	}

	/**
	 * 
	 * @Title: get
	 * @Description:�������л�ȡcls��Ӧ�Ķ���
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(Class<T> cls) {
		Object obj = beanMap.get(cls);
		if (obj == null) {
			return null;
		}
		return (T) obj;
	}

}
