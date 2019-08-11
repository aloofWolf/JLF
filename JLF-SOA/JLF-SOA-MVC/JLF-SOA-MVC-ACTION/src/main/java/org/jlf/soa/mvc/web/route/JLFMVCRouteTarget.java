package org.jlf.soa.mvc.web.route;

import java.lang.reflect.Method;

import org.jlf.soa.mvc.web.ann.JLFMVCRouteMethod;

/**
 * 
 * @ClassName: JLFMVCRouteTarget
 * @Description:路由目标类
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMVCRouteTarget {

	private String packageName; // 路由包的名称
	private Class<?> webCls; // 路由类的class对象
	private Object webObj; // 路由类对象
	private Method method;// 路由方法
	private Class<?> checkCls;// 路由方法校验类的class对称
	private JLFMVCRouteMethod routeMethodAnn;// 路由方法的注解

	public JLFMVCRouteTarget(String packageName, Class<?> webCls, Object webObj, Method method, Class<?> checkCls,
			JLFMVCRouteMethod routeMethodAnn) {
		this.packageName = packageName;
		this.webCls = webCls;
		this.webObj = webObj;
		this.method = method;
		this.checkCls = checkCls;
		this.routeMethodAnn = routeMethodAnn;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Class<?> getWebCls() {
		return webCls;
	}

	public void setWebCls(Class<?> webCls) {
		this.webCls = webCls;
	}

	public Object getWebObj() {
		return webObj;
	}

	public void setWebObj(Object webObj) {
		this.webObj = webObj;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Class<?> getCheckCls() {
		return checkCls;
	}

	public void setCheckCls(Class<?> checkCls) {
		this.checkCls = checkCls;
	}

	public JLFMVCRouteMethod getRouteMethodAnn() {
		return routeMethodAnn;
	}

	public void setRouteMethodAnn(JLFMVCRouteMethod routeMethodAnn) {
		this.routeMethodAnn = routeMethodAnn;
	}

}
