package org.jlf.plugin.dbpool.server.api;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.jlf.core.api.JLFIPlugin;

/**
 * 
 * @ClassName: JAFDb
 * @Description:DB插件api
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public interface JLFDbPool extends JLFIPlugin {

	/**
	 * 
	 * @Title: isOpenConn
	 * @Description:判断当前是否已打开dbName的连接
	 * @param dbName
	 * @return
	 * @throws Exception
	 */
	public boolean isOpenConn(String dbName) throws Exception;

	/**
	 * 
	 * @Title: openConn
	 * @Description:打开当前dbName的连接
	 * @param dbName
	 * @throws Exception
	 */
	public void openConn(String dbName) throws Exception;

	/**
	 * 
	 * @Title: getConn
	 * @Description:获取当前dbName的连接
	 * @param dbName
	 * @return
	 * @throws Exception
	 */
	public Connection getConn(String dbName) throws Exception;

	/**
	 * 
	 * @Title: closeConn
	 * @Description:关闭dbName的连接
	 * @param dbName
	 * @throws Exception
	 */
	public void closeConn(String dbName) throws Exception;

	/**
	 * 
	 * @Title: isOpenTrans
	 * @Description:判断当前是否已开启dbName的事物
	 * @param dbName
	 * @return
	 * @throws Exception
	 */
	public boolean isOpenTrans(String dbName) throws Exception;

	/**
	 * 
	 * @Title: openTrans
	 * @Description:打开dbName的事物
	 * @param dbName
	 * @throws Exception
	 */
	public void openTrans(String dbName) throws Exception;

	/**
	 * 
	 * @Title: commitTrans
	 * @Description:提交dbName的事物
	 * @param dbName
	 * @throws Exception
	 */
	public void commitTrans(String dbName) throws Exception;

	/**
	 * 
	 * @Title: rollbackTrans
	 * @Description:回滚事物
	 * @throws Exception
	 */
	public void rollbackTrans() throws Exception;

	/**
	 * 
	 * @Title: initChildDatabases
	 * @Description:初始化子库
	 * @param configs
	 * @throws Exception
	 */
	public void initChildDatabases(List<Map<String,Object>> configs) throws Exception;

}
