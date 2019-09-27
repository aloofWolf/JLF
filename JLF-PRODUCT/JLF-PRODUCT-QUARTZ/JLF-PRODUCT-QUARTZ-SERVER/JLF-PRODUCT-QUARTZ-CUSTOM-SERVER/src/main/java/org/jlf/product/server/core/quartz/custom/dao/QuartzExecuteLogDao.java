package org.jlf.product.server.core.quartz.custom.dao;

import java.util.ArrayList;
import java.util.List;

import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzExecuteLogEntity;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzExecuteLogPageReq;
import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: QuartzExecuteLogDao
 * @Description:QuartzExecuteLogDao
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzExecuteLogDao extends JLFMVCDao<JLFQuartzExecuteLogEntity> {

	/**
	 * 
	 * @Title: getPage
	 * @Description:查询执行日志分页信息
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzExecuteLogEntity> getPage(JLFQuartzExecuteLogPageReq req) {
		JLFMVCSqlBean sqlBean = getSqlBean(req);
		return this.getPage(sqlBean, req.getPages().getPageNum(), req.getPages().getPageSize());

	}

	/**
	 * 
	 * @Title: getSqlBean
	 * @Description:获取getSqlBean
	 * @param req
	 * @return
	 */
	public JLFMVCSqlBean getSqlBean(JLFQuartzExecuteLogPageReq req) {
		String selectSql = new StringBuffer("select ").append(this.fieldStr).toString();
		StringBuffer fromSql = new StringBuffer("from ").append(this.tableName).append(" where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (req.getTemplateId() != null) {
			fromSql.append(" and templateId = ?");
			params.add(req.getTemplateId());
		}
		if (req.getTemplateName() != null || req.getTemplateName().length() > 0) {
			fromSql.append(" and locate(?,templateName) > 0");
			params.add(req.getTemplateName());
		}
		if (req.getBillId() != null) {
			fromSql.append(" and billId = ?");
			params.add(req.getBillId());
		}
		if (req.getStartTime() != null) {
			fromSql.append(" and startTime >= ?");
			params.add(req.getStartTime());
		}
		if (req.getEndTime() != null) {
			fromSql.append(" and endTime <= ?");
			params.add(req.getEndTime());
		}
		if (req.getExecuteResult() != null) {
			fromSql.append(" and executeResult = ?");
			params.add(req.getExecuteResult().getId());
		}
		if (req.getFailReason() != null && req.getFailReason().length() > 0) {
			fromSql.append(" and locate(?,failReason) > 0");
			params.add(req.getFailReason());
		}
		return new JLFMVCSqlBean(selectSql, fromSql.toString(), params.toArray(new Object[0]));
	}

}
