package org.jlf.plugin.server.check.custom;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.server.core.check.custom.CheckCustom;

/**
 * 
 * @ClassName: CheckWolfServer
 * @Description:CheckWolf服务端
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class CheckCustomServer extends JLFPluginServer<JLFCheck> {

	@Override
	public JLFCheck getServerApi() {
		return new CheckCustom();
	}

}
