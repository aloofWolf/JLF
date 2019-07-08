package org.jlf.plugin.push.wolf.server;

import java.util.HashSet;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.push.server.api.JLFPush;
import org.jlf.plugin.push.wolf.server.core.PushWolfCore;
import org.jlf.plugin.push.wolf.server.manager.ChannelManager;

/**
 * 
 * @ClassName: PushWolfServer
 * @Description:PushWolf �����
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class PushWolfServer extends JLFPluginServer<JLFPush> {

	@Override
	public JLFPush getServerApi() {
		return new PushWolfCore();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFCheckClient.class);
		return set;
	}

	@Override
	public void initConfig() {
		String configFileName = JLFConfig.getPluginConfigName("pushWolf");
		IniUtil ini = new IniUtil(configFileName);
		ChannelManager.init(ini);
	}

}
