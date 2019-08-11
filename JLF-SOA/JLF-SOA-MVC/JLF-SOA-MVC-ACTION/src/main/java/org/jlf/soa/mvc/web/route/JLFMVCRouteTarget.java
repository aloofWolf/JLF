package org.jlf.soa.mvc.web.route;

import java.lang.reflect.Method;

import org.jlf.soa.mvc.web.ann.JLFMVCRouteMethod;

/**
 * 
 * @ClassName: JLFMVCRouteTarget
 * @Description:·��Ŀ����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCRouteTarget {

	private String packageName; // ·�ɰ�������
	private Class<?> webCls; // ·�����class����
	private Object webObj; // ·�������
	private Method method;// ·�ɷ���
	private Class<?> checkCls;// ·�ɷ���У�����class�Գ�
	private JLFMVCRouteMethod routeMethodAnn;// ·�ɷ�����ע��

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
