package org.jlf.plugin.provide.aop;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.server.check.custom.CheckCustomServer;

/**
 * 
 * @ClassName: JLFCheckProvide
 * @Description:JLFCheckProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFCheckProvide implements JLFPluginProvide<JLFCheck> {

	@Override
	public Class<? extends JLFPluginServer<JLFCheck>> getDefaultServer() {
		return CheckCustomServer.class;
	}

}
