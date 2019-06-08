package org.jlf.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jlf.common.exception.JLFException;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.core.server.JLFProductServer;
import org.jlf.core.server.JLFSoaServer;

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
	 * @Title: getPluginClients
	 * @Description:获取插件列表集合
	 * @return
	 * @throws Exception
	 */
	protected abstract List<JLFPluginClient<?>> getPluginClients() throws Exception;

	/**
	 * 
	 * @Title: getProductClients
	 * @Description:获取产品列表集合
	 * @return
	 * @throws Exception
	 */
	protected abstract List<JLFProductClient<?>> getProductClients() throws Exception;

	/**
	 * 
	 * @Title: getSoas
	 * @Description:获取架构列表集合
	 * @return
	 */
	protected abstract <SERVER extends JLFSoaServer> List<SERVER> getSoaServers();

	/**
	 * 插件客户端集合
	 */
	private Set<Class<?>> pluginClients = new HashSet<Class<?>>();
	
	/**
	 * 
	    * @Title: afterStartPlugins
	    * @Description:启动插件后的操作,默认为空，可被子类重写
	    * @throws Exception
	 */
	public void afterStartPlugins()throws Exception{
		
	}

	/**
	 * 
	 * @Title: starts
	 * @Description:启动JLF服务
	 * @throws Exception
	 */
	public void starts() throws Exception {
		startPlugins();
		afterStartPlugins();
		startSoa();
		startProducts();
	}

	/**
	 * 
	 * @Title: startPlugins
	 * @Description:启动插件服务
	 * @throws Exception
	 */
	private void startPlugins() throws Exception {
		List<JLFPluginClient<?>> pluginClients = getPluginClients();
		for (JLFPluginClient<?> pluginClient : pluginClients) {
			this.pluginClients.add(pluginClient.getClass());
		}
		for (JLFPluginClient<?> pluginClient : pluginClients) {
			JLFPluginServer<?> server = pluginClient.getServer();
			Set<Class<JLFPluginClient<?>>> depends = server.getDepends();
			if (depends != null) {
				for (Class<? extends JLFPluginClient<?>> dependCls : depends) {
					if (!this.pluginClients.contains(dependCls)) {
						throw new JLFException(
								String.format("%s依赖的客户端%s未配置", server.getClass().getName(), dependCls.getName()));
					}
				}
			}
			server.start();
		}
	}

	/**
	 * 
	 * @Title: startProducts
	 * @Description:启动产品服务
	 * @throws Exception
	 */
	private void startProducts() throws Exception {
		List<JLFProductClient<?>> productClients = getProductClients();
		if(productClients == null){
			return;
		}
		for (JLFProductClient<?> productClient : productClients) {
			JLFProductServer<?> server = productClient.getServer();
			Set<Class<JLFPluginClient<?>>> depends = server.getDepends();
			if (depends != null) {
				for (Class<? extends JLFPluginClient<?>> dependCls : depends) {
					if (!this.pluginClients.contains(dependCls)) {
						throw new JLFException(
								String.format("%s依赖的客户端%s未配置", server.getClass().getName(), dependCls.getName()));
					}
				}
			}
			server.start();
		}
	}

	/**
	 * 
	 * @Title: startSoa
	 * @Description:启动架构服务
	 * @throws Exception
	 */
	private <SERVER extends JLFSoaServer> void startSoa() throws Exception {
		List<SERVER> soas = getSoaServers();
		if (soas == null) {
			return;
		}
		for (SERVER server : soas) {
			Set<Class<JLFPluginClient<?>>> dependPlugins = server.getDepends();
			if (dependPlugins != null) {
				for (Class<? extends JLFPluginClient<?>> dependCls : dependPlugins) {
					if (!this.pluginClients.contains(dependCls)) {
						throw new JLFException(
								String.format("%s依赖的客户端%s未配置", server.getClass().getName(), dependCls.getName()));
					}

				}
			}
			server.start();
		}
	}

}
