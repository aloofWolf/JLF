package org.jlf.plugin.dbPool.server.api;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JAFDb
 * @Description:DB���api
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public interface JLFDbPool extends JLFPluginServerApi {

	public static final String mainDbName = "MAIN";

	/**
	 * 
	 * @Title: isOpenConn
	 * @Description:�жϵ�ǰ�Ƿ��Ѵ�dbName������
	 * @param dbName
	 * @return
	 */
	public boolean isOpenConn(String dbName);

	/**
	 * 
	 * @Title: openConn
	 * @Description:�򿪵�ǰdbName������
	 * @param dbName
	 */
	public void openConn(String dbName);

	/**
	 * 
	 * @Title: getConn
	 * @Description:��ȡ��ǰdbName������
	 * @param dbName
	 * @return
	 */
	public Connection getConn(String dbName);

	/**
	 * 
	 * @Title: closeConn
	 * @Description:�ر�dbName������
	 * @param dbName
	 */
	public void closeConn(String dbName);

	/**
	 * 
	 * @Title: closeAllConn
	 * @Description:�رյ�ǰ�߳���������
	 */
	public void closeAllConn();

	/**
	 * 
	 * @Title: isOpenTrans
	 * @Description:�жϵ�ǰ�Ƿ��ѿ���dbName������
	 * @param dbName
	 * @return
	 */
	public boolean isOpenTrans(String dbName);

	/**
	 * 
	 * @Title: openTrans
	 * @Description:��dbName������
	 * @param dbName
	 */
	public void openTrans(String dbName);

	/**
	 * 
	 * @Title: commitTrans
	 * @Description:�ύdbName������
	 * @param dbName
	 */
	public void commitTrans(String dbName);

	/**
	 * 
	 * @Title: rollbackTrans
	 * @Description:�ع�����
	 */
	public void rollbackTrans();

	/**
	 * 
	 * @Title: initChildDatabases
	 * @Description:��ʼ���ӿ�
	 * @param configs
	 */
	public void initChildDatabases(List<Map<String, Object>> configs);

}
