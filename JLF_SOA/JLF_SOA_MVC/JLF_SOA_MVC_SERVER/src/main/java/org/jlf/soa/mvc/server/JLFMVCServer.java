package org.jlf.soa.mvc.server;

import java.util.HashSet;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.aop.client.JLFAopClient;
import org.jlf.plugin.aop.client.JLFSessionClient;
import org.jlf.plugin.cache.client.JLFCacheClient;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.dbpool.client.JLFDbPoolClient;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.soa.mvc.web.route.JLFMVCRouteManager;

/**
 * 
 * @ClassName: JLFMVCServer
 * @Description:JLFMVCServer
 * @author Lone Wolf
 * @date 2019Äê5ÔÂ27ÈÕ
 */
public class JLFMVCServer extends JLFSoaServer {

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFAopClient.class);
		set.add(JLFCacheClient.class);
		set.add(JLFCheckClient.class);
		set.add(JLFDbPoolClient.class);
		set.add(JLFSessionClient.class);
		set.add(JLFJsonClient.class);
		return set;
	}

	@Override
	public void jStart() throws Exception {
		String configFileName = JLFConfig.getSoaConfigName("mvc");
		IniUtil ini = new IniUtil(configFileName);
		JLFMVCRouteManager.initRoutes(ini);

	}

	@Override
	public void jreStart() throws Exception {
		// TODO Auto-generated method stub

	}

}
