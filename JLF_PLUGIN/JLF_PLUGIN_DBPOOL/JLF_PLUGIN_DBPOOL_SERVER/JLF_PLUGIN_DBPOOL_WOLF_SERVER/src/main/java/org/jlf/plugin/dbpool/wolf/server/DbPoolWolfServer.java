package org.jlf.plugin.dbPool.wolf.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFClientNoInitExecption;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.dbPool.wolf.server.config.DbPoolWolfMainConfig;
import org.jlf.plugin.dbPool.wolf.server.core.DbPoolWolfCore;
import org.jlf.plugin.dbPool.wolf.server.core.DbPoolWolfPool;

/**
 * 
 * @ClassName: DbWolfServer
 * @Description:DbWolf服务端
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class DbPoolWolfServer extends JLFPluginServer<JLFDbPool> {

	@Override
	public JLFDbPool getServerApi() {
		return new DbPoolWolfCore();
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
	public void initConfig() {
		JLFCheck ckeck = JLFCheckClient.get();
		if (ckeck == null) {
			throw new JLFClientNoInitExecption(JLFCheckClient.class);
		}
		String configFileName = JLFConfig.getPluginConfigName("dbPoolWolf");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		DbPoolWolfMainConfig config = ckeck.check(map, DbPoolWolfMainConfig.class);
		DbPoolWolfPool.initMainDataSource(config);
	}

}
