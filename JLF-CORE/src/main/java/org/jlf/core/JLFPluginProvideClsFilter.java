package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.provide.JLFPluginProvide;

/**
 * 
 * @ClassName: JLFPluginProvideClsFilter
 * @Description:扫描pluginProvide包的过滤器
 * @author Lone Wolf
 * @date 2019年8月3日
 */
public class JLFPluginProvideClsFilter implements PackageUtilFilter {

	@Override
	public boolean doFilter(Class<?> cls) {
		if (JLFPluginProvide.class.isAssignableFrom(cls)) {
			return false;
		}
		return true;
	}

}
