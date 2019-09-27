package org.jlf.core.server;

import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFException;

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
	 * @Title: getDepends
	 * @Description:获取服务端依赖的其它插件的客户端
	 * @return
	 */
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends() {
		return null;
	}

	/**
	 * 
	 * @Title: start
	 * @Description:启动插件服务
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
	 * @Description:启动插件服务
	 * @throws JLFClientNoInitExecption
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
		Class<SERVER_API> serverApiCls = GenericityUtil.getObjSuperClsGenerCls(this.getClass());
		Field pluginField;
		try {
			pluginField = serverApiCls.getField("PLUGIN_NAME");
			String pluginName = (String) pluginField.get(serverApiCls);
			Properties config = JLFConfig.getPluginConfig(pluginName, reLoadConfig);

			if (config == null) {
				config = new Properties();
			}
			return config;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

}
