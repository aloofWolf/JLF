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
	 * @Description:初始化配置
	 */
	public void initConfig() {
	}

	/**
	 * 
	 * @Title: doOther
	 * @Description:启动插件时,除初始化配置以外的其它处理
	 */
	public void doOther() {
	}

	/**
	 * 
	 * @Title: start
	 * @Description:启动架构服务
	 */
	public void start() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s启动开始。。。", serverName));
		try {
			initConfig();
			doOther();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug(String.format("%s启动失败。。。", serverName));
			throw e;
		}
		LogUtil.get().debug(String.format("%s启动成功。。。", serverName));
	}
	
	/**
	 * 
	 * @Title: getConfig
	 * @Description:获取服务端配置
	 * @return
	 */
	public Properties getConfig() {
		return JLFConfig.getSoaConfig(getSoaName());
	}
}
