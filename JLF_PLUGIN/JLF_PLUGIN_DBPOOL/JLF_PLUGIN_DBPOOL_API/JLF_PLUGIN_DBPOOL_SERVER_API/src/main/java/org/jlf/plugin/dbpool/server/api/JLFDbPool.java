package org.jlf.plugin.dbPool.server.api;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JAFDb
 * @Description:DB插件api
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public interface JLFDbPool extends JLFPluginServerApi {

	public static final String mainDbName = "MAIN";

	/**
	 * 
	 * @Title: isOpenConn
	 * @Description:判断当前是否已打开dbName的连接
	 * @param dbName
	 * @return
	 */
	public boolean isOpenConn(String dbName);

	/**
	 * 
	 * @Title: openConn
	 * @Description:打开当前dbName的连接
	 * @param dbName
	 */
	public void openConn(String dbName);

	/**
	 * 
	 * @Title: getConn
	 * @Description:获取当前dbName的连接
	 * @param dbName
	 * @return
	 */
	public Connection getConn(String dbName);

	/**
	 * 
	 * @Title: closeConn
	 * @Description:关闭dbName的连接
	 * @param dbName
	 */
	public void closeConn(String dbName);

	/**
	 * 
	 * @Title: closeAllConn
	 * @Description:关闭当前线程所有连接
	 */
	public void closeAllConn();

	/**
	 * 
	 * @Title: isOpenTrans
	 * @Description:判断当前是否已开启dbName的事物
	 * @param dbName
	 * @return
	 */
	public boolean isOpenTrans(String dbName);

	/**
	 * 
	 * @Title: openTrans
	 * @Description:打开dbName的事物
	 * @param dbName
	 */
	public void openTrans(String dbName);

	/**
	 * 
	 * @Title: commitTrans
	 * @Description:提交dbName的事物
	 * @param dbName
	 */
	public void commitTrans(String dbName);

	/**
	 * 
	 * @Title: rollbackTrans
	 * @Description:回滚事物
	 */
	public void rollbackTrans();

	/**
	 * 
	 * @Title: initChildDatabases
	 * @Description:初始化子库
	 * @param configs
	 */
	public void initChildDatabases(List<Map<String, Object>> configs);

}
