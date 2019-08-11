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
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends(){
		return null;
	}

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
		Class<SERVER_API> serverApiCls = GenericityUtil.getObjSuperClsGenerCls(this.getClass());
		Field pluginField;
		try {
			pluginField = serverApiCls.getField("PLUGIN_NAME");
			String pluginName = (String) pluginField.get(serverApiCls);
			return JLFConfig.getPluginConfig(pluginName);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

}
