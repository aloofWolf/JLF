package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.provide.JLFPluginProvide;

/**
 * 
 * @ClassName: JLFPluginProvideClsFilter
 * @Description:ɨ��pluginProvide���Ĺ�����
 * @author Lone Wolf
 * @date 2019��8��3��
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
