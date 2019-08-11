package org.jlf.plugin.server.core.dbPool.c3p0.config;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: C3p0ChildConfig
 * @Description:c3p0�ӿ�����
 * @author Lone Wolf
 * @date 2019��7��6��
 */
public class C3p0ChildConfig extends C3p0MainConfig {

	private String dbName;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		if (dbName.equals(JLFDbPool.mainDbName)) {
			throw new JLFException("���ݿ����Ʋ����������ݿ�������ͬ:" + dbName);
		}
		this.dbName = dbName;
	}

}
