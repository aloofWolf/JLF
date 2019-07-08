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
 * @date 2019年7月5日
 */
@JLFMVCRouteCls(name = "defineQuery")
public interface JLFQuartzDefineAction {

	/**
	 * 
	 * @Title: saveJob
	 * @Description:保存一组定时任务
	 * @param req
	 */
	public void saveJob(QuartzJobSaveReq req);

	/**
	 * 
	 * @Title: updateJob
	 * @Description:更新定时任务
	 * @param req
	 */
	public void updateJob(QuartzJobUpdateReq req);

	/**
	 * 
	 * @Title: deleteJob
	 * @Description:删除定时任务
	 * @param req
	 */
	public void deleteJob(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: enabledJob
	 * @Description:启用定时任务
	 * @param req
	 */
	public void enabledJob(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: disabledJob
	 * @Description:禁用定时任务
	 * @param req
	 */
	public void disabledJob(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: saveTemplate
	 * @Description:保存模板
	 * @param req
	 */
	public void saveTemplate(QuartzTemplateSaveReq req);

	/**
	 * 
	 * @Title: updateTemplate
	 * @Description:更新模板
	 * @param req
	 */
	public void updateTemplate(QuartzTemplateUpdateReq req);

	/**
	 * 
	 * @Title: deleteTemplate
	 * @Description:删除模板
	 * @param req
	 */
	public void deleteTemplate(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: enabledTemplate
	 * @Description:启用模板
	 * @param req
	 */
	public void enabledTemplate(JLFMVCIdAndVersionRequest req);

	/**
	 * 
	 * @Title: disabledTemplate
	 * @Description:禁用模板
	 * @param req
	 */
	public void disabledTemplate(JLFMVCIdAndVersionRequest req);

}
