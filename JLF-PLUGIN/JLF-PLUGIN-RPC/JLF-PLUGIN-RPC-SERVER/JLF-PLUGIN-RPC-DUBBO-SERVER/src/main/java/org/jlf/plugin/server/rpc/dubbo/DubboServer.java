package org.jlf.plugin.server.rpc.dubbo;

import java.util.HashSet;
import java.util.Set;

import org.jlf.common.util.IniContent;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.rpc.server.api.JLFRpc;
import org.jlf.plugin.server.core.rpc.dubbo.manager.DubboCore;
import org.jlf.plugin.server.core.rpc.dubbo.manager.DubboManager;

/**
 * 
 * @ClassName: RedisClusterServer
 * @Description:RedisClusterServer
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class DubboServer  extends JLFPluginServer<JLFRpc> {

	@Override
	public JLFRpc getServerApi() {
		return new DubboCore();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFCheckClient.class);
		return depends;

	}

	@Override
	public void start() {
		IniContent content = super.getConfig();
		start(content);
	}

	@Override
	public void reStart() {
		IniContent content = super.getConfig(true);
		start(content);
	}

	/**
	 * 
	 * @Title: start
	 * @Description:启动服务
	 * @param prop
	 */
	public void start(IniContent content) {
		DubboManager.getInstance().init(content);
	}

	
}
