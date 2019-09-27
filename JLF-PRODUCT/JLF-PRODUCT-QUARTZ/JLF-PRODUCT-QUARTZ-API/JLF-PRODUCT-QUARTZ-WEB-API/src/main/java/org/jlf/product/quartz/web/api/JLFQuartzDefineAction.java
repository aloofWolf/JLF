package org.jlf.product.quartz.web.api;

import java.util.List;

import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;

/**
 * 
 * @ClassName: JLFQuartzDefineAction
 * @Description:JLFQuartzDefineActionApi
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public interface JLFQuartzDefineAction {

	/**
	 * 
	 * @Title: saveJob
	 * @Description:���涨ʱ����
	 * @param job
	 */
	public void saveJob(JLFQuartzJobEntity job);

	/**
	 * 
	 * @Title: saveJobs
	 * @Description:����һ�鶨ʱ����
	 * @param job
	 */
	public void saveJobs(String groupName, List<JLFQuartzJobEntity> jobs);
	
	/**
	 * 
	 * @Title: addJob
	 * @Description:��һ��group����ӵ�����ʱ����
	 * @param job
	 */
	public void addJob(String groupName,JLFQuartzJobEntity job);

	/**
	 * 
	 * @Title: addJobs
	 * @Description:��һ��group�����һ�鶨ʱ����
	 * @param job
	 */
	public void addJobs(String groupName, List<JLFQuartzJobEntity> jobs);

	/**
	 * 
	 * @Title: updateJob
	 * @Description:���¶�ʱ����
	 * @param id
	 * @param version
	 * @param job
	 */
	public void updateJob(Long id, Long version, JLFQuartzJobEntity job);

	/**
	 * 
	 * @Title: deleteJob
	 * @Description:ɾ����ʱ����
	 * @param id
	 * @param version
	 */
	public void deleteJob(Long id, Long version);

	/**
	 * 
	 * @Title: deleteJobs
	 * @Description:ɾ��һ�鶨ʱ����
	 * @param id
	 * @param version
	 */
	public void deleteJobs(String groupName);

	/**
	 * 
	 * @Title: enabledJob
	 * @Description:���ö�ʱ����
	 * @param id
	 * @param version
	 */
	public void enabledJob(Long id, Long version);

	/**
	 * 
	 * @Title: enabledJobs
	 * @Description:����һ�鶨ʱ����
	 * @param id
	 * @param version
	 */
	public void enabledJobs(String groupName);

	/**
	 * 
	 * @Title: disabledJob
	 * @Description:����һ�鶨ʱ����
	 * @param id
	 * @param version
	 */
	public void disabledJob(Long id, Long version);

	/**
	 * 
	 * @Title: disabledJobs
	 * @Description:����һ�鶨ʱ����
	 * @param id
	 * @param version
	 */
	public void disabledJobs(String groupName);

	/**
	 * 
	 * @Title: saveTemplate
	 * @Description:����ģ��
	 * @param template
	 */
	public void saveTemplate(JLFQuartzTemplateEntity template);

	/**
	 * 
	 * @Title: updateTemplate
	 * @Description:����ģ��
	 * @param id
	 * @param version
	 * @param template
	 */
	public void updateTemplate(Long id, Long version, JLFQuartzTemplateEntity template);

	/**
	 * 
	 * @Title: deleteTemplate
	 * @Description:ɾ��ģ��
	 * @param id
	 * @param version
	 */
	public void deleteTemplate(Long id, Long version);

	/**
	 * 
	 * @Title: enabledTemplate
	 * @Description:����ģ��
	 * @param id
	 * @param version
	 */
	public void enabledTemplate(Long id, Long version);

	/**
	 * 
	 * @Title: disabledTemplate
	 * @Description:����ģ��
	 * @param id
	 * @param version
	 */
	public void disabledTemplate(Long id, Long version);


	/**
	 * 
	 * @Title: transferJob
	 * @Description: ��ʱ�����ƽ�,�ӵ�ǰ�������ƽ�����һ̨������
	 * @param id
	 * @param version
	 * @param hostIp
	 */
	public void transferJob(Long id, Long version, String hostIp);

	/**
	 * 
	 * @Title: batchTransferJob
	 * @Description: ��ʱ���������ƽ�,��һ̨�������µ����������ƽ�����һ̨������
	 * @param oldHostIp
	 * @param newHostIp
	 */
	public void batchTransferJob(String oldHostIp, String newHostIp);

}
