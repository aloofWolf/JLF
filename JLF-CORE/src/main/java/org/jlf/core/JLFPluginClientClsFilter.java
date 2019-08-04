package org.jlf.core;

import org.jlf.common.util.PackageUtilFilter;
import org.jlf.core.client.JLFPluginClient;

/**
 * 
 * @ClassName: JLFPluginClientClsFilter
 * @Description:ɨ��pluginClient���Ĺ�����
 * @author Lone Wolf
 * @date 2019��7��21��
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
