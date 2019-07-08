package org.jlf.product.ops.wolf.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFProductServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.mq.client.JLFMqClient;
import org.jlf.plugin.mq.server.api.JLFCousumerTopic;
import org.jlf.product.ops.server.api.JLFOps;
import org.jlf.product.ops.web.api.JLFOpsAction;
import org.jlf.product.ops.wolf.server.action.OpsAction;
import org.jlf.product.ops.wolf.server.core.mq.OpsMqTopicConsumer;
import org.jlf.product.ops.wolf.server.core.mq.OpsMqTopicManager;
import org.jlf.product.ops.wolf.server.service.OpsDriverService;
import org.jlf.soa.mvc.service.JLFMVCServiceStruc;

/**
 * 
 * @ClassName: OpsWolfServer
 * @Description:OpsWolfServer
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */
public class OpsWolfServer extends JLFProductServer<JLFOps, JLFOpsAction> {

	@Override
	public JLFOps getServerApi() {
		return JLFMVCServiceStruc.getService(OpsDriverService.class);
	}

	@Override
	public JLFOpsAction getWebApi() {
		return new OpsAction();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> set = new HashSet<Class<CLIENT>>();
		set.add((Class<CLIENT>) JLFCheckClient.class);
		set.add((Class<CLIENT>) JLFMqClient.class);
		return set;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initConfig() {

		String configFileName = JLFConfig.getProductConfigName("quartzWolf");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		OpsConfig config = JLFCheckClient.get().check(map, OpsConfig.class);
		OpsMqTopicManager.init(config.getHostCode());

	}

	@Override
	public void doOther() {
		OpsMqTopicConsumer consumer = JLFMVCServiceStruc.getService(OpsMqTopicConsumer.class);
		JLFCousumerTopic opsTopic = JLFMqClient.get().getCousumerTopic(consumer);
		opsTopic.start();
	}
}
