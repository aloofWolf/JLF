package org.jlf.product.quartz.server.api;

import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzExecuteLogEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzTemplatePageReq;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: JLFQuartzQuery
 * @Description:JLFQuartzQuery
 * @author Lone Wolf
 * @date 2019��9��24��
 */
public interface JLFQuartzQuery {

	/**
	 * 
	 * @Title: getJobDetail
	 * @Description:��ȡ��ʱ������ϸ
	 * @param req
	 * @return
	 */
	public JLFQuartzJobEntity getJobDetail(Long id);

	/**
	 * 
	 * @Title: getJobPage
	 * @Description:��ҳ��ѯ��ʱ����
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzJobEntity> getJobPage(JLFQuartzJobPageReq req);

	/**
	 * 
	 * @Title: getTemplateDetail
	 * @Description:��ȡģ����ϸ��Ϣ
	 * @param req
	 * @return
	 */
	public JLFQuartzTemplateEntity getTemplateDetail(Long id);

	/**
	 * 
	 * @Title: getTemplatePage
	 * @Description:��ҳ��ѯģ����Ϣ
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzTemplateEntity> getTemplatePage(JLFQuartzTemplatePageReq req);

	/**
	 * 
	 * @Title: getLogDetail
	 * @Description:��ȡ��ʱ����ִ����־��ϸ��Ϣ
	 * @param req
	 * @return
	 */
	public JLFQuartzExecuteLogEntity getLogDetail(Long id);

	/**
	 * 
	 * @Title: getLogPage
	 * @Description:��ҳ��ѯ��ʱ����ִ����־
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzExecuteLogEntity> getLogPage(JLFQuartzExecuteLogPageReq req);

}
