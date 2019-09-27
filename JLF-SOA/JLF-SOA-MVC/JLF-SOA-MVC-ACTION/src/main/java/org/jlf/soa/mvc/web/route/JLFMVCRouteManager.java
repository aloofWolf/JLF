package org.jlf.soa.mvc.web.route;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jlf.common.util.PackageUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: JLFMVCRouteManager
 * @Description:JLFMVC·�ɹ���
 * @author Lone Wolf
 * @date 2019��5��26��
 */
public class JLFMVCRouteManager {

	private static Set<Class<?>> disabledRouteCls = new HashSet<Class<?>>();

	private static Set<Method> disabledRouteMethod = new HashSet<Method>();

	private static Map<String, JLFMVCRouteTarget> routes = new HashMap<String, JLFMVCRouteTarget>();// ȫ��·��

	/**
	 * 
	 * @Title: parseRoute
	 * @Description:����route
	 * @param packageName
	 * @param routeCls
	 */
	@SuppressWarnings("unused")
	private static void parseRoute(Class<?> routeCls) {

		// �ȿ���class�Ƿ񱻽���
		if (disabledRouteCls.contains(routeCls)) {
			return;
		}

		JLFMVCRoute routeAnn = (JLFMVCRoute) routeCls.getAnnotation(JLFMVCRoute.class);
		Object webObj = null;
		if (routeAnn == null) {
			if (routeAnn == null) {
				throw new JLFException("routeClsδ��ע���ʶ,���ܷ�������:" + routeCls.getName());
			}
		}
		webObj = JLFMVCBeanContainer.get(routeCls);
		String routeName = routeAnn.name();

		if (routeAnn.routeClsType() == 2) { // ���routeCls����Ϊ����,���ȡ���ĸ���
			routeCls = routeCls.getInterfaces()[0];
			if (disabledRouteCls.contains(routeCls)) { // �����ӿ��Ƿ񱻽���
				return;
			}
		}
		List<Method> methods = ReflectUtil.getAllMethods(routeCls, Object.class);
		for (Method routeMethod : methods) {
			parseMethod(routeCls, routeMethod, routeName, webObj);
		}
	}

	/**
	 * 
	 * @Title: parseMethod
	 * @Description:����class�е�ÿ������
	 * @param routeCls
	 * @param routeMethod
	 * @param routeName
	 * @param webObj
	 */
	private static void parseMethod(Class<?> routeCls, Method routeMethod, String routeName, Object webObj) {

		if (disabledRouteMethod.contains(routeMethod)) { // ��routeMethod�Ƿ񱻽���
			return;
		}

		String methodName = routeMethod.getName();
		String contextPath = JLFMVCRoute.contextPath;
		JLFMVCRoute routeMethodAnn = routeMethod.getAnnotation(JLFMVCRoute.class);
		if (routeMethodAnn != null && routeMethodAnn.name() != null && routeMethodAnn.name().length() > 0) {
			methodName = routeMethodAnn.name();
			contextPath = routeMethodAnn.contextPath();
		}
		String routeKey = new StringBuffer("/").append(contextPath).append("/").append(routeName).append(methodName)
				.toString();
		JLFMVCRouteTarget target = new JLFMVCRouteTarget(PackageUtil.getPackageName(routeCls), routeCls, webObj,
				routeMethod, routeMethodAnn);
		if (routes.containsKey(routeKey)) {
			if (target.equals(routes.get(routeKey))) {
				return;
			} else {
				throw new JLFException("·���ظ�:" + routeKey);
			}
		}
		routes.put(routeKey, target);
	}

	/**
	 * 
	 * @Title: getTarget
	 * @Description:����routeKey�ҵ���ӦJLFMVCRouteTarget
	 * @param routeKey
	 * @return
	 */
	public static JLFMVCRouteTarget getTarget(String routeKey) {
		return routes.get(routeKey);
	}

	/**
	 * 
	 * @Title: disabledRouteCls
	 * @Description: ����·����
	 * @param routeCls
	 */
	public static void disabledRouteCls(Class<?> routeCls) {
		disabledRouteCls.add(routeCls);
	}

	/**
	 * 
	 * @Title: disabledRouteMethod
	 * @Description: ����·�ɷ���
	 * @param routeMethod
	 */
	public static void disabledRouteMethod(Method routeMethod) {
		disabledRouteMethod.add(routeMethod);
	}

}
