package org.jlf.product.server.core.ops.custom.action;

import org.jlf.product.ops.web.api.JLFOpsQueryAction;
import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageReq;
import org.jlf.product.server.core.ops.custom.service.OpsQueryService;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: OpsQueryAction
 * @Description:OpsQueryAction
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */

@JLFMVCRoute(routeClsType=2)
public class OpsQueryAction implements JLFOpsQueryAction {

	private OpsQueryService service;

	@Override
	public JLFMVCPagingResponse<JLFOpsLog> getlogPage(JLFOpsLogPageReq req) {
		return service.getlogPage(req);
	}

	

}
