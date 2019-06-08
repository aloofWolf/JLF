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
 * @Description:JLF��ܺ�����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public abstract class JLFCore {

	/**
	 * 
	 * @Title: getPluginClients
	 * @Description:��ȡ����б���
	 * @return
	 * @throws Exception
	 */
	protected abstract List<JLFPluginClient<?>> getPluginClients() throws Exception;

	/**
	 * 
	 * @Title: getProductClients
	 * @Description:��ȡ��Ʒ�б���
	 * @return
	 * @throws Exception
	 */
	protected abstract List<JLFProductClient<?>> getProductClients() throws Exception;

	/**
	 * 
	 * @Title: getSoas
	 * @Description:��ȡ�ܹ��б���
	 * @return
	 */
	protected abstract <SERVER extends JLFSoaServer> List<SERVER> getSoaServers();

	/**
	 * ����ͻ��˼���
	 */
	private Set<Class<?>> pluginClients = new HashSet<Class<?>>();
	
	/**
	 * 
	    * @Title: afterStartPlugins
	    * @Description:���������Ĳ���,Ĭ��Ϊ�գ��ɱ�������д
	    * @throws Exception
	 */
	public void afterStartPlugins()throws Exception{
		
	}

	/**
	 * 
	 * @Title: starts
	 * @Description:����JLF����
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
	 * @Description:�����������
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
								String.format("%s�����Ŀͻ���%sδ����", server.getClass().getName(), dependCls.getName()));
					}
				}
			}
			server.start();
		}
	}

	/**
	 * 
	 * @Title: startProducts
	 * @Description:������Ʒ����
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
								String.format("%s�����Ŀͻ���%sδ����", server.getClass().getName(), dependCls.getName()));
					}
				}
			}
			server.start();
		}
	}

	/**
	 * 
	 * @Title: startSoa
	 * @Description:�����ܹ�����
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
								String.format("%s�����Ŀͻ���%sδ����", server.getClass().getName(), dependCls.getName()));
					}

				}
			}
			server.start();
		}
	}

}
