package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.server.JLFProductServer;

/**
 * 
 * @ClassName: JLFProductServerClsFilter
 * @Description:扫描productServer包的过滤器
 * @author Lone Wolf
 * @date 2019年7月22日
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
