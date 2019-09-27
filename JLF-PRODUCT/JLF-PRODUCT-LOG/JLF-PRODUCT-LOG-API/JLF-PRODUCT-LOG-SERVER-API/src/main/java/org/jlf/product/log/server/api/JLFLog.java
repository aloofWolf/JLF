package org.jlf.product.log.server.api;

import org.jlf.core.api.JLFProductServerApi;
import org.jlf.product.log.web.metadata.entity.JLFLogEntity;
import org.jlf.product.log.web.metadata.request.JLFLogPageReq;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: JLFLog
 * @Description:JLFLogApi
 * @author Lone Wolf
 * @date 2019年9月23日
 */
public interface JLFLog extends JLFProductServerApi {

	public static final String PRODUCT_NAME = "log";

	/**
	 * 
	 * @Title: saveLog
	 * @Description:保存日志
	 * @param log
	 */
	public void saveLog(JLFLogEntity log);

	/**
	 * 
	 * @Title: getPage
	 * @Description:查询日志分页列表
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFLogEntity> getPage(JLFLogPageReq req);

	/**
	 * 
	 * @Title: getDetail
	 * @Description:查询日志详情
	 * @param id
	 * @param queryMonth
	 * @return
	 */
	public JLFLogEntity getDetail(Long id, Integer queryMonth);

}
