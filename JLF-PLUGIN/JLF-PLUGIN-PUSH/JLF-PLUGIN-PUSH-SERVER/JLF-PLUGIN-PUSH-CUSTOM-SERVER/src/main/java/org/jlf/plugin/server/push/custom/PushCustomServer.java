package org.jlf.plugin.server.push.custom;

import java.util.HashSet;
import java.util.Set;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.push.server.api.JLFPush;
import org.jlf.plugin.server.core.push.custom.PushCustomCore;
import org.jlf.plugin.server.core.push.custom.manager.ChannelManager;

/**
 * 
 * @ClassName: PushCustomServer
 * @Description:PushCustom 服务端
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class PushCustomServer extends JLFPluginServer<JLFPush> {

	@Override
	public JLFPush getServerApi() {
		return new PushCustomCore();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFCheckClient.class);
		return depends;
		
	}

	@Override
	public void initConfig() {
		ChannelManager.init(super.getConfig());
	}

}
