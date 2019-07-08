package org.jlf.product.ops.wolf.server.service;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.core.server.JLFProductServer;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.core.util.JLFPluginUtil;
import org.jlf.core.util.JLFProductUtil;
import org.jlf.core.util.JLFSoaUtil;
import org.jlf.product.ops.server.api.JLFOps;
import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.product.ops.wolf.server.core.mq.OpsMqTopicProduct;
import org.jlf.soa.mvc.metadata.ann.JLFMVCService;

/**
 * 
 * @ClassName: OpsDriverService
 * @Description:OpsDriverService
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */
@JLFMVCService
public class OpsDriverService implements JLFOps {

	@Override
	public <SERVER_API extends JLFPluginServerApi> void reLoadPluginConfigFile(String clientCode, String serverCode) {
		JLFPluginServer<SERVER_API> server = JLFPluginUtil.getServerObjByServerCodeAndClientCode(clientCode,
				serverCode);
		server.initConfig();
		OpsMqTopicProduct.send(JLFOpsModule.PLUGIN, JLFOpsType.START, null, serverCode);

	}

	@Override
	public <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi> void reLoadProductConfigFile(
			String clientCode, String serverCode) {
		JLFProductServer<SERVER_API, WEB_API> server = JLFProductUtil.getServerObjByServerCodeAndClientCode(clientCode,
				serverCode);
		server.initConfig();
		OpsMqTopicProduct.send(JLFOpsModule.PRODUCT, JLFOpsType.START, null, serverCode);

	}

	@Override
	public void reLoadSoaConfigFile(String serverCode) {
		JLFSoaServer server = JLFSoaUtil.getServerObjByServerCode(serverCode);
		server.initConfig();
		OpsMqTopicProduct.send(JLFOpsModule.SOA, JLFOpsType.RESTART, null, serverCode);

	}

}
