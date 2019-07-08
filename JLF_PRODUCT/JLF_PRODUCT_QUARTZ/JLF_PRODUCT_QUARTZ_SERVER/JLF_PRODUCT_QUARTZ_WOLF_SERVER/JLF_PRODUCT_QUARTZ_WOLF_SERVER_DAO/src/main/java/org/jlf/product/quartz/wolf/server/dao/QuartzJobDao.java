package org.jlf.product.quartz.wolf.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobListReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobPageReq;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;

/**
 * 
 * @ClassName: QuartzExecuteDao
 * @Description:QuartzExecuteDao
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzJobDao extends JLFMVCDao<QuartzJob> {

	/**
	 * 
	 * @Title: getPage
	 * @Description:查询定时任务分页
	 * @param req
	 * @return
	 */
	public JLFMVCPage<QuartzJob> getPage(QuartzJobPageReq req) {
		JLFMVCSqlBean sqlBean = getSqlBean(req);
		return this.getPage(sqlBean, req.getPages().getPageNum(), req.getPages().getPageSize());
	}

	/**
	 * 
	 * @Title: getList
	 * @Description:查询定时任务列表
	 * @param req
	 * @return
	 */
	public List<QuartzJob> getList(QuartzJobListReq req) {
		JLFMVCSqlBean sqlBean = getSqlBean(req);
		String sql = sqlBean.getQrySql();
		return this.getList(sql, sqlBean.getParams());
	}

	/**
	 * 
	 * @Title: getJobDetail
	 * @Description:获取jobDetail
	 * @param id
	 * @return
	 */
	public QuartzJob getJobDetail(Long id) {
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
	public JLFMVCSqlBean getSqlBean(QuartzJobListReq req) {
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
		String sql = "update QuartzJob set ready = ? where templateId = ? and enabled = ? and isDelete = ?";
		this.execute(sql, BooleanType.TRUE.getId(), templateId, BooleanType.TRUE.getId(), BooleanType.FALSE.getId());
	}

	/**
	 * 
	 * @Title: disabledByTemplateId
	 * @Description:禁用一个模板下所有已启动的任务
	 * @param templateId
	 */
	public void disabledByTemplateId(Long templateId) {
		String sql = "update QuartzJob set enabled = ?,ready = ? where templateId = ? and enabled = ? and isDelete = ?";
		this.execute(sql, BooleanType.FALSE.getId(), BooleanType.TRUE.getId(), templateId, BooleanType.TRUE.getId(),
				BooleanType.FALSE.getId());
	}

	/**
	 * 
	 * @Title: getReadyList
	 * @Description:根据就绪状态查询定时任务列表
	 * @return
	 */
	public List<QuartzJob> getReadyList(BooleanType ready) {
		String sql = new StringBuffer(
				"select e.id,e.version,e.templateId,e.billId,e.cron,e.enabled,e.params,l.templateName,l.clsName ")
						.append(" from ").append(this.tableName).append(" e,QuartzTemplate l where e.templateId=l.id")
						.append(" and ready = ?").toString();
		return this.getList(sql, ready.getId());
	}

	/**
	 * 
	 * @Title: updateAllReady
	 * @Description:将所有的job改为就绪状态
	 */
	public void updateAllReady() {
		String sql = "update QuartzJob set ready = ? where isDelete = ?";
		this.execute(sql, BooleanType.TRUE.getId(), BooleanType.FALSE.getId());
	}
}
