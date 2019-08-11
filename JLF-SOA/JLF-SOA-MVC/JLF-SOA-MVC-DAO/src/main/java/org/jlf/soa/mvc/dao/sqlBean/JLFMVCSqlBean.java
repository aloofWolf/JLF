package org.jlf.soa.mvc.dao.sqlBean;

/**
 * 
 * @ClassName: JLFMVCSqlBean
 * @Description:JLFMVCSqlBean
 * @author Lone Wolf
 * @date 2019年6月1日
 */
public class JLFMVCSqlBean {

	private String selectSql; // select字句sql

	private String totFieldSql; // 分页汇总字段sql

	private String fromSql; // from字句sql

	private Object[] params;// 参数

	public JLFMVCSqlBean(String selectSql, String fromSql, Object[] params) {
		this(selectSql, null, fromSql, params);
	}

	public JLFMVCSqlBean(String selectSql, String totFieldSql, String fromSql, Object[] params) {
		this.selectSql = selectSql;
		this.totFieldSql = totFieldSql;
		this.fromSql = fromSql;
		this.params = params;
	}

	/**
	 * 
	 * @Title: getQrySql
	 * @Description:获取普通查询语句的sql
	 * @return
	 */
	public String getQrySql() {
		return new StringBuffer(selectSql).append(fromSql).toString();
	}

	/**
	 * 
	 * @Title: getTotSql
	 * @Description:获取分页汇总语句的sql
	 * @return
	 */
	public String getTotSql() {
		return new StringBuffer(totFieldSql).append(" count(1) as cnt ").append(fromSql).toString();
	}

	/**
	 * 
	 * @Title: getPageSql
	 * @Description:获取分页查询sql
	 * @return
	 */
	public String getPageSql() {
		return new StringBuffer(selectSql).append(fromSql).append(" ").append("limit ?,?").toString();
	}

	public String getSelectSql() {
		return selectSql;
	}

	public void setSelectSql(String selectSql) {
		this.selectSql = selectSql;
	}

	public String getTotFieldSql() {
		return totFieldSql;
	}

	public void setTotFieldSql(String totFieldSql) {
		this.totFieldSql = totFieldSql;
	}

	public String getFromSql() {
		return fromSql;
	}

	public void setFromSql(String fromSql) {
		this.fromSql = fromSql;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

}
