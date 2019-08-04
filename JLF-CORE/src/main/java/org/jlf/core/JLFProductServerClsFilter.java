package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.server.JLFProductServer;

/**
 * 
 * @ClassName: JLFProductServerClsFilter
 * @Description:ɨ��productServer���Ĺ�����
 * @author Lone Wolf
 * @date 2019��7��22��
 */
public class JLFProductServerClsFilter implements PackageUtilFilter {

	@Override
	public boolean doFilter(Class<?> cls) {
		if (JLFProductServer.class.isAssignableFrom(cls)) {
			return false;
		}
		return true;
	}

}
