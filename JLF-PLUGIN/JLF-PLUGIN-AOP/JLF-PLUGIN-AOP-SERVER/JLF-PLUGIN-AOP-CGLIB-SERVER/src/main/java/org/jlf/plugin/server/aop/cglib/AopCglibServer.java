package org.jlf.plugin.server.aop.cglib;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.server.api.JLFAop;
import org.jlf.plugin.server.core.aop.cglib.AopCglib;

/**
 * 
 * @ClassName: AopCglibServer
 * @Description:AopCglib服务端
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class AopCglibServer extends JLFPluginServer<JLFAop> {

	@Override
	public JLFAop getServerApi() {
		return new AopCglib();
	}

}
