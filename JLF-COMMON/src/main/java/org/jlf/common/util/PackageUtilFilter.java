package org.jlf.common.util;

/**
 * 
 * @ClassName: PackageUtilFilter
 * @Description:PackageUtil������
 * @author Lone Wolf
 * @date 2019��7��21��
 */
public interface PackageUtilFilter {

	/**
	 * 
	 * @Title: doFilter
	 * @Description:��ȡ���µ�����class��ʱ,���˵�ָ��cls
	 * @param cls
	 * @return
	 */
	public boolean doFilter(Class<?> cls);

}
