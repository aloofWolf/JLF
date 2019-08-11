package org.jlf.soa.mvc.container.ann;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: JLFMVCBeanManager
 * @Description: JLFMVCBeanManager
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class JLFMVCBeanManager {

	/**
	 * 需要被容器管理的bean的注解的集合
	 */
	private static Set<Class<? extends Annotation>> anns = new HashSet<Class<? extends Annotation>>();


	/**
	 * 
	 * @Title: addAnn
	 * @Description:添加需要被容器管理的bean的注解
	 * @param annCls
	 */
	@SuppressWarnings("unused")
	private static void addAnn(Class<? extends Annotation> annCls) {
		anns.add(annCls);
	}

	/**
	 * 
	 * @Title: getAnns
	 * @Description:获取需要被容器管理的bean的注解的集合
	 * @return
	 */
	public static Set<Class<? extends Annotation>> getAnns() {
		return anns;
	}
}
