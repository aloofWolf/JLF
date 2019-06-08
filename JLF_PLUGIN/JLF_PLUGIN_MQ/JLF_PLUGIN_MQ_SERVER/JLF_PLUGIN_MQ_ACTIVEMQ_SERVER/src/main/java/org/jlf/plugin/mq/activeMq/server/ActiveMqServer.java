package org.jlf.plugin.mq.activeMq.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.mq.activeMq.server.config.ActiveMqConfig;
import org.jlf.plugin.mq.activeMq.server.core.ActiveMqCore;
import org.jlf.plugin.mq.activeMq.server.core.ActiveMqPool;
import org.jlf.plugin.mq.server.api.JLFMq;

/**
 * 
 * @ClassName: ActiveMqServer
 * @Description:ActiveMqServer
 * @author Lone Wolf
 * @date 2019Äê6ÔÂ6ÈÕ
 */
public class ActiveMqServer extends JLFPluginServer<JLFMq> {

	@Override
	public JLFMq get() {
		return new ActiveMqCore();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFCheckClient.class);
		return set;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void jStart() throws Exception {
		String configFileName = JLFConfig.getPluginConfigName("activeMq");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		ActiveMqConfig config = JLFCheckClient.get().check(map, ActiveMqConfig.class);
		ActiveMqPool.init(config);

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
