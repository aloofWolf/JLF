package org.jlf.product.ops.wolf.server.action;

import org.jlf.product.ops.web.api.JLFOpsDriverAction;
import org.jlf.product.ops.web.api.metadata.request.JLFOpsDriverRequest;
import org.jlf.product.ops.wolf.server.service.OpsDriverService;

/**
 * 
 * @ClassName: OpsDriverAction
 * @Description:OpsDriverAction
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */
public class OpsDriverAction implements JLFOpsDriverAction {

	private OpsDriverService service;

	@Override
	public void reLoadPluginConfigFile(JLFOpsDriverRequest req) {
		service.reLoadPluginConfigFile(req.getClientCode(), req.getServerCode());

	}

	@Override
	public void reLoadProductConfigFile(JLFOpsDriverRequest req) {
		service.reLoadProductConfigFile(req.getClientCode(), req.getServerCode());

	}

	@Override
	public void reLoadSoaConfigFile(JLFOpsDriverRequest req) {
		service.reLoadSoaConfigFile(req.getServerCode());

	}

}
