package org.jlf.core;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.ClassLoaderUtil;
import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFClientNoInitExecption;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.core.server.JLFProductServer;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.core.util.JLFPluginUtil;
import org.jlf.core.util.JLFProductUtil;
import org.jlf.core.util.JLFSoaUtil;

/**
 * 
 * @ClassName: JLFCore
 * @Description:JLF框架核心类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public abstract class JLFCore {

	/**
	 * 
	 * @Title: afterStartPlugins
	 * @Description:启动插件后的操作,默认为空，可被子类重写
	 */
	public void afterStartPlugins() {

	}

	public Map<Class<?>, String> pluginsClient = new HashMap<Class<?>, String>();

	/**
	 * 
	 * @Title: starts
	 * @Description:启动JLF服务
	 */
	public void starts() {
		// 首先设置当前线程的classLoader,加载服务端的jar包需要此classLoader加载
		Thread.currentThread().setContextClassLoader(ClassLoaderUtil.getLoader());
		startPlugins();
		afterStartPlugins();
		startProducts();
		startSoa();
	}

	/**
	 * 
	 * @param <T>
	 * @Title: startPlugins
	 * @Description:启动插件服务 需要经过三次遍历,第一次遍历,封装出客户端cls与客户端编号对应的map,
	 *                     以后在后续中判断服务端依赖的客户端插件是否已配置 第二次遍历由第一次生成的map,并启动服务端,
	 *                     在启动中报JLFClientNoInitExecption异常的,说明该服务端依赖了其它插件客户端,
	 *                     但是其它插件客户端尚未启动,，此时将该服务端与对应的客户端封装到map,以便后续重试启动
	 *                     第三次,遍历第二步启动失败时封装的map,进行重试启动
	 */
	@SuppressWarnings("unchecked")
	private <SERVER_API extends JLFPluginServerApi> void startPlugins() {
		Properties props = JLFConfig.getJLFConfig().getSection("plugins");
		Map<JLFPluginClient<SERVER_API>, JLFPluginServer<SERVER_API>> startFailPlugins = new HashMap<JLFPluginClient<SERVER_API>, JLFPluginServer<SERVER_API>>();
		if (props == null || props.size() == 0) {
			throw new JLFException("plugins未配置");
		}

		for (Enumeration<Object> keys = props.keys(); keys.hasMoreElements();) {
			String clientCode = (String) keys.nextElement();
			Class<?> clientCls = JLFPluginUtil.getClientClsByClientCode(clientCode);
			pluginsClient.put(clientCls, clientCode);
		}
		for (Map.Entry<Class<?>, String> entry : pluginsClient.entrySet()) {
			Class<?> clientCls = entry.getKey();
			String clientCode = entry.getValue();
			JLFPluginClient<SERVER_API> client;
			try {
				client = (JLFPluginClient<SERVER_API>) clientCls.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
			String serverCode = props.getProperty(clientCode);
			JLFPluginServer<SERVER_API> server = JLFPluginUtil.getServerObjByServerCodeAndClientCode(clientCode,
					serverCode);
			Set<Class<JLFPluginClient<SERVER_API>>> depends = server.getDepends();
			if (depends != null) {
				for (Class<? extends JLFPluginClient<?>> dependCls : depends) {
					if (!pluginsClient.containsKey(dependCls)) {
						throw new JLFException(
								String.format("%s依赖的客户端%s未配置", server.getClass().getName(), dependCls.getName()));
					}
				}
			}
			try {
				client.bindServer(server);
				server.start();
			} catch (JLFClientNoInitExecption e) {
				e.printStackTrace();
				startFailPlugins.put(client, server);
				continue;
			}
		}
		// 对启动时抛出JLFClientNoInitExecption的,进行重试
		for (Map.Entry<JLFPluginClient<SERVER_API>, JLFPluginServer<SERVER_API>> entry : startFailPlugins.entrySet()) {
			JLFPluginClient<SERVER_API> client = entry.getKey();
			JLFPluginServer<SERVER_API> server = entry.getValue();
			client.bindServer(server);
			server.start();
		}
	}

	/**
	 * 
	 * @Title: startProducts
	 * @Description:启动产品服务
	 */
	private <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi> void startProducts() {
		Properties props = JLFConfig.getJLFConfig().getSection("products");
		if (props != null) {
			for (Enumeration<Object> keys = props.keys(); keys.hasMoreElements();) {
				String clientCode = (String) keys.nextElement();
				String serverCode = props.getProperty(clientCode);
				JLFProductClient<SERVER_API, WEB_API> client = JLFProductUtil.getClientObjByClientCode(clientCode);
				JLFProductServer<SERVER_API, WEB_API> server = JLFProductUtil
						.getServerObjByServerCodeAndClientCode(clientCode, serverCode);
				Set<Class<JLFPluginClient<?>>> depends = server.getDepends();
				if (depends != null) {
					for (Class<? extends JLFPluginClient<?>> dependCls : depends) {
						if (!pluginsClient.containsKey(dependCls)) {
							throw new JLFException(
									String.format("%s依赖的客户端%s未配置", server.getClass().getName(), dependCls.getName()));
						}
					}
				}
				client.bindServer(server);
				server.start();
			}
		}
	}

	/**
	 * 
	 * @Title: startSoa
	 * @Description:启动架构服务
	 */
	private <SERVER extends JLFSoaServer> void startSoa() {
		String soas = JLFConfig.getJLFConfig().getValue("soas");
		if (soas != null) {
			String[] soaArr = soas.split(",");
			for (String serverCode : soaArr) {
				JLFSoaServer server = JLFSoaUtil.getServerObjByServerCode(serverCode);
				Set<Class<JLFPluginClient<?>>> depends = server.getDepends();
				if (depends != null) {
					for (Class<? extends JLFPluginClient<?>> dependCls : depends) {
						if (!pluginsClient.containsKey(dependCls)) {
							throw new JLFException(
									String.format("%s依赖的客户端%s未配置", server.getClass().getName(), dependCls.getName()));
						}
					}
				}
				server.start();
			}
		}
	}

}
