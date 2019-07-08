package org.jlf.plugin.check.wolf.server;

import java.util.HashSet;
import java.util.Set;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.check.wolf.server.core.CheckWolf;
import org.jlf.plugin.json.client.JLFJsonClient;

/**
 * 
 * @ClassName: CheckWolfServer
 * @Description:CheckWolf服务端
 * @author Lone Wolf
 * @date 2019年5月24日
 */
public class CheckWolfServer extends JLFPluginServer<JLFCheck> {

	@Override
	public JLFCheck getServerApi() {
		return new CheckWolf();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFJsonClient.class);
		return set;
	}

}
