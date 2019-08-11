package org.jlf.plugin.server.check.custom;

import java.util.HashSet;
import java.util.Set;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.client.json.JLFJsonClient;
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

	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFJsonClient.class);
		return depends;
		
	}
}
