package org.jlf.product.server.core.ops.custom.dao;

import java.util.ArrayList;
import java.util.List;

import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageReq;
import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: OpsLogDao
 * @Description:OpsLogDao
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class OpsLogDao extends JLFMVCDao<JLFOpsLog> {

	/**
	 * 
	 * @Title: getPage
	 * @Description:查询运维日志分页信息
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFOpsLog> getPage(JLFOpsLogPageReq req) {
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
	public JLFMVCSqlBean getSqlBean(JLFOpsLogPageReq req) {
		String selectSql = new StringBuffer("select ").append(this.fieldStr).toString();
		StringBuffer fromSql = new StringBuffer("from ").append(this.tableName).append(" where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (req.getModule() != null) {
			fromSql.append(" and module = ?");
			params.add(req.getModule());
		}
		if (req.getType() != null) {
			fromSql.append(" and type = ?");
			params.add(req.getType());
		}
		if (req.getClientClsName() != null && req.getClientClsName().length() > 0) {
			fromSql.append(" and locate(?,clientCode) > 0");
			params.add(req.getClientClsName());
		}
		if (req.getServerClsName() != null && req.getServerClsName().length() > 0) {
			fromSql.append(" and locate(?,serverCode) > 0");
			params.add(req.getServerClsName());
		}
		if (req.getHostIp() != null && req.getHostIp().length() > 0) {
			fromSql.append(" and locate(?,hostCode) > 0");
			params.add(req.getHostIp());
		}
		if (req.getStartTime() != null) {
			fromSql.append(" and startTime >= ?");
			params.add(req.getStartTime());
		}
		if (req.getEndTime() != null) {
			fromSql.append(" and endTime <= ?");
			params.add(req.getEndTime());
		}
		if (req.getUserId() != null) {
			fromSql.append(" and createUserId = ?");
			params.add(req.getUserId());
		}
		if (req.getUserName() != null && req.getUserName().length() > 0) {
			fromSql.append(" and locate(?,createUserName) > 0");
			params.add(req.getUserName());
		}
		if (req.getOpsResult() != null) {
			fromSql.append(" and opsResult = ?");
			params.add(req.getOpsResult().getId());
		}
		if (req.getFailReason() != null && req.getFailReason().length() > 0) {
			fromSql.append(" and locate(?,failReason) > 0");
			params.add(req.getFailReason());
		}
		return new JLFMVCSqlBean(selectSql, fromSql.toString(), params.toArray(new Object[0]));
	}

}
