package org.jlf.core.provide;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.server.JLFPluginServer;

public interface JLFPluginProvide<SERVER_API extends JLFPluginServerApi> {
	
	public Class<? extends JLFPluginServer<SERVER_API>> getDefaultServer();

}
