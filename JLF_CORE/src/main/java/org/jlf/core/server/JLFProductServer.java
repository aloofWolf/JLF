package org.jlf.core.server;

import java.util.Set;

import org.jlf.common.exception.JLFException;
import org.jlf.core.api.JLFIProduct;
import org.jlf.core.client.JLFPluginClient;

/**
 * 
 * @ClassName: JLFProductServer
 * @Description:JLF产品服务端
 * @author Lone Wolf
 * @date 2019年6月2日
 * @param <T>
 */
public abstract class JLFProductServer<API extends JLFIProduct> {

	/**
	 * 
	 * @Title: getApi
	 * @Description:获取api实例
	 * @return
	 */
	public abstract API get();

	/**
	 * 
	 * @Title: getClients
	 * @Description:获取服务端依赖的客户端插件
	 * @return
	 */
	public abstract <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends();

	/**
	 * 
	 * @Title: stop
	 * @Description:停止插件服务
	 */
	public abstract void jStart() throws Exception;

	/**
	 * 
	 * @Title: stop
	 * @Description:停止插件服务
	 */
	public abstract void jStop() throws Exception;

	/**
	 * 
	 * @Title: reSatrt
	 * @Description:重启插件服务
	 */
	public abstract void jreStart() throws Exception;

	/**
	 * 
	 * @Title: start
	 * @Description:启动插件服务
	 */
	public void start() throws Exception {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%s启动开始。。。", serverName));
		try {
			jStart();
		} catch (Exception e) {
			System.out.println(String.format("%s启动失败。。。", serverName));
			throw new JLFException(e);
		}

		System.out.println(String.format("%s启动成功。。。", serverName));
	}

	/**
	 * 
	 * @Title: stop
	 * @Description:停止插件服务
	 */
	public void stop() throws Exception {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%s停止开始。。。", serverName));
		try {
			jStop();
		} catch (Exception e) {
			System.out.println(String.format("%s停止失败。。。", serverName));
			throw new JLFException(e);
		}

		System.out.println(String.format("%s停止成功。。。", serverName));
	}

	/**
	 * 
	 * @Title: reSatrt
	 * @Description:重启插件服务
	 */
	public void reSatrt() throws Exception {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%s重启开始。。。", serverName));
		try {
			jreStart();
		} catch (Exception e) {
			System.out.println(String.format("%s重启失败。。。", serverName));
			throw new JLFException(e);
		}

		System.out.println(String.format("%s重启成功。。。", serverName));
	}

}
