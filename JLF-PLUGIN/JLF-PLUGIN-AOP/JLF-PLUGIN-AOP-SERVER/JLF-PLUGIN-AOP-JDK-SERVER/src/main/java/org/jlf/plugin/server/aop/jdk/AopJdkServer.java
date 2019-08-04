package org.jlf.plugin.server.aop.jdk;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.aop.server.api.JLFAop;
import org.jlf.plugin.server.core.aop.jdk.AopJdk;

public class AopJdkServer extends JLFPluginServer<JLFAop> {

	@Override
	public JLFAop getServerApi() {
		return new AopJdk();
	}

}
