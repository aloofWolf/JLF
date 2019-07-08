package org.jlf.core.util;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.StringUtil;
import org.jlf.core.server.JLFSoaServer;

/**
 * 
 * @ClassName: JLFSoaUtil
 * @Description:soa������
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class JLFSoaUtil {

	/**
	 * 
	 * @Title: getServerClsNameByClientCode
	 * @Description:���ݷ���˱�Ż�ȡ�����������
	 * @param serverCode
	 * @return
	 */
	public static String getServerClsNameByClientCode(String serverCode) {
		if (serverCode == null || serverCode.length() == 0) {
			throw new JLFException("serverCode����Ϊ��");
		}
		return new StringBuffer("org.jlf.soa.").append(serverCode).append(".server.").append("JLF")
				.append(StringUtil.replaceFirstToUp(serverCode)).append("Server").toString();
	}

	/**
	 * 
	 * @Title: getServerClsByServerCode
	 * @Description:���ݷ���˱�Ż�ȡ�����class
	 * @param serverCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <SERVER extends JLFSoaServer> Class<SERVER> getServerClsByServerCode(String serverCode) {
		String serverClsName = getServerClsNameByClientCode(serverCode);
		try {
			return (Class<SERVER>) Class.forName(serverClsName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: getServerObjByServerCode
	 * @Description:���ݷ���˱�Ż�ȡ����˶���
	 * @param serverCode
	 * @return
	 */
	public static <SERVER extends JLFSoaServer> SERVER getServerObjByServerCode(String serverCode) {
		Class<SERVER> serverCls = getServerClsByServerCode(serverCode);
		SERVER server;
		try {
			server = serverCls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		return server;
	}

}
