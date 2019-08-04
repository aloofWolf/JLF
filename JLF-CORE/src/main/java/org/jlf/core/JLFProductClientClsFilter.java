package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.client.JLFProductClient;

/**
 * 
 * @ClassName: JLFProductClientClsFilter
 * @Description:ɨ��productClient���Ĺ�����
 * @author Lone Wolf
 * @date 2019��7��22��
 */
public class JLFProductClientClsFilter implements PackageUtilFilter {

	@Override
	public boolean doFilter(Class<?> cls) {
		if (JLFProductClient.class.isAssignableFrom(cls)) {
			return false;
		}
		return true;
	}

}
