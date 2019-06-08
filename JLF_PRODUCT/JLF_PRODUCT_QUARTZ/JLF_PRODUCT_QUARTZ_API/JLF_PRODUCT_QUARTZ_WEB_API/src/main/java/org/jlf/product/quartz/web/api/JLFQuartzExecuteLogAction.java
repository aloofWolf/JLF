package org.jlf.product.quartz.web.api;

import org.jlf.product.quartz.web.api.metadata.request.executeLog.QuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.response.QuartzExecuteLogResp;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.route.JLFMVCRouteCls;

/**
 * 
 * @ClassName: QuartzExecuteLogWeb
 * @Description:QuartzExecuteLogWeb
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCRouteCls(name = "quartzExecuteLog", type = 1)
public interface JLFQuartzExecuteLogAction {

	/**
	 * 
	 * @Title: getDetail
	 * @Description:获取定时任务执行日志明细信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public QuartzExecuteLogResp getDetail(JLFMVCIdRequest req) throws Exception;

	/**
	 * 
	 * @Title: getPage
	 * @Description:分页查询定时任务执行日志
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse getPage(QuartzExecuteLogPageReq req) throws Exception;

}
