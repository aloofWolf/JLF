package org.jlf.plugin.aop.cglib.server;

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
	public JLFAop getServerApi() {
		return new AopCglib();
	}

}
