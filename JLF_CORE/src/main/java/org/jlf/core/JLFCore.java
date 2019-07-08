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
 * @Description:JLF��ܺ�����
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public abstract class JLFCore {

	/**
	 * 
	 * @Title: afterStartPlugins
	 * @Description:���������Ĳ���,Ĭ��Ϊ�գ��ɱ�������д
	 */
	public void afterStartPlugins() {

	}

	public Map<Class<?>, String> pluginsClient = new HashMap<Class<?>, String>();

	/**
	 * 
	 * @Title: starts
	 * @Description:����JLF����
	 */
	public void starts() {
		// �������õ�ǰ�̵߳�classLoader,���ط���˵�jar����Ҫ��classLoader����
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
	 * @Description:����������� ��Ҫ�������α���,��һ�α���,��װ���ͻ���cls��ͻ��˱�Ŷ�Ӧ��map,
	 *                     �Ժ��ں������жϷ���������Ŀͻ��˲���Ƿ������� �ڶ��α����ɵ�һ�����ɵ�map,�����������,
	 *                     �������б�JLFClientNoInitExecption�쳣��,˵���÷������������������ͻ���,
	 *                     ������������ͻ�����δ����,����ʱ���÷�������Ӧ�Ŀͻ��˷�װ��map,�Ա������������
	 *                     ������,�����ڶ�������ʧ��ʱ��װ��map,������������
	 */
	@SuppressWarnings("unchecked")
	private <SERVER_API extends JLFPluginServerApi> void startPlugins() {
		Properties props = JLFConfig.getJLFConfig().getSection("plugins");
		Map<JLFPluginClient<SERVER_API>, JLFPluginServer<SERVER_API>> startFailPlugins = new HashMap<JLFPluginClient<SERVER_API>, JLFPluginServer<SERVER_API>>();
		if (props == null || props.size() == 0) {
			throw new JLFException("pluginsδ����");
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
								String.format("%s�����Ŀͻ���%sδ����", server.getClass().getName(), dependCls.getName()));
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
		// ������ʱ�׳�JLFClientNoInitExecption��,��������
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
	 * @Description:������Ʒ����
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
									String.format("%s�����Ŀͻ���%sδ����", server.getClass().getName(), dependCls.getName()));
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
	 * @Description:�����ܹ�����
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
									String.format("%s�����Ŀͻ���%sδ����", server.getClass().getName(), dependCls.getName()));
						}
					}
				}
				server.start();
			}
		}
	}

}
