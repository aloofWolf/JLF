package org.jlf.plugin.server.push.custom;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFPluginServer;
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

	private static final String configFileName = "pushCustom.ini";

	@Override
	public JLFPush getServerApi() {
		return new PushCustomCore();
	}

	@Override
	public void initConfig() {
		IniUtil ini = new IniUtil(JLFConfig.getPluginConfigFilePath(configFileName));
		ChannelManager.init(ini);
	}

}
