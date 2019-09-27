package org.jlf.product.ops.server.api;

import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageReq;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: JLFOpsQuery
 * @Description:JLFOpsQueryApi
 * @author Lone Wolf
 * @date 2019��7��6��
 */
public interface JLFOpsQuery {

	/**
	 * 
	 * @Title: getlogPage
	 * @Description:��ҳ��ѯ��ά��־
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFOpsLog> getlogPage(JLFOpsLogPageReq req);

}
