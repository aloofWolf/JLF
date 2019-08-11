package org.jlf.soa.mvc.web.route;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.PackageUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;
import org.jlf.soa.mvc.web.ann.JLFMVCRouteMethod;

/**
 * 
 * @ClassName: JLFMVCRouteManager
 * @Description:JLFMVC路由管理
 * @author Lone Wolf
 * @date 2019年5月26日
 */
public class JLFMVCRouteManager {

	private static Map<String, JLFMVCRouteTarget> routes = new HashMap<String, JLFMVCRouteTarget>();// 全部路由

	/**
	 * 
	 * @Title: parseRoute
	 * @Description:解析route
	 * @param packageName
	 * @param routeCls
	 */
	@SuppressWarnings("unused")
	private static void parseRoute(Class<?> routeCls) {

		JLFMVCRoute routeAnn = (JLFMVCRoute) routeCls.getAnnotation(JLFMVCRoute.class);
		Object webObj = null;
		if (routeAnn == null) {
			if(routeAnn == null){
				throw new JLFException("routeCls未被注解标识,不能放入容器:"+routeCls.getName());
			}
		} 
		webObj = JLFMVCBeanContainer.get(routeCls);
		String routeName = routeAnn.name();

		List<Method> methods = ReflectUtil.getAllMethods(routeCls, Object.class);
		for (Method routeMethod : methods) {
			parseMethod(routeCls, routeMethod, routeName, webObj);
		}
	}


	/**
	 * 
	 * @Title: parseMethod
	 * @Description:解析class中的每个方法
	 * @param routeCls
	 * @param routeMethod
	 * @param routeName
	 * @param webObj
	 */
	private static void parseMethod(Class<?> routeCls, Method routeMethod, String routeName,
			Object webObj) {
		Class<?>[] paramterTypes = routeMethod.getParameterTypes();
		if (paramterTypes.length != 1) {
			return;
		}

		Class<?> paramType = paramterTypes[0];
		if (!JLFMVCRequest.class.isAssignableFrom(paramType)) {
			return;
		}

		String methodName = routeMethod.getName();
		JLFMVCRouteMethod routeMethodAnn = routeMethod.getAnnotation(JLFMVCRouteMethod.class);
		if (routeMethodAnn != null && routeMethodAnn.name() != null && routeMethodAnn.name().length() > 0) {
			methodName = routeMethodAnn.name();
		}
		String routeKey = new StringBuffer(routeName).append(methodName).toString();
		JLFMVCRouteTarget target = new JLFMVCRouteTarget(PackageUtil.getPackageName(routeCls), routeCls, webObj, routeMethod, paramterTypes[0],
				routeMethodAnn);
		routes.put(routeKey, target);
	}

	/**
	 * 
	 * @Title: getTarget
	 * @Description:根据routeKey找到对应JLFMVCRouteTarget
	 * @param routeKey
	 * @return
	 */
	public static JLFMVCRouteTarget getTarget(String routeKey) {
		return routes.get(routeKey);
	}

}
