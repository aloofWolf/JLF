package org.jlf.product.server.core.quartz.custom.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzJobPageReq;
import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: QuartzExecuteDao
 * @Description:QuartzExecuteDao
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzJobDao extends JLFMVCDao<JLFQuartzJobEntity> {

	/**
	 * 
	 * @Title: getPage
	 * @Description:查询定时任务分页
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzJobEntity> getPage(JLFQuartzJobPageReq req) {
		JLFMVCSqlBean sqlBean = getSqlBean(req);
		return this.getPage(sqlBean, req.getPages().getPageNum(), req.getPages().getPageSize());
	}

	/**
	 * 
	 * @Title: getJobDetail
	 * @Description:获取jobDetail
	 * @param id
	 * @return
	 */
	public JLFQuartzJobEntity getJobDetail(Long id) {
		String sql = "select e.id,e.version,e.templateId,e.billId,e.cron,e.enabled,e.params,l.templateName,l.clsName "
				+ "e,quartzTemplate l where e.templateId=l.id";
		return this.getUnique(sql, id);
	}

	/**
	 * 
	 * @Title: getSqlBean
	 * @Description:获取getSqlBean
	 * @param req
	 * @return
	 */
	public JLFMVCSqlBean getSqlBean(JLFQuartzJobPageReq req) {
		String selectSql = "select e.id,e.version,e.templateId,e.billId,e.cron,e.enabled,e.params,l.templateName,l.clsName ";
		StringBuffer fromSql = new StringBuffer("from ").append(this.tableName)
				.append(" e,quartzTemplate l where e.templateId=l.id");
		List<Object> params = new ArrayList<Object>();
		if (req.getTemplateId() != null) {
			fromSql.append(" and e.templateId = ?");
			params.add(req.getTemplateId());
		}
		if (req.getTemplateName() != null || req.getTemplateName().length() > 0) {
			fromSql.append(" and locate(?,e.templateName) > 0");
			params.add(req.getTemplateName());
		}
		if (req.getBillId() != null) {
			fromSql.append(" and billId = ?");
			params.add(req.getBillId());
		}
		if (req.getEnabled() != null) {
			fromSql.append(" and e.enabled = ?");
			params.add(req.getEnabled().getId());
		}
		return new JLFMVCSqlBean(selectSql, fromSql.toString(), params.toArray(new Object[0]));
	}

	/**
	 * 
	 * @Title: reStartByTemplateId
	 * @Description:重启一个模板下所有已启动的任务
	 * @param templateId
	 */
	public void reStartByTemplateId(Long templateId) {
		String sql = "update QuartzJob set updateTime = ? where templateId = ? and enabled = ? and isDelete = ?";
		this.execute(sql, new Date(), templateId, BooleanType.TRUE.getId(), BooleanType.FALSE.getId());
	}

	/**
	 * 
	 * @Title: disabledByTemplateId
	 * @Description:禁用一个模板下所有已启动的任务
	 * @param templateId
	 */
	public void disabledByTemplateId(Long templateId) {
		String sql = "update QuartzJob set updateTime = ? where templateId = ? and enabled = ? and isDelete = ?";
		this.execute(sql, BooleanType.FALSE.getId(), new Date(), templateId, BooleanType.TRUE.getId(),
				BooleanType.FALSE.getId());
	}

	/**
	 * 
	 * @Title: getListByupdateTime
	 * @Description:查询比指定的updateTime大的定时任务列表
	 * @param updateTime
	 * @return
	 */
	public List<JLFQuartzJobEntity> getListByupdateTime(Date updateTime) {
		String sql = new StringBuffer(
				"select e.id,e.version,e.templateId,e.billId,e.cron,e.enabled,e.params,l.templateName,l.clsName ")
						.append(" from ").append(this.tableName).append(" e,QuartzTemplate l where e.templateId=l.id")
						.append(" and e.updateTime >= ?").toString();
		return this.getList(sql, updateTime);
	}

	/**
	 * 
	 * @Title: getList
	 * @Description:根据groupName查询列表
	 * @param updateTime
	 * @return
	 */
	public List<JLFQuartzJobEntity> getListByGroupName(String groupName) {
		String sql = new StringBuffer("select e.id ").append(" from ").append(this.tableName)
				.append(" where groupName = ? and isDelete = ?").toString();
		return this.getList(sql, groupName, BooleanType.FALSE.getId());
	}

	/**
	 * 
	 * @Title: deleteByGroup
	 * @Description: 删除一组任务
	 * @param groupName
	 */
	public void deleteByGroup(String groupName) {
		String sql = new StringBuffer(" update ").append(this.tableName)
				.append(" set isDelete = ?,updateTime = ? where isDelete = ? and groupName = ?").toString();
		this.execute(sql, BooleanType.TRUE.getId(), new Date(), BooleanType.FALSE.getId(), groupName);
	}

	/**
	 * 
	 * @Title: updateEnableByGroup
	 * @Description: 修改一组下的enabled
	 * @param groupName
	 * @param enabled
	 */
	public void updateEnableByGroup(String groupName, BooleanType newEnabled, BooleanType oldEnabled) {
		String sql = new StringBuffer(" update ").append(this.tableName)
				.append(" set enabled = ?,updateTime = ? where isDelete = ? and groupName = ? and enabled = ?")
				.toString();
		this.execute(sql, newEnabled.getId(), new Date(), BooleanType.FALSE.getId(), groupName, oldEnabled.getId());
	}

	/**
	 * 
	 * @Title: updateHostIp
	 * @Description: 批量修改hostIp
	 * @param oldHostIp
	 * @param newHostIp
	 */
	public void updateHostIp(String oldHostIp, String newHostIp) {
		String sql = new StringBuffer(" update ").append(this.tableName)
				.append(" set hostIp = ?,updateTime = ? where isDelete = ? and hostIp = ?").toString();
		this.execute(sql, newHostIp, new Date(), BooleanType.FALSE.getId(), oldHostIp);
	}

	@Override
	public void moreBeanGroup(JLFQuartzJobEntity job) {
		job.setTemplate(job.get(JLFQuartzTemplateEntity.class));
	}

}
