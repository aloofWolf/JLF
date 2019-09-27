package org.jlf.core;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.PackageUtil;
import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.exception.JLFException;
import org.jlf.core.provide.JLFPluginProvide;
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

	private static final String PLUGIN_CLIENT_PACKAGE_NAME = "org.jlf.plugin.client";
	private static final String PLUGIN_SERVER_PACKAGE_NAME = "org.jlf.plugin.server.%s";
	private static final String PLUGIN_PROVIDE_PACKAGE_NAME = "org.jlf.plugin.provide.%s";
	private static final String PLUGIN_FIELD_NAME = "PLUGIN_NAME";
	private static final String PRODUCT_CLIENT_PACKAGE_NAME = "org.jlf.product.client";
	private static final String PRODUCT_SERVER_PACKAGE_NAME = "org.jlf.product.server.%s";
	private static final String PRODUCT_FIELD_NAME = "PRODUCT_NAME";
	private static final String SOA_SERVER_PACKAGE_NAME = "org.jlf.soa.server";

	/**
	 * 
	 * @Title: starts
	 * @Description:����JLF����
	 */
	public static void starts() {
		// �������õ�ǰ�̵߳�classLoader,���ط���˵�jar����Ҫ��classLoader����
		// Thread.currentThread().setContextClassLoader(ClassLoaderUtil.getLoader());
		startPlugins();
		startSoa();
		startProducts();
		
	}

	/**
	 * �Ѿ������Ĳ������
	 */
	private static Set<Class<?>> startedClientCls = new HashSet<Class<?>>();

	/**
	 * 
	 * @Title: startPlugins
	 * @Description:����������ȫ�����
	 */
	private static <SERVER_API extends JLFPluginServerApi> void startPlugins() {
		List<Class<?>> clientClss = PackageUtil.getPackageClss(PLUGIN_CLIENT_PACKAGE_NAME,
				new JLFPluginClientClsFilter());
		for (Class<?> clientCls : clientClss) {
			startPlugin(clientCls);
		}
	}

	/**
	 * 
	 * @Title: startPlugin
	 * @Description:�������,�������󶨵ķ����,�����������ͻ���,���������������ͻ��˲��
	 * @param clientCls
	 */
	@SuppressWarnings("unchecked")
	private static <SERVER_API extends JLFPluginServerApi> void startPlugin(Class<?> clientCls) {
		if (startedClientCls.contains(clientCls)) {
			return;
		}
		JLFPluginClient<SERVER_API> client;
		Class<?> apiCls;
		Field pluginField;
		String pluginName;
		String pluginServerPackageName;
		String pluginProvidePackageName;
		List<Class<?>> provideClss;
		List<Class<?>> serverClss;
		Class<?> serverCls;
		JLFPluginServer<SERVER_API> server;
		try {
			client = (JLFPluginClient<SERVER_API>) clientCls.newInstance();
			apiCls = GenericityUtil.getObjSuperInterGenerCls(clientCls);
			pluginField = apiCls.getField(PLUGIN_FIELD_NAME);
			pluginName = (String) pluginField.get(apiCls);
			pluginServerPackageName = String.format(PLUGIN_SERVER_PACKAGE_NAME, pluginName);
			serverClss = PackageUtil.getPackageClss(pluginServerPackageName, new JLFPluginServerClsFilter());
			if (serverClss.size() == 0) {
				String exceptionDesc = String.format("δ�ҵ��ͻ���%s��Ӧ�ķ����", clientCls.getSimpleName());
				throw new JLFException(exceptionDesc);
			}
			if (serverClss.size() > 2) {
				String exceptionDesc = String.format("�ͻ���%s��Ӧ�ķ����ƥ�䵽���", clientCls.getSimpleName());
				throw new JLFException(exceptionDesc);
			}
			if (serverClss.size() == 2) {
				pluginProvidePackageName = String.format(PLUGIN_PROVIDE_PACKAGE_NAME, pluginName);
				provideClss = PackageUtil.getPackageClss(pluginProvidePackageName, new JLFPluginProvideClsFilter());
				if (provideClss.size() == 0) {
					String exceptionDesc = String.format("�ͻ���%s��Ӧ�ķ����ƥ�䵽���", clientCls.getSimpleName());
					throw new JLFException(exceptionDesc);
				}
				Class<?> provideCls = provideClss.get(0);
				JLFPluginProvide<SERVER_API> provide = (JLFPluginProvide<SERVER_API>) provideCls.newInstance();
				Class<? extends JLFPluginServer<SERVER_API>> defaultServerCls = provide.getDefaultServer();
				if (serverClss.get(0).equals(defaultServerCls)) {
					serverClss.remove(0);
				} else if (serverClss.get(1).equals(defaultServerCls)) {
					serverClss.remove(1);
				} else {
					String exceptionDesc = String.format("�ͻ���%s��Ӧ�ķ����ƥ�䵽���", clientCls.getSimpleName());
					throw new JLFException(exceptionDesc);
				}
			}
			serverCls = serverClss.get(0);
			server = (JLFPluginServer<SERVER_API>) serverCls.newInstance();
			startedClientCls.add(clientCls);

			Set<Class<JLFPluginClient<?>>> depends = server.getDepends();
			if (depends != null) {
				for (Class<JLFPluginClient<?>> dependClientCls : depends) {
					startPlugin(dependClientCls);
				}
			}
			server.startServer();
			client.bindServer(server);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: startProducts
	 * @Description:������Ʒ����
	 */
	@SuppressWarnings("unchecked")
	private static <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi> void startProducts() {
		List<Class<?>> clientClss = PackageUtil.getPackageClss(PRODUCT_CLIENT_PACKAGE_NAME,
				new JLFProductClientClsFilter());

		JLFProductClient<SERVER_API> client;
		Class<?> apiCls;
		Field productField;
		String productName;
		String productServerPackageName;
		List<Class<?>> serverClss;
		Class<?> serverCls;
		JLFProductServer<SERVER_API> server;
		for (Class<?> clientCls : clientClss) {
			try {
				client = (JLFProductClient<SERVER_API>) clientCls.newInstance();
				apiCls = GenericityUtil.getObjSuperInterGenerCls(clientCls);
				productField = apiCls.getField(PRODUCT_FIELD_NAME);
				productName = (String) productField.get(apiCls);
				productServerPackageName = String.format(PRODUCT_SERVER_PACKAGE_NAME, productName);
				serverClss = PackageUtil.getPackageClss(productServerPackageName, new JLFProductServerClsFilter());
				if (serverClss.size() == 0) {
					String exceptionDesc = String.format("δ�ҵ��ͻ���%s��Ӧ�ķ����", clientCls.getSimpleName());
					throw new JLFException(exceptionDesc);
				}
				if (serverClss.size() > 1) {
					String exceptionDesc = String.format("�ͻ���%s��Ӧ�ķ����ƥ�䵽���", clientCls.getSimpleName());
					throw new JLFException(exceptionDesc);
				}
				serverCls = serverClss.get(0);
				server = (JLFProductServer<SERVER_API>) serverCls.newInstance();
				client.bindServer(server);
				server.startServer();
			} catch (Exception e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}
	}

	/**
	 * 
	 * @Title: startSoa
	 * @Description:�����ܹ�����
	 */
	private static <SERVER extends JLFSoaServer> void startSoa() {
		List<Class<?>> soaClss = PackageUtil.getPackageClss(SOA_SERVER_PACKAGE_NAME, new JLFSoaServerClsFilter());
		for (Class<?> soaCls : soaClss) {
			try {
				JLFSoaServer soaServer = (JLFSoaServer) soaCls.newInstance();
				soaServer.startServer();
			} catch (Exception e) {
				e.printStackTrace();
				throw new JLFException(e);
			}
		}
	}

}
