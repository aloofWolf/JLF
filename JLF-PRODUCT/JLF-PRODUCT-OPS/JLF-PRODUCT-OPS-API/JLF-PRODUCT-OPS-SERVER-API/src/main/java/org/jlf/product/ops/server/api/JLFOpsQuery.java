package org.jlf.product.ops.server.api;

import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageReq;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: JLFOpsQuery
 * @Description:JLFOpsQueryApi
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public interface JLFOpsQuery {

	/**
	 * 
	 * @Title: getlogPage
	 * @Description:分页查询运维日志
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFOpsLog> getlogPage(JLFOpsLogPageReq req);

}
