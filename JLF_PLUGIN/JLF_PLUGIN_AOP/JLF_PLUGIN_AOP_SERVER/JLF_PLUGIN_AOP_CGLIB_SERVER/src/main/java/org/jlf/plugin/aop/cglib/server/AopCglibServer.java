package org.jlf.plugin.aop.cglib.server;

import java.util.Set;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.cglib.server.core.AopCglib;
import org.jlf.plugin.aop.server.api.JLFAop;

/**
 * 
 * @ClassName: AopCglibServer
 * @Description:AopCglib�����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class AopCglibServer extends JLFPluginServer<JLFAop> {

	@Override
	public JLFAop get() {
		return new AopCglib();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		return null;
	}

	@Override
	public void jStart() throws Exception {
		// TODO Auto-generated method stub

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
