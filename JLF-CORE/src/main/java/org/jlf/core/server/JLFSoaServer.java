package org.jlf.core.server;

import java.util.Properties;

import org.jlf.common.util.LogUtil;
import org.jlf.core.config.JLFConfig;

/**
 * 
 * @ClassName: JLFSoaServer
 * @Description:JLF架构服务端
 * @author Lone Wolf
 * @date 2019年6月2日
 */
public abstract class JLFSoaServer {

	/**
	 * 
	 * @Title: getSoaName
	 * @Description:获取架构名称
	 * @return
	 */
	public abstract String getSoaName();

	/**
	 * 
	 * @Title: initConfig
	 * @Description:启动服务
	 */
	public void start() {
	}

	/**
	 * 
	 * @Title: reStart
	 * @Description:重启插件服务
	 */
	public void reStart() {

	}

	/**
	 * 
	 * @Title: start
	 * @Description:启动架构服务
	 */
	public void startServer() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s启动开始。。。", serverName));
		try {
			start();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug(String.format("%s启动失败。。。", serverName));
			throw e;
		}
		LogUtil.get().debug(String.format("%s启动成功。。。", serverName));
	}

	/**
	 * 
	 * @Title: reStartServer
	 * @Description:启动插件服务
	 * @throws JLFClientNoInitExecption
	 */
	public void reStartServer() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s重启开始。。。", serverName));
		try {
			reStart();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug(String.format("%s重启失败。。。", serverName));
			throw e;
		}

		LogUtil.get().debug(String.format("%s重启成功。。。", serverName));
	}

	/**
	 * 
	 * @Title: getConfig
	 * @Description:获取服务端配置,不用重新加载配置文件
	 * @return
	 */
	public Properties getConfig() {
		return getConfig(false);
	}

	/**
	 * 
	 * @Title: getConfig
	 * @Description: 获取服务端配置
	 * @param reLoadConfig
	 *            是否需要重新加载配置文件
	 * @return
	 */
	public Properties getConfig(boolean reLoadConfig) {
		Properties config = JLFConfig.getSoaConfig(getSoaName(), reLoadConfig);
		if (config == null) {
			config = new Properties();
		}
		return config;
	}
}
