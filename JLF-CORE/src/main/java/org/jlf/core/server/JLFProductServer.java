package org.jlf.core.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.jlf.common.util.LogUtil;
import org.jlf.common.util.SingletonUtil;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;
import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: JLFProductServer
 * @Description:JLF产品服务端
 * @author Lone Wolf
 * @date 2019年6月2日
 * @param <SERVER_API>
 * @param <WEB_API>
 */
public abstract class JLFProductServer<SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi> {

	/**
	 * 
	 * @Title: getServerApi
	 * @Description:获取serverApi实例
	 * @return
	 */
	public abstract SERVER_API getServerApi();

	/**
	 * 
	 * @Title: getWebApi
	 * @Description:获取webApi实例
	 * @return
	 */
	public abstract WEB_API getWebApi();

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

	@SuppressWarnings("unchecked")
	private <T> void initRoute() {
		WEB_API webApi = getWebApi();
		if (webApi == null) {
			throw new JLFException("webApi不能为空");
		}
		Method[] methods = webApi.getClass().getDeclaredMethods();
		for (Method method : methods) {
			Class<T> returnType = (Class<T>) method.getReturnType();
			T obj;
			try {
				obj = (T) method.invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new JLFException(e);
			}
			SingletonUtil.put(returnType, obj);
		}
	}

	/**
	 * 
	 * @param <T>
	 * @Title: start
	 * @Description:启动插件服务
	 */
	public <T> void start() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s启动开始。。。", serverName));
		try {
			initConfig();
			initRoute();
			doOther();
		} catch (Exception e) {
			LogUtil.get().debug(String.format("%s启动失败。。。", serverName));
			throw new JLFException(e);
		}

		LogUtil.get().debug(String.format("%s启动成功。。。", serverName));
	}

}
