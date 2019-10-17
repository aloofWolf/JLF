package org.jlf.product.server.quartz.custom;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jlf.core.server.JLFProductServer;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.product.quartz.server.api.JLFQuartz;
import org.jlf.product.server.core.quartz.custom.config.QuartzConfig;

/**
 * 
 * @ClassName: QuartzWolfServer
 * @Description:QuartzWolfServer
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ5ÈÕ
 */
public class QuartzCustomServer extends JLFProductServer<JLFQuartz> {

	@Override
	public JLFQuartz getServerApi() {
		return new QuartzCustomCore();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void start(Properties prop) {
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		QuartzConfig config = JLFCheckClient.get().check(map, QuartzConfig.class);
		QuartzJobManager.init(config);
		QuartzJobManager.addMainjob();
	}

}
