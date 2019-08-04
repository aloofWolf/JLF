package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.server.JLFPluginServer;

/**
 * 
 * @ClassName: JLFPluginServerClsFilter
 * @Description:扫描pluginServer包的过滤器
 * @author Lone Wolf
 * @date 2019年7月22日
 */
public class JLFPluginServerClsFilter implements PackageUtilFilter {

	@Override
	public boolean doFilter(Class<?> cls) {
		if (JLFPluginServer.class.isAssignableFrom(cls)) {
			return false;
		}
		return true;
	}

}
