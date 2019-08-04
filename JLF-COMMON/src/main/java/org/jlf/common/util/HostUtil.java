package org.jlf.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @ClassName: HostUtil
 * @Description:host工具类测试
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public class HostUtil {

	/**
	 * 
	 * @Title: getCurrHostIp
	 * @Description:获取当前服务器ip
	 * @return
	 * @throws Exception
	 */
	public static String getCurrHostIp() {
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String hostIp = address.getHostAddress();
		address.getHostName();
		return hostIp;

	}
}
