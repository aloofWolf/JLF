package org.jlf.plugin.server.mq.activeMq;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFClientNoInitExecption;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.mq.server.api.JLFMq;
import org.jlf.plugin.server.core.mq.activeMq.ActiveMqCore;
import org.jlf.plugin.server.core.mq.activeMq.ActiveMqPool;
import org.jlf.plugin.server.core.mq.activeMq.config.ActiveMqConfig;

/**
 * 
 * @ClassName: MqActiveServer
 * @Description:MqActiveServer
 * @author Lone Wolf
 * @date 2019Äê6ÔÂ6ÈÕ
 */
public class ActiveMqServer extends JLFPluginServer<JLFMq> {

	private static final String configFileName = "activeMq.ini";

	@Override
	public JLFMq getServerApi() {
		return new ActiveMqCore();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initConfig() {
		JLFCheck ckeck = JLFCheckClient.get();
		if (ckeck == null) {
			throw new JLFClientNoInitExecption(JLFCheckClient.class);
		}
		IniUtil ini = new IniUtil(JLFConfig.getPluginConfigFilePath(configFileName));
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		ActiveMqConfig config = ckeck.check(map, ActiveMqConfig.class);
		ActiveMqPool.init(config);

	}
}
