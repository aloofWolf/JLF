package org.jlf.plugin.dbpool.server.api;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.jlf.core.api.JLFIPlugin;

/**
 * 
 * @ClassName: JAFDb
 * @Description:DB���api
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public interface JLFDbPool extends JLFIPlugin {

	/**
	 * 
	 * @Title: isOpenConn
	 * @Description:�жϵ�ǰ�Ƿ��Ѵ�dbName������
	 * @param dbName
	 * @return
	 * @throws Exception
	 */
	public boolean isOpenConn(String dbName) throws Exception;

	/**
	 * 
	 * @Title: openConn
	 * @Description:�򿪵�ǰdbName������
	 * @param dbName
	 * @throws Exception
	 */
	public void openConn(String dbName) throws Exception;

	/**
	 * 
	 * @Title: getConn
	 * @Description:��ȡ��ǰdbName������
	 * @param dbName
	 * @return
	 * @throws Exception
	 */
	public Connection getConn(String dbName) throws Exception;

	/**
	 * 
	 * @Title: closeConn
	 * @Description:�ر�dbName������
	 * @param dbName
	 * @throws Exception
	 */
	public void closeConn(String dbName) throws Exception;

	/**
	 * 
	 * @Title: isOpenTrans
	 * @Description:�жϵ�ǰ�Ƿ��ѿ���dbName������
	 * @param dbName
	 * @return
	 * @throws Exception
	 */
	public boolean isOpenTrans(String dbName) throws Exception;

	/**
	 * 
	 * @Title: openTrans
	 * @Description:��dbName������
	 * @param dbName
	 * @throws Exception
	 */
	public void openTrans(String dbName) throws Exception;

	/**
	 * 
	 * @Title: commitTrans
	 * @Description:�ύdbName������
	 * @param dbName
	 * @throws Exception
	 */
	public void commitTrans(String dbName) throws Exception;

	/**
	 * 
	 * @Title: rollbackTrans
	 * @Description:�ع�����
	 * @throws Exception
	 */
	public void rollbackTrans() throws Exception;

	/**
	 * 
	 * @Title: initChildDatabases
	 * @Description:��ʼ���ӿ�
	 * @param configs
	 * @throws Exception
	 */
	public void initChildDatabases(List<Map<String,Object>> configs) throws Exception;

}
