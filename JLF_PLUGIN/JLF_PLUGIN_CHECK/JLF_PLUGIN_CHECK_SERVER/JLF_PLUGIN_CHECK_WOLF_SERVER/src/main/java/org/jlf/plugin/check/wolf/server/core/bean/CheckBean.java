package org.jlf.plugin.check.wolf.server.core.bean;

import java.lang.reflect.Method;
import java.util.List;

import org.jlf.plugin.check.wolf.server.core.detail.ICheck;

/**
 * 
 * @ClassName: CheckBean
 * @Description:CheckBean
 * @author Lone Wolf
 * @date 2019��5��24��
 * @param <C>
 */
public class CheckBean<C extends ICheck<?>> {

	private Class<?> cls; // ICheck�������class����

	private C obj; // ICheck������Ķ���

	private List<Method> methods; // ICheck������Ķ�������Ҫcheck�����з���

	public CheckBean(Class<?> cls, C obj, List<Method> methods) {
		super();
		this.cls = cls;
		this.obj = obj;
		this.methods = methods;
	}

	@SuppressWarnings("unchecked")
	public Class<C> getCls() {
		return (Class<C>) cls;
	}

	public void setCls(Class<C> cls) {
		this.cls = cls;
	}

	public C getObj() {
		return obj;
	}

	public void setObj(C obj) {
		this.obj = obj;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

}
