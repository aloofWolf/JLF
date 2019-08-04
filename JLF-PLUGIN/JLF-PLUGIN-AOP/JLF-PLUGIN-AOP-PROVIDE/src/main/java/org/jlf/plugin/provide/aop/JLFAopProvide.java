package org.jlf.plugin.provide.aop;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.server.api.JLFAop;
import org.jlf.plugin.server.aop.cglib.AopCglibServer;

/**
 * 
 * @ClassName: JLFAopProvide
 * @Description:JLFAopProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFAopProvide implements JLFPluginProvide<JLFAop> {

	@Override
	public Class<? extends JLFPluginServer<JLFAop>> getDefaultServer() {
		return AopCglibServer.class;
	}

}
