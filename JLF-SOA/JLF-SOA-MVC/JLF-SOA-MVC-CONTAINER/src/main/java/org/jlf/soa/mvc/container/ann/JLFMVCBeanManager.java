package org.jlf.soa.mvc.container.ann;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @ClassName: JLFMVCBeanManager
 * @Description: JLFMVCBeanManager
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class JLFMVCBeanManager {

	/**
	 * ��Ҫ�����������bean��ע��ļ���
	 */
	private static Set<Class<? extends Annotation>> anns = new HashSet<Class<? extends Annotation>>();


	/**
	 * 
	 * @Title: addAnn
	 * @Description:�����Ҫ�����������bean��ע��
	 * @param annCls
	 */
	@SuppressWarnings("unused")
	private static void addAnn(Class<? extends Annotation> annCls) {
		anns.add(annCls);
	}

	/**
	 * 
	 * @Title: getAnns
	 * @Description:��ȡ��Ҫ�����������bean��ע��ļ���
	 * @return
	 */
	public static Set<Class<? extends Annotation>> getAnns() {
		return anns;
	}
}
