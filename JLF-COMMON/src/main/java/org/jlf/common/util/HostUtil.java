package org.jlf.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @ClassName: HostUtil
 * @Description:host���������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class HostUtil {

	/**
	 * 
	 * @Title: getCurrHostIp
	 * @Description:��ȡ��ǰ������ip
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
