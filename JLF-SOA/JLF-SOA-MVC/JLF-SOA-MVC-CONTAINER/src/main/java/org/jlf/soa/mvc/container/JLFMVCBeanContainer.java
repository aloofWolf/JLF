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
 * @Description: bean容器
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class JLFMVCBeanContainer {

	/**
	 * 存放bean的map
	 */
	private static final Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>(1024);

	/**
	 * 存放bean生成器的map
	 */
	private static final Map<Class<?>, Object> generateMap = new HashMap<Class<?>, Object>();

	private static final Set<Class<? extends Annotation>> beanAnns = JLFMVCBeanManager.getAnns();

	private static <T> Object putBean(Class<T> cls, JLFMVCBean beanAnn) {

		try {
			/**
			 * 如果容器中已经存在该cls,直接返回
			 */
			if (beanMap.containsKey(cls)) {
				return beanMap.get(cls);
			}

			/**
			 * 获取bean生成器
			 */
			Class<?> generateCls = beanAnn.generate();
			if (!JLFMVCBeanGenerate.class.isAssignableFrom(generateCls)) {
				throw new JLFException("bean生成器指定有误:" + cls.getName());
			}
			JLFMVCBeanGenerate generate = (JLFMVCBeanGenerate) generateMap.get(generateCls);
			if (generate == null) {
				generate = (JLFMVCBeanGenerate) generateCls.newInstance();
				generateMap.put(generateCls, generate);
			}

			/**
			 * 利用bean生成器创建对象
			 */
			T obj = generate.beanGenerate(cls);

			/**
			 * 将对象放入容器
			 */
			beanMap.put(cls, obj);

			/**
			 * 对对象做依赖注入
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
	 * @Description:对所有字段进行依赖注入
	 * @param beanCls
	 * @param bean
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> void injects(Class<T> beanCls, T bean) throws IllegalArgumentException, IllegalAccessException {
		List<Field> fields = ReflectUtil.getAllFields(beanCls);
		for (Field field : fields) {
			/**
			 * 修改字段访问权限
			 */
			boolean isAccessible = field.isAccessible();
			if (!isAccessible) {
				field.setAccessible(true);
			}

			/**
			 * 获取字段value,如果value为空,则注入,否则不注入
			 */
			Object fieldValue = field.get(bean);
			if (fieldValue == null) {
				fieldValue = inject(field.getType());
				if (fieldValue != null) {
					field.set(bean, fieldValue);
				}
			}

			/**
			 * 修改字段访问权限
			 */
			if (!isAccessible) {
				field.setAccessible(false);
			}

		}
	}

	/**
	 * 
	 * @Title: inject
	 * @Description:对指定字段进行依赖注入
	 * @param fieldCls
	 * @return
	 */
	public static Object inject(Class<?> fieldCls) {

		/**
		 * fieldCls为注解、抽象类、接口、注解不扫描
		 */
		if (fieldCls.isAnnotation() || fieldCls.isAnonymousClass() || fieldCls.isInterface() || fieldCls.isEnum()) {
			return null;
		}

		/**
		 * 被JLFMVCBean注解标注饿fieldCls进行初始化
		 */
		JLFMVCBean jJLFMVCBean = (JLFMVCBean) fieldCls.getAnnotation(JLFMVCBean.class);
		if (jJLFMVCBean != null) {
			return putBean(fieldCls, jJLFMVCBean);
		}

		/**
		 * 遍历需要被扫描的bean的注解,如果fieldCls被其中一个注解标注,进行初始化
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
	 * @Description:从容器中获取cls对应的对象
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
