package org.jlf.plugin.cache.redis.test;

import java.util.ArrayList;
import java.util.List;

import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.aop.cglib.server.AopCglibServer;
import org.jlf.plugin.aop.client.JLFAopClient;
import org.jlf.plugin.cache.client.JLFCacheClient;
import org.jlf.plugin.cache.redis.server.CacheRedisServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.check.wolf.server.CheckWolfServer;

/**
 * 
    * @ClassName: CacheRedisTest
    * @Description:CacheRedis测试
    * @author Lone Wolf
    * @date 2019年6月4日
 */
public class CacheRedisTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		CacheRedisTest server = new CacheRedisTest();
		server.starts();
		//JLFCacheClient.get().save("aa", "bb");
		//JLFCacheClient.get().save("obj", new CacheBean());
		//CacheBean bean = JLFCacheClient.get().getObj("obj", CacheBean.class);
		//System.out.println(bean.toString());
		//JLFCacheClient.get().update("aa", "CC");
		//CacheBean bean = new CacheBean();
		//bean.setName("我是谁");
		//JLFCacheClient.get().update("obj", bean);
		//bean = JLFCacheClient.get().getObj("obj", CacheBean.class);
		//System.out.println(bean.toString());
		JLFCacheClient.get().add("arr", "bb","cc","dd","ee");
		
	}

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFAopClient(new AopCglibServer()));
		plugins.add(new JLFCacheClient(new CacheRedisServer()));
		plugins.add(new JLFCheckClient(new CheckWolfServer()));
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
}