package org.jlf.plugin.session.cache.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.cache.client.JLFCacheClient;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.session.cache.config.SessionCacheConfig;
import org.jlf.plugin.session.cache.core.SessionCacheBean;
import org.jlf.plugin.session.cache.core.SessionCacheCore;
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
	public JLFSession get() {
		return new SessionCacheCore();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFCheckClient.class);
		set.add(JLFCacheClient.class);
		return set;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void jStart() throws Exception {
		String configFileName = JLFConfig.getPluginConfigName("sessionCache");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		SessionCacheConfig config = JLFCheckClient.get().check(map, SessionCacheConfig.class);
		SessionCacheBean.setConfig(config);

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
