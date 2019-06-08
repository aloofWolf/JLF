package org.jlf.plugin.threadpool.wolf.test;

import java.util.ArrayList;
import java.util.List;

import org.jlf.common.util.LogUtil;
import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.threadPool.api.JLFThreadPoolResult;
import org.jlf.plugin.threadPool.client.JLFThreadPoolClient;
import org.jlf.plugin.threadPool.wolf.server.ThreadPoolWolfServer;

/**
 * 
 * @ClassName: JLFThreadPoolTest
 * @Description:JLFThreadPool≤‚ ‘
 * @author Lone Wolf
 * @date 2019ƒÍ6‘¬4»’
 */
public class JLFThreadPoolTest extends JLFCore {

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFThreadPoolClient(new ThreadPoolWolfServer()));
		return plugins;
	}

	@Override
	protected List<JLFProductClient<?>> getProductClients() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <SERVER extends JLFSoaServer> List<SERVER> getSoaServers() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws Exception {
		JLFThreadPoolTest test = new JLFThreadPoolTest();
		test.starts();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}

		JLFThreadPoolResult<Integer> result = JLFThreadPoolClient.get().execute(list, new ThreadPoolExecute());
		LogUtil.get().debug("successCount={}", result.getSuccessCount());
		LogUtil.get().debug("failCount={}", result.getFailCount());
	}

}
