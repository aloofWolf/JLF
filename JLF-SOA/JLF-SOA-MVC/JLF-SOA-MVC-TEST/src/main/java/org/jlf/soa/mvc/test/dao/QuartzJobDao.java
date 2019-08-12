package org.jlf.soa.mvc.test.dao;

import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.test.bean.QuartzJob;
import org.jlf.soa.mvc.test.bean.QuartzTemplate;

/**
 * 
 * @ClassName: QuartzJobDao
 * @Description:QuartzJobDao
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class QuartzJobDao extends JLFMVCDao<QuartzJob> {

	/**
	 * getQuartzJobSql
	 */
	String getQuartzJobSql = new StringBuffer("select").append(" job.id as jobId,").append("job.version as jobVersion,")
			.append("job.isDelete as jobIsDelete,").append("job.deleteNum as jobDeleteNum,")
			.append("job.createUserId as jobCreateUserId,").append("job.createTime as jobCreateTime,")
			.append("job.updateUserId as jobUpdateUserId,").append("job.updateTime as jobUpdateTime,")
			.append("job.templateId as jobTemplateId,").append("job.billId as jobBillId,")
			.append("job.cron as jobCron,").append("job.enabled as jobEnabled,").append("job.ready as jobReady,")
			.append("job.params as jobParams,").append("template.id as templateId,")
			.append("template.version as templateVersion,").append("template.isDelete as templateIsDelete,")
			.append("template.deleteNum as templateDeleteNum,").append("template.createUserId as templateCreateUserId,")
			.append("template.createTime as templateCreateTime,")
			.append("template.updateUserId as templateUpdateUserId,")
			.append("template.updateTime as templateUpdateTime,")
			.append("template.templateName as templateTemplateName,").append("template.clsName as templateClaName,")
			.append("template.enabled as templateEnable").append(" from QuartzJob as job,QuartzTemplate as template")
			.append(" where job.templateId = template.id and job.id = ?").toString();

	/**
	 * 
	 * @Title: getQuartzJobRelate
	 * @Description:QuartzJob,多表联查
	 * @param id
	 * @return
	 */
	public QuartzJob getQuartzJobRelate(Long id) {
		QuartzJob job = this.getUnique(getQuartzJobSql, id);
		job.setTemplate(job.get(QuartzTemplate.class));
		return job;
	}

}
