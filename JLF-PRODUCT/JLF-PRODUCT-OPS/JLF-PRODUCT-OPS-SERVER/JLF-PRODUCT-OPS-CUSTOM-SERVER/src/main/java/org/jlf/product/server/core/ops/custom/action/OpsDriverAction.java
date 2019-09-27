package org.jlf.product.server.core.ops.custom.action;

import org.jlf.product.ops.web.api.JLFOpsExecuteAction;
import org.jlf.product.server.core.ops.custom.service.OpsExecuteService;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: OpsDriverAction
 * @Description:OpsDriverAction
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */

@JLFMVCRoute(routeClsType=2)
public class OpsDriverAction implements JLFOpsExecuteAction {

	private OpsExecuteService service;

	@Override
	public void reStartPluginServer(String pluginServerClsName) {
		service.reStartPluginServer(pluginServerClsName);

	}

	@Override
	public void reStartProductServer(String productServerClsName) {
		service.reStartProductServer(productServerClsName);

	}

	@Override
	public void reStartSoaServer(String soaServerClsName) {
		service.reStartSoaServer(soaServerClsName);

	}

}
