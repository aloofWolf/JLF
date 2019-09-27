package org.jlf.product.server.core.log.custom.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jlf.common.util.DateUtil;
import org.jlf.product.log.web.metadata.entity.JLFLogEntity;
import org.jlf.product.log.web.metadata.request.JLFLogPageReq;
import org.jlf.soa.mvc.dao.JLFMVCDao;
import org.jlf.soa.mvc.dao.JLFMVCDaoMapping;
import org.jlf.soa.mvc.dao.sqlBean.JLFMVCSqlBean;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;

/**
 * 
 * @ClassName: LogDao
 * @Description: LogDao
 * @author Lone Wolf
 * @date 2019年9月24日
 */
public class LogDao extends JLFMVCDao<JLFLogEntity> {

	private final String RENAMETABLE_SQL = "ALTER TABLE %s RENAME TO %s";

	private final String CREATETABLE_SQL = "CREATE TABLE %s LIKE %s";

	/**
	 * 
	 * @Title: getPage
	 * @Description:查询日志分页
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFLogEntity> getPage(JLFLogPageReq req) {
		JLFMVCSqlBean sqlBean = getSqlBean(req);
		return this.getPage(sqlBean, req.getPages().getPageNum(), req.getPages().getPageSize());
	}

	/**
	 * 
	 * @Title: getById
	 * @Description:查看日志详情
	 * @param id
	 * @param queryMonth
	 * @return
	 */
	public JLFLogEntity getById(Long id, Integer queryMonth) {
		String tableName = getTableName(queryMonth);
		return this.getById(id, tableName);
	}

	/**
	 * 
	 * @Title: getSqlBean
	 * @Description:获取SqlBean
	 * @param req
	 * @return
	 */
	public JLFMVCSqlBean getSqlBean(JLFLogPageReq req) {
		String tableName = getTableName(req.getQueryMonth());
		String selectSql = "select id,userId,userName,reqType,dbName,requestTime,responseTime,params,result,errMsg ";
		StringBuffer fromSql = new StringBuffer("from ").append(tableName).append("  where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (req.getUserId() != null) {
			fromSql.append(" and userId = ?");
			params.add(req.getUserId());
		}
		if (req.getUserName() != null && req.getUserName().length() > 0) {
			fromSql.append(" and locate(?,userName) > 0");
			params.add(req.getUserName());
		}
		if (req.getReqType() != null && req.getReqType().length() > 0) {
			fromSql.append(" and locate(?,reqType) > 0");
			params.add(req.getReqType());
		}
		if (req.getDbName() != null) {
			fromSql.append(" and dbName = ?");
			params.add(req.getDbName());
		}
		if (req.getRequestTimeStart() != null) {
			fromSql.append(" and requestTime >= ?");
			params.add(req.getRequestTimeStart());
		}
		if (req.getRequestTimeEnd() != null) {
			fromSql.append(" and requestTime <= ?");
			params.add(req.getRequestTimeEnd());
		}
		if (req.getResponseTimeStart() != null) {
			fromSql.append(" and requestTime >= ?");
			params.add(req.getResponseTimeStart());
		}
		if (req.getResponseTimeEnd() != null) {
			fromSql.append(" and responseTime <= ?");
			params.add(req.getResponseTimeEnd());
		}
		if (req.getParams() != null && req.getParams().length() > 0) {
			fromSql.append(" and locate(?,params) > 0");
			params.add(req.getParams());
		}
		if (req.getResult() != null) {
			fromSql.append(" and result <= ?");
			params.add(req.getResult().getId());
		}
		if (req.getErrMsg() != null && req.getErrMsg().length() > 0) {
			fromSql.append(" and locate(?,errMsg) > 0");
			params.add(req.getErrMsg());
		}
		return new JLFMVCSqlBean(selectSql, fromSql.toString(), params.toArray(new Object[0]));
	}

	/**
	 * 
	 * @Title: getTableName
	 * @Description:根据查询月份获取表名
	 * @param queryMonth
	 * @return
	 */
	private String getTableName(Integer month) {
		String tableName = this.tableName;
		String currMonth = DateUtil.getDateString(new Date(), "YYYYMM");
		if (Integer.parseInt(currMonth) != month) {
			tableName = new StringBuilder(tableName).append(tableNameSeparator).append(month).toString();
		}
		return tableName;
	}

	/**
	 * 
	 * @Title: createNewTable
	 * @Description:创建新表
	 */
	public void createNewTable() {
		String beforeMonth = DateUtil.getSomeDayBefore(new Date(), 28, "YYYYMM");
		String beforeTableName = getTableName(Integer.parseInt(beforeMonth));
		String reNameTableSql = String.format(RENAMETABLE_SQL, this.tableName, beforeTableName);
		String createTableSql = String.format(CREATETABLE_SQL, this.tableName, beforeTableName);
		this.execute(reNameTableSql);
		JLFMVCDaoMapping.addTableNameEntityMapping(beforeTableName, JLFLogEntity.class);
		this.execute(createTableSql);
	}

}
