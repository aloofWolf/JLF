package org.jlf.soa.mvc.dao.blacklist.mq;

import java.io.Serializable;
import java.util.Date;

public class JLFMVCBlackListBean implements Serializable{
	
	private static final long serialVersionUID = 2496292268792789583L;
	private JLFMVCBlackListOperatorType type;
	private String dbName;
	private String tableName;
	private Long id;
	private Date expireTime;
	
	
	public JLFMVCBlackListOperatorType getType() {
		return type;
	}
	public void setType(JLFMVCBlackListOperatorType type) {
		this.type = type;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	

}
