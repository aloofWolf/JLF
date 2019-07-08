package org.jlf.product.quartz.web.api;

import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobSaveReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobUpdateReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateSaveReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateUpdateReq;
import org.jlf.soa.mvc.metadata.ann.JLFMVCRouteCls;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
 * @ClassName: JLFQuartzDefineAction
 * @Description:JLFQuartzDefineActionApi
 * @author Lone Wolf
 * @date 2019��7��5��
 */
@JLFMVCRouteCls(name = "defineQuery")
public interface JLFQuartzDefineAction {

	/**
	 * 
	 * @Title: saveJob
	 * @Description:����һ�鶨ʱ����
	 * @param req
	 */
	public void saveJob(QuartzJobSaveReq req);

	/**
	 * 
	 * @Title: updateJob
	 * @Description:���¶�ʱ����
	 * @param req
	 */
	public void updateJob(QuartzJobUpdateReq req);

	/**
	 * 
	 * @Title: deleteJob
	 * @Description:ɾ����ʱ����
	 * @param req
	 */
	public void deleteJob(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: enabledJob
	 * @Description:���ö�ʱ����
	 * @param req
	 */
	public void enabledJob(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: disabledJob
	 * @Description:���ö�ʱ����
	 * @param req
	 */
	public void disabledJob(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: saveTemplate
	 * @Description:����ģ��
	 * @param req
	 */
	public void saveTemplate(QuartzTemplateSaveReq req);

	/**
	 * 
	 * @Title: updateTemplate
	 * @Description:����ģ��
	 * @param req
	 */
	public void updateTemplate(QuartzTemplateUpdateReq req);

	/**
	 * 
	 * @Title: deleteTemplate
	 * @Description:ɾ��ģ��
	 * @param req
	 */
	public void deleteTemplate(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: enabledTemplate
	 * @Description:����ģ��
	 * @param req
	 */
	public void enabledTemplate(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: disabledTemplate
	 * @Description:����ģ��
	 * @param req
	 */
	public void disabledTemplate(JLFMVCIdAndVersionRequest req);

}
