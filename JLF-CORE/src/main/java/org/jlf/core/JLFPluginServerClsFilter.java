package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.server.JLFPluginServer;

/**
 * 
 * @ClassName: JLFPluginServerClsFilter
 * @Description:ɨ��pluginServer���Ĺ�����
 * @author Lone Wolf
 * @date 2019��7��22��
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
