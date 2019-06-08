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
 * @Description:JLFMVC·�ɹ���
 * @author Lone Wolf
 * @date 2019��5��26��
 */
public class JLFMVCRouteManager {

	private static Map<String, JLFMVCRouteTarget> routes = new HashMap<String, JLFMVCRouteTarget>();// ȫ��·��

	/**
	 * 
	 * @Title: initRoutes
	 * @Description:���������ļ���ʼ��·��
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
			throw new JLFException("MVCδ����·��");
		}
	}

	/**
	 * 
	 * @Title: parsePackage
	 * @Description:���������ļ��еĵ�����
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
	 * @Description:�������е�ÿ��class
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
		}else if(routeClsAnn.type() == 1){ //�ӿڻ����·��,��������
			return;
		}else if(routeClsAnn.type() == 2){ // �ӿڻ����·�ɵ�ʵ��,��ȡ��ǰ����,����ȡ����
			webObj = createWebObj(routeCls);
			routeCls = routeCls.getInterfaces()[0];
			routeClsAnn = (JLFMVCRouteCls) routeCls.getAnnotation(JLFMVCRouteCls.class);
		}else{                             // ��ͨ·��,��ȡ��ǰ����
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
	 * @Description:����·�ɶ���
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
	 * @Description:����class�е�ÿ������
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
	 * @Description:����routeKey�ҵ���ӦJLFMVCRouteTarget
	 * @param routeKey
	 * @return
	 * @throws Exception
	 */
	public static JLFMVCRouteTarget getTarget(String routeKey) throws Exception {
		return routes.get(routeKey);
	}

}
