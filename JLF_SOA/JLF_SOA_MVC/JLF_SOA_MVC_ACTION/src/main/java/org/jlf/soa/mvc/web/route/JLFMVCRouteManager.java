package org.jlf.soa.mvc.web.route;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.IniUtil;
import org.jlf.common.util.PackageUtil;
import org.jlf.common.util.ReflectUtil;
import org.jlf.common.util.SingletonUtil;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;
import org.jlf.soa.mvc.service.JLFMVCService;
import org.jlf.soa.mvc.service.JLFMVCServiceStruc;

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
	 * @Title: initRoutes
	 * @Description:根据配置文件初始化路由
	 * @param config
	 * @throws Exception
	 */
	public static void initRoutes(IniUtil ini) throws Exception {
		Properties packages = ini.getSection("routes");
		if (packages != null) {
			for (Enumeration<Object> keys = packages.keys(); keys.hasMoreElements();) {
				String packageKey = (String) keys.nextElement();
				String packageValue = packages.getProperty(packageKey);
				parsePackage(packageKey, packageValue);
			}
		} else {
			throw new JLFException("MVC未配置路由");
		}
	}

	/**
	 * 
	 * @Title: parsePackage
	 * @Description:解析配置文件中的单个包
	 * @param packageKey
	 * @param packageValue
	 * @throws Exception
	 */
	private static void parsePackage(String packageKey, String packageValue) throws Exception {
		List<Class<?>> clss = PackageUtil.getPackageClss(packageValue);
		for (Class<?> routeCls : clss) {
			parseCls(packageKey, packageValue, routeCls);
		}
	}

	/**
	 * 
	 * @Title: parseCls
	 * @Description:解析包中的每个class
	 * @param packageKey
	 * @param packageValue
	 * @param routeCls
	 * @throws Exception
	 */
	private static void parseCls(String packageKey, String packageValue, Class<?> routeCls) throws Exception {

		JLFMVCRouteCls routeClsAnn = (JLFMVCRouteCls) routeCls.getAnnotation(JLFMVCRouteCls.class);
		Object webObj = null;
		if (routeClsAnn == null) {
			return;
		}else if(routeClsAnn.type() == 1){ //接口或抽象路由,不做处理
			return;
		}else if(routeClsAnn.type() == 2){ // 接口或抽象路由的实现,获取当前对象,并获取父类
			webObj = createWebObj(routeCls);
			routeCls = routeCls.getInterfaces()[0];
			routeClsAnn = (JLFMVCRouteCls) routeCls.getAnnotation(JLFMVCRouteCls.class);
		}else{                             // 普通路由,获取当前对象
			webObj = createWebObj(routeCls);
		}
		String webName = routeCls.getSimpleName();
		if (routeClsAnn.name() != null && routeClsAnn.name().length() > 0) {
			webName = routeClsAnn.name();
		}
		List<Method> methods = ReflectUtil.getAllMethods(routeCls, Object.class);
		for (Method routeMethod : methods) {
			parseMethod(packageKey, packageValue, routeCls, routeMethod, webName, webObj);
		}
	}

	/**
	 * 
	 * @Title: createWebObj
	 * @Description:创建路由对象
	 * @param routeCls
	 * @return
	 * @throws Exception
	 */
	private static Object createWebObj(Class<?> routeCls) throws Exception {
		Object webObj = SingletonUtil.getInstance(routeCls);
		List<Field> fields = ReflectUtil.getAllFields(routeCls);
		for (Field field : fields) {
			Class<?> fieldCls = field.getType();
			if (JLFMVCService.class.isAssignableFrom(fieldCls)) {
				@SuppressWarnings("unchecked")
				JLFMVCService<?, ?> fieldValue = (JLFMVCService<?, ?>) JLFMVCServiceStruc
						.getService((Class<? extends JLFMVCService<?, ?>>) fieldCls);
				field.setAccessible(true);
				field.set(webObj, fieldValue);
			}
		}
		return webObj;
	}

	/**
	 * 
	 * @Title: parseMethod
	 * @Description:解析class中的每个方法
	 * @param packageKey
	 * @param packageValue
	 * @param routeCls
	 * @param routeMethod
	 * @param webName
	 * @param webObj
	 * @throws Exception
	 */
	private static void parseMethod(String packageKey, String packageValue, Class<?> routeCls, Method routeMethod,
			String webName, Object webObj) throws Exception {
		Class<?>[] paramterTypes = routeMethod.getParameterTypes();
		if (paramterTypes.length != 1) {
			return;
		}

		Class<?> paramType = paramterTypes[0];
		if(!JLFMVCRequest.class.isAssignableFrom(paramType)){
			return;
		}

		String methodName = routeMethod.getName();
		JLFMVCRouteMethod routeMethodAnn = routeMethod.getAnnotation(JLFMVCRouteMethod.class);
		if (routeMethodAnn != null && routeMethodAnn.name() != null && routeMethodAnn.name().length() > 0) {
			methodName = routeMethodAnn.name();
		}
		String routeSource = new StringBuffer(packageKey).append("_").append(webName).append("_").append(methodName)
				.toString();
		JLFMVCRouteTarget target = new JLFMVCRouteTarget(packageValue, routeCls, webObj, routeMethod, paramterTypes[0],
				routeMethodAnn);
		routes.put(routeSource, target);
	}

	/**
	 * 
	 * @Title: getTarget
	 * @Description:根据routeKey找到对应JLFMVCRouteTarget
	 * @param routeKey
	 * @return
	 * @throws Exception
	 */
	public static JLFMVCRouteTarget getTarget(String routeKey) throws Exception {
		return routes.get(routeKey);
	}

}
