package org.jlf.product.quartz.web.api;

import java.util.List;

import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;

/**
 * 
 * @ClassName: JLFQuartzDefineAction
 * @Description:JLFQuartzDefineActionApi
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public interface JLFQuartzDefineAction {

	/**
	 * 
	 * @Title: saveJob
	 * @Description:保存定时任务
	 * @param job
	 */
	public void saveJob(JLFQuartzJobEntity job);

	/**
	 * 
	 * @Title: saveJobs
	 * @Description:保存一组定时任务
	 * @param job
	 */
	public void saveJobs(String groupName, List<JLFQuartzJobEntity> jobs);
	
	/**
	 * 
	 * @Title: addJob
	 * @Description:向一个group中添加单个定时任务
	 * @param job
	 */
	public void addJob(String groupName,JLFQuartzJobEntity job);

	/**
	 * 
	 * @Title: addJobs
	 * @Description:向一个group中添加一组定时任务
	 * @param job
	 */
	public void addJobs(String groupName, List<JLFQuartzJobEntity> jobs);

	/**
	 * 
	 * @Title: updateJob
	 * @Description:更新定时任务
	 * @param id
	 * @param version
	 * @param job
	 */
	public void updateJob(Long id, Long version, JLFQuartzJobEntity job);

	/**
	 * 
	 * @Title: deleteJob
	 * @Description:删除定时任务
	 * @param id
	 * @param version
	 */
	public void deleteJob(Long id, Long version);

	/**
	 * 
	 * @Title: deleteJobs
	 * @Description:删除一组定时任务
	 * @param id
	 * @param version
	 */
	public void deleteJobs(String groupName);

	/**
	 * 
	 * @Title: enabledJob
	 * @Description:启用定时任务
	 * @param id
	 * @param version
	 */
	public void enabledJob(Long id, Long version);

	/**
	 * 
	 * @Title: enabledJobs
	 * @Description:启用一组定时任务
	 * @param id
	 * @param version
	 */
	public void enabledJobs(String groupName);

	/**
	 * 
	 * @Title: disabledJob
	 * @Description:禁用一组定时任务
	 * @param id
	 * @param version
	 */
	public void disabledJob(Long id, Long version);

	/**
	 * 
	 * @Title: disabledJobs
	 * @Description:禁用一组定时任务
	 * @param id
	 * @param version
	 */
	public void disabledJobs(String groupName);

	/**
	 * 
	 * @Title: saveTemplate
	 * @Description:保存模板
	 * @param template
	 */
	public void saveTemplate(JLFQuartzTemplateEntity template);

	/**
	 * 
	 * @Title: updateTemplate
	 * @Description:更新模板
	 * @param id
	 * @param version
	 * @param template
	 */
	public void updateTemplate(Long id, Long version, JLFQuartzTemplateEntity template);

	/**
	 * 
	 * @Title: deleteTemplate
	 * @Description:删除模板
	 * @param id
	 * @param version
	 */
	public void deleteTemplate(Long id, Long version);

	/**
	 * 
	 * @Title: enabledTemplate
	 * @Description:启用模板
	 * @param id
	 * @param version
	 */
	public void enabledTemplate(Long id, Long version);

	/**
	 * 
	 * @Title: disabledTemplate
	 * @Description:禁用模板
	 * @param id
	 * @param version
	 */
	public void disabledTemplate(Long id, Long version);


	/**
	 * 
	 * @Title: transferJob
	 * @Description: 定时任务移交,从当前服务器移交到另一台服务器
	 * @param id
	 * @param version
	 * @param hostIp
	 */
	public void transferJob(Long id, Long version, String hostIp);

	/**
	 * 
	 * @Title: batchTransferJob
	 * @Description: 定时任务批量移交,将一台服务器下的所有任务移交到另一台服务器
	 * @param oldHostIp
	 * @param newHostIp
	 */
	public void batchTransferJob(String oldHostIp, String newHostIp);

}
