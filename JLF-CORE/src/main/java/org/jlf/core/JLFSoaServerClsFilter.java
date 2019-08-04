package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.server.JLFSoaServer;

/**
 * 
 * @ClassName: JLFSoaServerClsFilter
 * @Description:扫描soaServer包的过滤器
 * @author Lone Wolf
 * @date 2019年7月22日
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
