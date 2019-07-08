package org.jlf.core.util;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.ClassLoaderUtil;
import org.jlf.common.util.StringUtil;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;

/**
 * 
 * @ClassName: JLFProductUtil
 * @Description:product工具类
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class JLFProductUtil {

	/**
	 * 
	 * @Title: getClientClsNameByClientCode
	 * @Description:根据客户端编号获取客户端类名称
	 * @param clientCode
	 * @return
	 */
	public static String getClientClsNameByClientCode(String clientCode) {
		if (clientCode == null || clientCode.length() == 0) {
			throw new JLFException("clientCode不能为空");
		}
		return new StringBuffer("org.jlf.product.").append(clientCode).append(".client").append(".JLF")
				.append(StringUtil.replaceFirstToUp(clientCode)).append("Client").toString();
	}

	/**
	 * 
	 * @Title: getClientClsByClientCode
	 * @Description:根据客户端编号获取客户端class
	 * @param clientCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi, CLIENT extends JLFProductClient<SERVER_API, WEB_API>> Class<CLIENT> getClientClsByClientCode(
			String clientCode) {
		String clientClsName = getClientClsNameByClientCode(clientCode);
		try {
			return (Class<CLIENT>) Class.forName(clientClsName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: getClientObjByClientCode
	 * @Description:根据客户端编号获取客户端对象
	 * @param clientCode
	 * @return
	 */
	public static <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi, CLIENT extends JLFProductClient<SERVER_API, WEB_API>> CLIENT getClientObjByClientCode(
			String clientCode) {
		Class<CLIENT> clientCls = getClientClsByClientCode(clientCode);
		CLIENT client;
		try {
			client = clientCls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		return client;
	}

	/**
	 * 
	 * @Title: getServerClsNameByServerCodeAndClientCode
	 * @Description:根据客户端编号和服务端编号获取服务端类名称
	 * @param clientCode
	 * @param serverCode
	 * @return
	 */
	public static String getServerClsNameByServerCodeAndClientCode(String clientCode, String serverCode) {
		if (serverCode == null || serverCode.length() == 0) {
			throw new JLFException("serverCode不能为空");
		}
		return new StringBuffer("org.jlf.product.").append(clientCode).append(".").append(serverCode)
				.append(".server.core.").append(StringUtil.replaceFirstToUp(clientCode))
				.append(StringUtil.replaceFirstToUp(serverCode)).append("Server").toString();
	}

	/**
	 * 
	 * @Title: getServerClsByServerCodeAndClientCode
	 * @Description:根据客户端编号和服务端编号获取服务端class,未指定服务端jar包路径
	 * @param clientCode
	 * @param serverCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi, SERVER extends JLFProductServer<SERVER_API, WEB_API>> Class<SERVER> getServerClsByServerCodeAndClientCode(
			String clientCode, String serverCode) {
		String serverClsName = getServerClsNameByServerCodeAndClientCode(clientCode, serverCode);
		return (Class<SERVER>) ClassLoaderUtil.getOutCls(JLFCoreUtil.getProductServerJarPath(clientCode, serverCode),
				serverClsName);
	}

	/**
	 * 
	 * @Title: getServerClsByServerCodeAndClientCode
	 * @Description:根据客户端编号和服务端编号获取服务端class,未指定服务端jar包路径
	 * @param clientCode
	 * @param serverCode
	 * @param serverJarPath
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi, SERVER extends JLFProductServer<SERVER_API, WEB_API>> Class<SERVER> getServerClsByServerCodeAndClientCode(
			String clientCode, String serverCode, String serverJarPath) {
		String serverClsName = getServerClsNameByServerCodeAndClientCode(clientCode, serverCode);
		return (Class<SERVER>) ClassLoaderUtil
				.getOutCls(JLFCoreUtil.getProductServerJarPath(clientCode, serverCode, serverJarPath), serverClsName);
	}

	/**
	 * 
	 * @Title: getServerObjByServerCodeAndClientCode
	 * @Description:根据客户端编号和服务端编号获取服务端class,未指定服务端jar包路径
	 * @param clientCode
	 * @param serverCode
	 * @return
	 */
	public static <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi, SERVER extends JLFProductServer<SERVER_API, WEB_API>> SERVER getServerObjByServerCodeAndClientCode(
			String clientCode, String serverCode) {
		Class<SERVER> serverCls = getServerClsByServerCodeAndClientCode(clientCode, serverCode);
		SERVER server;
		try {
			server = serverCls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException("clientCode不能为空");
		}
		return server;
	}

	/**
	 * 
	 * @Title: getServerObjByServerCodeAndClientCode
	 * @Description:根据客户端编号和服务端编号获取服务端class,未指定服务端jar包路径
	 * @param clientCode
	 * @param serverCode
	 * @param serverJarPath
	 * @return
	 */
	public static <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi, SERVER extends JLFProductServer<SERVER_API, WEB_API>> SERVER getServerObjByServerCodeAndClientCode(
			String clientCode, String serverCode, String serverJarPath) {
		Class<SERVER> serverCls = getServerClsByServerCodeAndClientCode(clientCode, serverCode, serverJarPath);
		SERVER server;
		try {
			server = serverCls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException("clientCode不能为空");
		}
		return server;
	}

}
