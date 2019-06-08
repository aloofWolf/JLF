package org.jlf.plugin.check.wolf.server.core.bean;

import java.lang.reflect.Method;
import java.util.List;

import org.jlf.plugin.check.wolf.server.core.detail.ICheck;

/**
 * 
 * @ClassName: CheckBean
 * @Description:CheckBean
 * @author Lone Wolf
 * @date 2019年5月24日
 * @param <C>
 */
public class CheckBean<C extends ICheck<?>> {

	private Class<?> cls; // ICheck具体类的class对象

	private C obj; // ICheck具体类的对象

	private List<Method> methods; // ICheck具体类的对象中需要check的所有方法

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
