package org.jlf.plugin.check.wolf.server.core.detail.fac;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.enums.api.IEnum;
import org.jlf.common.exception.JLFException;
import org.jlf.common.util.ClassUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.check.wolf.server.core.bean.CheckBean;
import org.jlf.plugin.check.wolf.server.core.detail.CustomerCheck;
import org.jlf.plugin.check.wolf.server.core.detail.DateCheck;
import org.jlf.plugin.check.wolf.server.core.detail.EnumCheck;
import org.jlf.plugin.check.wolf.server.core.detail.ICheck;
import org.jlf.plugin.check.wolf.server.core.detail.StringCheck;
import org.jlf.plugin.check.wolf.server.core.detail.collection.ListCheck;
import org.jlf.plugin.check.wolf.server.core.detail.collection.MapCheck;
import org.jlf.plugin.check.wolf.server.core.detail.number.BigDecimalCheck;
import org.jlf.plugin.check.wolf.server.core.detail.number.ByteCheck;
import org.jlf.plugin.check.wolf.server.core.detail.number.DoubleCheck;
import org.jlf.plugin.check.wolf.server.core.detail.number.FloatCheck;
import org.jlf.plugin.check.wolf.server.core.detail.number.IntegerCheck;
import org.jlf.plugin.check.wolf.server.core.detail.number.LongCheck;
import org.jlf.plugin.check.wolf.server.core.detail.number.ShortCheck;

/**
 * 
 * @ClassName: CheckBeanFactory
 * @Description:获取checkbean的工厂类
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class CheckBeanFactory {

	/**
	 * key: ICheck的具体子类的class对象 value: checkBean对称
	 */
	private static Map<Class<?>, CheckBean<?>> checks = new HashMap<Class<?>, CheckBean<?>>();

	/**
	 * 
	 * @Title: getCheckBean
	 * @Description:根据fieldCls获取checkBean
	 * @param fieldCls
	 * @return
	 * @throws Exception
	 */
	public static CheckBean<?> getCheckBean(Class<?> fieldCls) {

		if (fieldCls.equals(Byte.class)) {
			return createCheckBean(ByteCheck.class);
		} else if (fieldCls.equals(Short.class)) {
			return createCheckBean(ShortCheck.class);
		} else if (fieldCls.equals(Integer.class)) {
			return createCheckBean(IntegerCheck.class);
		} else if (fieldCls.equals(Long.class)) {
			return createCheckBean(LongCheck.class);
		} else if (fieldCls.equals(Double.class)) {
			return createCheckBean(DoubleCheck.class);
		} else if (fieldCls.equals(Float.class)) {
			return createCheckBean(FloatCheck.class);
		} else if (fieldCls.equals(BigDecimal.class)) {
			return createCheckBean(BigDecimalCheck.class);
		} else if (fieldCls.equals(String.class)) {
			return createCheckBean(StringCheck.class);
		} else if (fieldCls.equals(Date.class)) {
			return createCheckBean(DateCheck.class);
		} else if (fieldCls.equals(Map.class)) {
			return createCheckBean(MapCheck.class);
		} else if (fieldCls.equals(List.class)) {
			return createCheckBean(ListCheck.class);
		} else if (IEnum.class.isAssignableFrom(fieldCls)) {
			return createCheckBean(EnumCheck.class);
		} else if (ClassUtil.clsIsCustom(fieldCls)) {
			return createCheckBean(CustomerCheck.class);
		} else {
			throw new JLFException("暂未支持此类型:" + fieldCls);
		}

	}

	/**
	 * 
	 * @Title: createCheckBean
	 * @Description:根据fieldCls生成checkbean
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static <C extends ICheck<?>> CheckBean<?> createCheckBean(Class<?> cls) {
		CheckBean<?> bean = checks.get(cls);
		if (bean == null) {
			C c;
			try {
				c = (C) cls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
			List<Method> allMethods = ReflectUtil.getAllMethods(cls);
			List<Method> checkMethods = new ArrayList<Method>();
			for (Method method : allMethods) {
				JLFCheckAnn ann = method.getAnnotation(JLFCheckAnn.class);
				if (ann != null) {
					checkMethods.add(method);
				}
			}
			bean = new CheckBean<C>(cls, c, checkMethods);
			checks.put((Class<C>) cls, bean);
		}
		return bean;
	}

}
