package org.jlf.plugin.server.session.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.client.cache.JLFCacheClient;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.server.core.session.cache.SessionCacheBean;
import org.jlf.plugin.server.core.session.cache.SessionCacheCore;
import org.jlf.plugin.server.core.session.cache.config.SessionCacheConfig;
import org.jlf.plugin.session.server.api.JLFSession;

/**
 * 
 * @ClassName: SessionCacheServer
 * @Description:SessionCacheServer
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ31ÈÕ
 */
public class SessionCacheServer extends JLFPluginServer<JLFSession> {

	@Override
	public JLFSession getServerApi() {
		return new SessionCacheCore();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFCheckClient.class);
		depends.add((Class<CLIENT>) JLFCacheClient.class);
		return depends;
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initConfig() {
		JLFCheck ckeck = JLFCheckClient.get();
		Properties prop = super.getConfig();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		SessionCacheConfig config = ckeck.check(map, SessionCacheConfig.class);
		SessionCacheBean.setConfig(config);

	}

}
