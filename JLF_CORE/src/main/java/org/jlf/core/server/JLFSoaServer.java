package org.jlf.core.server;

import java.util.Set;

import org.jlf.core.client.JLFPluginClient;

/**
 * 
 * @ClassName: JLFSoaServer
 * @Description:JLF�ܹ������
 * @author Lone Wolf
 * @date 2019��6��2��
 */
public abstract class JLFSoaServer {

	/**
	 * 
	 * @Title: getClients
	 * @Description:��ȡ����������Ŀͻ��˲��
	 * @return
	 */
	public abstract <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends();

	/**
	 * 
	 * @Title: initConfig
	 * @Description:��ʼ������
	 */
	public void initConfig() {
	}

	/**
	 * 
	 * @Title: doOther
	 * @Description:�������ʱ,����ʼ�������������������
	 */
	public void doOther() {
	}

	/**
	 * 
	 * @Title: start
	 * @Description:�����ܹ�����
	 */
	public void start() {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%s������ʼ������", serverName));
		try {
			initConfig();
			doOther();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(String.format("%s����ʧ�ܡ�����", serverName));
			throw e;
		}
		System.out.println(String.format("%s�����ɹ�������", serverName));
	}
}
