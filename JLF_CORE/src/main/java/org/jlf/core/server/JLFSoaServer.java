package org.jlf.core.server;

import java.util.Set;

import org.jlf.core.client.JLFPluginClient;

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
	 * @Title: getClients
	 * @Description:获取服务端依赖的客户端插件
	 * @return
	 */
	public abstract <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends();

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
