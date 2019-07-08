package org.jlf.product.ops.wolf.server.action;

import java.util.ArrayList;
import java.util.List;

import org.jlf.product.ops.web.api.JLFOpsQueryAction;
import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageRequest;
import org.jlf.product.ops.web.api.metadata.response.JLFOpsLogPageDetailResponse;
import org.jlf.product.ops.web.api.metadata.response.JLFOpsLogPageResponse;
import org.jlf.product.ops.wolf.server.metadata.bean.OpsLog;
import org.jlf.product.ops.wolf.server.service.OpsQueryService;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;

/**
 * 
 * @ClassName: OpsQueryAction
 * @Description:OpsQueryAction
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */
public class OpsQueryAction implements JLFOpsQueryAction {

	private OpsQueryService service;

	@Override
	public JLFOpsLogPageResponse getlogPage(JLFOpsLogPageRequest req) {
		JLFMVCPage<OpsLog> page = service.getLogPage(req);
		List<OpsLog> list = page.getDetails();
		List<JLFOpsLogPageDetailResponse> respList = new ArrayList<JLFOpsLogPageDetailResponse>();
		if (list != null) {
			for (OpsLog opsLog : list) {
				JLFOpsLogPageDetailResponse resp = new JLFOpsLogPageDetailResponse();
				resp.setModule(opsLog.getModule().getId());
				resp.setType(opsLog.getType().getId());
				resp.setClientCode(opsLog.getClientCode());
				resp.setServerCode(opsLog.getServerCode());
				resp.setHostCode(opsLog.getHostCode());
				resp.setOpsTime(opsLog.getCreateTime());
				resp.setUserId(opsLog.getCreateUserId());
				resp.setUserName(opsLog.getCreateUserName());
				resp.setFailReason(opsLog.getFailReason());
				resp.setOpsResult(opsLog.getOpsResult().getId());
				respList.add(resp);
			}
		}
		return new JLFOpsLogPageResponse(page.getTotalNum(), page.getTotalPage(), respList);
	}

}
