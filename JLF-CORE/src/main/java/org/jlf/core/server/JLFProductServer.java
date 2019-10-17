package org.jlf.core.server;

import java.lang.reflect.Field;

import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.IniContent;
import org.jlf.common.util.LogUtil;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: JLFProductServer
 * @Description:JLF产品服务端
 * @author Lone Wolf
 * @date 2019年6月2日
 * @param <SERVER_API>
 */
public abstract class JLFProductServer<SERVER_API extends JLFProductServerApi> {

	/**
	 * 
	 * @Title: getServerApi
	 * @Description:获取serverApi实例
	 * @return
	 */
	public abstract SERVER_API getServerApi();
	
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
	public IniContent getConfig() {
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
	public IniContent getConfig(boolean reLoadConfig) {
		Class<SERVER_API> serverApiCls = GenericityUtil.getObjSuperClsGenerCls(this.getClass());
		Field productField;
		try {
			productField = serverApiCls.getField("PRODUCT_NAME");
			String productName = (String) productField.get(serverApiCls);
			IniContent config = JLFConfig.getPluginConfig(productName, reLoadConfig);

			if (config == null) {
				config = new IniContent();
			}
			return config;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}
}
