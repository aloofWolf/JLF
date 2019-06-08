package org.jlf.plugin.aop.cglib.test;

import java.util.ArrayList;
import java.util.List;

import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.aop.cglib.server.AopCglibServer;
import org.jlf.plugin.aop.client.JLFAopClient;

/**
 * 
 * @ClassName: AopCglibTest
 * @Description:AopCglib测试类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class AopCglibTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		AopCglibTest server = new AopCglibTest();
		server.starts();
		TargetInstance target = JLFAopClient.get().getProxy(TargetInstance.class, new AopCglibDoTest());
		target.Test1("aa", "bb", "cc");
		target.Test2();
		target.Test3();
	}

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFAopClient(new AopCglibServer()));
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
