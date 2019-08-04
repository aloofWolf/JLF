package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.server.JLFSoaServer;

/**
 * 
 * @ClassName: JLFSoaServerClsFilter
 * @Description:ɨ��soaServer���Ĺ�����
 * @author Lone Wolf
 * @date 2019��7��22��
 */
public class JLFSoaServerClsFilter implements PackageUtilFilter {

	@Override
	public boolean doFilter(Class<?> cls) {
		if (JLFSoaServer.class.isAssignableFrom(cls)) {
			return false;
		}
		return true;
	}

}
