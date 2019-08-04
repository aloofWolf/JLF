package org.jlf.plugin.server.session.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFClientNoInitExecption;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
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

	private static final String configFileName = "sessionCache.ini";

	@Override
	public JLFSession getServerApi() {
		return new SessionCacheCore();
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
		SessionCacheConfig config = ckeck.check(map, SessionCacheConfig.class);
		SessionCacheBean.setConfig(config);

	}

}
