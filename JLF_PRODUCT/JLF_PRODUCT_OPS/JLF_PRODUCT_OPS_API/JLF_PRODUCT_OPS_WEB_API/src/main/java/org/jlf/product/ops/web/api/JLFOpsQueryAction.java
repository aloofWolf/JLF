package org.jlf.product.ops.web.api;

import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageRequest;
import org.jlf.product.ops.web.api.metadata.response.JLFOpsLogPageResponse;
import org.jlf.soa.mvc.metadata.ann.JLFMVCRouteCls;

/**
 * 
 * @ClassName: JLFOpsQueryAction
 * @Description:JLFOpsQueryActionApi
 * @author Lone Wolf
 * @date 2019年7月6日
 */
@JLFMVCRouteCls(name="opsQuery")
public interface JLFOpsQueryAction {

	/**
	 * 
	 * @Title: getlogPage
	 * @Description:分页查询运维日志
	 * @param req
	 * @return
	 */
	public JLFOpsLogPageResponse getlogPage(JLFOpsLogPageRequest req);

}
