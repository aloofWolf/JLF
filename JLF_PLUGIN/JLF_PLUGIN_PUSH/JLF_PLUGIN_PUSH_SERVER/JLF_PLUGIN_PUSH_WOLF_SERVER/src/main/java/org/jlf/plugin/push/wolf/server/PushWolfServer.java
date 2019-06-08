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
 * @Description:PushWolf 服务端
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class PushWolfServer extends JLFPluginServer<JLFPush> {

	@Override
	public JLFPush get() {
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
	public void jStart() throws Exception {
		String configFileName = JLFConfig.getPluginConfigName("pushWolf");
		IniUtil ini = new IniUtil(configFileName);
		ChannelManager.init(ini);
	}

	@Override
	public void jStop() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void jreStart() throws Exception {
		// TODO Auto-generated method stub

	}

}
