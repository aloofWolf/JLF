package org.jlf.soa.mvc.web.route;

import java.lang.reflect.Method;

import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

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
	private JLFMVCRoute routeMethodAnn;// 路由方法的注解

	public JLFMVCRouteTarget(String packageName, Class<?> webCls, Object webObj, Method method, 
			JLFMVCRoute routeMethodAnn) {
		this.packageName = packageName;
		this.webCls = webCls;
		this.webObj = webObj;
		this.method = method;
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
	
	public JLFMVCRoute getRouteMethodAnn() {
		return routeMethodAnn;
	}

	public void setRouteMethodAnn(JLFMVCRoute routeMethodAnn) {
		this.routeMethodAnn = routeMethodAnn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
		result = prime * result + ((routeMethodAnn == null) ? 0 : routeMethodAnn.hashCode());
		result = prime * result + ((webCls == null) ? 0 : webCls.hashCode());
		result = prime * result + ((webObj == null) ? 0 : webObj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JLFMVCRouteTarget other = (JLFMVCRouteTarget) obj;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		if (routeMethodAnn == null) {
			if (other.routeMethodAnn != null)
				return false;
		} else if (!routeMethodAnn.equals(other.routeMethodAnn))
			return false;
		if (webCls == null) {
			if (other.webCls != null)
				return false;
		} else if (!webCls.equals(other.webCls))
			return false;
		if (webObj == null) {
			if (other.webObj != null)
				return false;
		} else if (!webObj.equals(other.webObj))
			return false;
		return true;
	}

	
}
