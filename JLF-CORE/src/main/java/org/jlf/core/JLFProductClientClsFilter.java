package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.client.JLFProductClient;

/**
 * 
 * @ClassName: JLFProductClientClsFilter
 * @Description:扫描productClient包的过滤器
 * @author Lone Wolf
 * @date 2019年7月22日
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
