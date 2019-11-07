package org.jlf.plugin.server.threadPool.custom;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.server.core.threadPool.custom.ThreadPoolCustomConfig;
import org.jlf.plugin.server.core.threadPool.custom.ThreadPoolCustomCore;
import org.jlf.plugin.server.core.threadPool.custom.ThreadPoolCustomManager;
import org.jlf.plugin.threadPool.api.JLFThreadPool;

/**
 * 
 * @ClassName: ThreadPoolCustomServer
 * @Description:ThreadPoolCustomServer
 * @author Lone Wolf
 * @date 2019年5月28日
 */
public class ThreadPoolCustomServer extends JLFPluginServer<JLFThreadPool> {

	@Override
	public JLFThreadPool getServerApi() {
		return new ThreadPoolCustomCore();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		Set<Class<CLIENT>> depends = new HashSet<Class<CLIENT>>();
		depends.add((Class<CLIENT>) JLFCheckClient.class);
		return depends;
		
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

	/**
	 * 
	 * @Title: start
	 * @Description:启动服务
	 * @param prop
	 */
	public void start(Properties prop) {
		ThreadPoolCustomConfig config;
		if(prop != null){
			config = JLFCheckClient.get().check(prop, ThreadPoolCustomConfig.class);
		}else{
			config = new ThreadPoolCustomConfig();
		}
		
		ThreadPoolCustomManager.init(config);
	}
}
