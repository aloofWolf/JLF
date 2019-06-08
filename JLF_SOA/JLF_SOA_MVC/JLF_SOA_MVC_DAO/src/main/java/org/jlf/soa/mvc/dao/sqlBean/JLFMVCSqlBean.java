package org.jlf.soa.mvc.dao.sqlBean;

/**
 * 
 * @ClassName: JLFMVCSqlBean
 * @Description:JLFMVCSqlBean
 * @author Lone Wolf
 * @date 2019��6��1��
 */
public class JLFMVCSqlBean {

	private String selectSql; // select�־�sql

	private String totFieldSql; // ��ҳ�����ֶ�sql

	private String fromSql; // from�־�sql

	private Object[] params;// ����

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
	 * @Description:��ȡ��ͨ��ѯ����sql
	 * @return
	 */
	public String getQrySql() {
		return new StringBuffer(selectSql).append(fromSql).toString();
	}

	/**
	 * 
	 * @Title: getTotSql
	 * @Description:��ȡ��ҳ��������sql
	 * @return
	 */
	public String getTotSql() {
		return new StringBuffer(totFieldSql).append(" count(1) as cnt ").append(fromSql).toString();
	}

	/**
	 * 
	 * @Title: getPageSql
	 * @Description:��ȡ��ҳ��ѯsql
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
