package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.client.JLFPluginClient;

/**
 * 
 * @ClassName: JLFPluginClientClsFilter
 * @Description:扫描pluginClient包的过滤器
 * @author Lone Wolf
 * @date 2019年7月21日
 */
public class JLFPluginClientClsFilter implements PackageUtilFilter {

	@Override
	public boolean doFilter(Class<?> cls) {
		if (JLFPluginClient.class.isAssignableFrom(cls)) {
			return false;
		}
		return true;
	}

}
