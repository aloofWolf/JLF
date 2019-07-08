package org.jlf.plugin.dbPool.wolf.server.config;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;

/**
 * 
 * @ClassName: DbPoolWolfChildConfig
 * @Description:DbWolf�ӿ�����
 * @author Lone Wolf
 * @date 2019��7��6��
 */
public class DbPoolWolfChildConfig extends DbPoolWolfMainConfig {

	@JLFCheckAnn
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
