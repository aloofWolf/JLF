package org.jlf.core.server;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.exception.JLFClientNoInitExecption;

/**
 * 
 * @ClassName: JLFPluginServer
 * @Description:JLF插件服务端
 * @author Lone Wolf
 * @date 2019年5月28日
 * @param <SERVER_API>
 */
public abstract class JLFPluginServer<SERVER_API extends JLFPluginServerApi> {

	/**
	 * 
	 * @Title: getServerApi
	 * @Description:获取api实例
	 * @return
	 */
	public abstract SERVER_API getServerApi();

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
	 * @Description:启动插件服务
	 * @throws JLFClientNoInitExecption
	 */
	public void start() throws JLFClientNoInitExecption {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%s启动开始。。。", serverName));
		try {
			initConfig();
			doOther();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(String.format("%s启动失败。。。", serverName));
			throw e;
		}

		System.out.println(String.format("%s启动成功。。。", serverName));
	}

}
