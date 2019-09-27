package org.jlf.product.server.core.ops.custom.service;

import org.jlf.product.ops.server.api.JLFOpsQuery;
import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageReq;
import org.jlf.product.server.core.ops.custom.dao.OpsLogDao;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.service.ann.JLFMVCService;

/**
 * 
 * @ClassName: OpsQueryService
 * @Description:OpsQueryService
 * @author Lone Wolf
 * @date 2019Äê7ÔÂ6ÈÕ
 */
@JLFMVCService
public class OpsQueryService implements JLFOpsQuery{

	private OpsLogDao logDao;

	@Override
	public JLFMVCPagingResponse<JLFOpsLog> getlogPage(JLFOpsLogPageReq req) {
		return logDao.getPage(req);
	}

}
