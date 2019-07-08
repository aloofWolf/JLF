package org.jlf.product.quartz.wolf.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.server.JLFProductServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.dbPool.client.JLFDbPoolClient;
import org.jlf.product.quartz.server.api.JLFQuartz;
import org.jlf.product.quartz.web.api.JLFQuartzAcion;
import org.jlf.product.quartz.wolf.server.action.QuartzAction;
import org.jlf.product.quartz.wolf.server.config.QuartzConfig;
import org.jlf.product.quartz.wolf.server.service.QuartzDefineService;
import org.jlf.product.quartz.wolf.server.service.QuartzExecuteService;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.service.JLFMVCServiceStruc;

/**
 * 
 * @ClassName: QuartzWolfServer
 * @Description:QuartzWolfServer
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class QuartzWolfServer extends JLFProductServer<JLFQuartz, JLFQuartzAcion> {

	private QuartzDefineService defineService = JLFMVCServiceStruc.getService(QuartzDefineService.class);
	private QuartzExecuteService executeService = JLFMVCServiceStruc.getService(QuartzExecuteService.class);

	@Override
	public JLFQuartz getServerApi() {
		return defineService;
	}

	@Override
	public JLFQuartzAcion getWebApi() {
		return new QuartzAction();
	}

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
	public void initConfig() {

		String configFileName = JLFConfig.getProductConfigName("quartzWolf");
		IniUtil ini = new IniUtil(configFileName);
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		QuartzConfig config = JLFCheckClient.get().check(map, QuartzConfig.class);
		QuartzJobManager.init(config);
	}

	/**
	 * 
	 * @Title: doOther
	 * @Description:遍历已配置的所有库的任务表,将表中所有任务改为就绪状态
	 */
	public void doOther() {
		String dbNames = QuartzJobManager.config.getDbNames();
		String[] arr = dbNames.split(",");
		for (String dbName : arr) {
			JLFMVCThreadLocal.setDbName(dbName);
			executeService.updateAllReady();
			JLFMVCThreadLocal.setDbName(null);
		}
		QuartzJobManager.addMainjob();
	}

}
