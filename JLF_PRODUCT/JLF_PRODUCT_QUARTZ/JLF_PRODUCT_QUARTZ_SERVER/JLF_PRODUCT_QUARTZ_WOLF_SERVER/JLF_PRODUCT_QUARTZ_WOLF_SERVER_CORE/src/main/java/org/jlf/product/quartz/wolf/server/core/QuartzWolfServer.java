package org.jlf.product.quartz.wolf.server.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFProductServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.dbpool.client.JLFDbPoolClient;
import org.jlf.product.quartz.server.api.JLFQuartz;
import org.jlf.product.quartz.wolf.server.config.QuartzConfig;
import org.jlf.product.quartz.wolf.server.service.QuartzJobService;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.service.JLFMVCServiceStruc;

public class QuartzWolfServer extends JLFProductServer<JLFQuartz>{
	
	private QuartzJobService jobService = JLFMVCServiceStruc.getService(QuartzJobService.class);

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		Set<Class<?>> set = new HashSet<Class<?>>();
		set.add(JLFCheckClient.class);
		set.add(JLFDbPoolClient.class);
		return set;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void jStart() throws Exception {
		
		String configFileName = JLFConfig.getProductConfigName("quartzWolf");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		QuartzConfig config = JLFCheckClient.get().check(map, QuartzConfig.class);
		QuartzJobManager.init(config);

		String dbNames = config.getDbNames();
		String[] arr = dbNames.split(",");
		for (String dbName : arr) {
			JLFMVCThreadLocal.setDbName(dbName);
			jobService.updateAllReady();
			JLFMVCThreadLocal.setDbName(null);
		}
		QuartzJobManager.addMainjob();
		
	}

	@Override
	public void jreStart() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JLFQuartz get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void jStop() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
