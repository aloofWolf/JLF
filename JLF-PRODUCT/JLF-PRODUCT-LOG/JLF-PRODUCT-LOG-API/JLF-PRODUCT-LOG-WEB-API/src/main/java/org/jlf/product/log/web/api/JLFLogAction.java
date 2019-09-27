package org.jlf.product.log.web.api;

import org.jlf.product.log.web.metadata.entity.JLFLogEntity;
import org.jlf.product.log.web.metadata.request.JLFLogPageReq;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: JLFLogAction
 * @Description: JLFLogActionApi
 * @author Lone Wolf
 * @date 2019年9月23日
 */
public interface JLFLogAction {

	/**
	 * 
	 * @Title: saveLog
	 * @Description:保存日志
	 * @param log
	 */
	@JLFMVCRoute(name="save")
	public void saveLog(JLFLogEntity log);

	/**
	 * 
	 * @Title: getPage
	 * @Description:查询日志分页列表
	 * @param req
	 * @return
	 */
	@JLFMVCRoute(name="page")
	public JLFMVCPagingResponse<JLFLogEntity> getPage(JLFLogPageReq req);

	/**
	 * 
	 * @Title: getDetail
	 * @Description:查询日志详情
	 * @param id
	 * @param queryMonth
	 * @return
	 */
	@JLFMVCRoute(name="detail")
	public JLFLogEntity getDetail(Long id, Integer queryMonth);

}
