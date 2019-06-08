package org.jlf.plugin.dbpool.wolf.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.dbpool.server.api.JLFDbPool;
import org.jlf.plugin.dbpool.wolf.server.config.DbPoolWolfConfig;
import org.jlf.plugin.dbpool.wolf.server.core.DbPoolWolfCore;
import org.jlf.plugin.dbpool.wolf.server.core.DbPoolWolfPool;

/**
 * 
 * @ClassName: DbWolfServer
 * @Description:DbWolf服务端
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class DbPoolWolfServer extends JLFPluginServer<JLFDbPool> {

	@Override
	public JLFDbPool get() {
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
	public void jStart() throws Exception {
		String configFileName = JLFConfig.getPluginConfigName("dbWolf");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		DbPoolWolfConfig config = JLFCheckClient.get().check(map, DbPoolWolfConfig.class);
		DbPoolWolfPool.init(config);

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
