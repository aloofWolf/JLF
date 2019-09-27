package org.jlf.product.ops.web.api;

import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageReq;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: JLFOpsQueryAction
 * @Description:JLFOpsQueryActionApi
 * @author Lone Wolf
 * @date 2019��7��6��
 */
@JLFMVCRoute(name = "opsQuery")
public interface JLFOpsQueryAction {

	/**
	 * 
	 * @Title: getlogPage
	 * @Description:��ҳ��ѯ��ά��־
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFOpsLog> getlogPage(JLFOpsLogPageReq req);

}
