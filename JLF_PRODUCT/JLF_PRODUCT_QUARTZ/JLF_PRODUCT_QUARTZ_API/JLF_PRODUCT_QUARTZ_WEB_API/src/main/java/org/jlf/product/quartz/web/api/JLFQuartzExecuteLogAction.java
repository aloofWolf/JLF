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
 * @date 2019��5��31��
 */
@JLFMVCRouteCls(name = "quartzExecuteLog", type = 1)
public interface JLFQuartzExecuteLogAction {

	/**
	 * 
	 * @Title: getDetail
	 * @Description:��ȡ��ʱ����ִ����־��ϸ��Ϣ
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public QuartzExecuteLogResp getDetail(JLFMVCIdRequest req) throws Exception;

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ҳ��ѯ��ʱ����ִ����־
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse getPage(QuartzExecuteLogPageReq req) throws Exception;

}
