package org.jlf.plugin.server.mq.activeMq;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.client.threadPool.JLFThreadPoolClient;
import org.jlf.plugin.mq.server.api.JLFMq;
import org.jlf.plugin.server.core.mq.activeMq.ActiveMqCore;
import org.jlf.plugin.server.core.mq.activeMq.ActiveMqPool;
import org.jlf.plugin.server.core.mq.activeMq.config.ActiveMqConfig;

/**
 * 
 * @ClassName: MqActiveServer
 * @Description:MqActiveServer
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class ActiveMqServer extends JLFPluginServer<JLFMq> {

	@Override
	public JLFMq getServerApi() {
		return new ActiveMqCore();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFCheckClient.class);
		depends.add((Class<CLIENT>) JLFThreadPoolClient.class);
		return depends;

	}

	@Override
	public void start() {
		Properties prop = super.getConfig().getPros();
		start(prop);
	}

	@Override
	public void reStart() {
		Properties prop = super.getConfig(true).getPros();
		start(prop);
	}

	/**
	 * 
	 * @Title: start
	 * @Description:启动服务
	 * @param prop
	 */
	public void start(Properties prop) {
		JLFCheck ckeck = JLFCheckClient.get();
		ActiveMqConfig config = ckeck.check(prop, ActiveMqConfig.class);
		ActiveMqPool.init(config);
	}
}
