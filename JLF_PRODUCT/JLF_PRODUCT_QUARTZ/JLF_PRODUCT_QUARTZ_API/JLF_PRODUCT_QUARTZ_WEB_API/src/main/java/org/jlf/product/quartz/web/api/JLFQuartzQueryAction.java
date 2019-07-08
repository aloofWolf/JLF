package org.jlf.product.quartz.web.api;

import java.util.List;

import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobListReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.executeLog.QuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateListReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplatePageReq;
import org.jlf.product.quartz.web.api.metadata.response.QuartzExecuteLogPageResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzExecuteLogResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzJobPageResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzJobResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzTemplatePageResp;
import org.jlf.product.quartz.web.api.metadata.response.QuartzTemplateResp;
import org.jlf.soa.mvc.metadata.ann.JLFMVCRouteCls;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;

/**
 * 
 * @ClassName: JLFQuartzQueryAction
 * @Description:JLFQuartzQueryActionApi
 * @author Lone Wolf
 * @date 2019��7��5��
 */
@JLFMVCRouteCls(name="quartzQuery")
public interface JLFQuartzQueryAction {

	/**
	 * 
	 * @Title: getJobDeatil
	 * @Description:��ȡ��ʱ������ϸ
	 * @param req
	 * @return
	 */
	public QuartzJobResp getJobDeatil(JLFMVCIdRequest req);

	/**
	 * 
	 * @Title: getJobPage
	 * @Description:��ҳ��ѯ��ʱ����
	 * @param req
	 * @return
	 */
	public QuartzJobPageResp getJobPage(QuartzJobPageReq req);

	/**
	 * 
	 * @Title: getJobList
	 * @Description:��ѯ��ʱ�����б�
	 * @param req
	 * @return
	 */
	public List<QuartzJobResp> getJobList(QuartzJobListReq req);

	/**
	 * 
	 * @Title: getTemplateDetail
	 * @Description:��ȡģ����ϸ��Ϣ
	 * @param req
	 * @return
	 */
	public QuartzTemplateResp getTemplateDetail(JLFMVCIdRequest req);

	/**
	 * 
	 * @Title: getTemplatePage
	 * @Description:��ҳ��ѯģ����Ϣ
	 * @param req
	 * @return
	 */
	public QuartzTemplatePageResp getTemplatePage(QuartzTemplatePageReq req);

	/**
	 * 
	 * @Title: getTemplateList
	 * @Description:��ѯģ����Ϣ�б�
	 * @param req
	 * @return
	 */
	public List<QuartzTemplateResp> getTemplateList(QuartzTemplateListReq req);

	/**
	 * 
	 * @Title: getLogDetail
	 * @Description:��ȡ��ʱ����ִ����־��ϸ��Ϣ
	 * @param req
	 * @return
	 */
	public QuartzExecuteLogResp getLogDetail(JLFMVCIdRequest req);

	/**
	 * 
	 * @Title: getLogPage
	 * @Description:��ҳ��ѯ��ʱ����ִ����־
	 * @param req
	 * @return
	 */
	public QuartzExecuteLogPageResp getLogPage(QuartzExecuteLogPageReq req);

}
