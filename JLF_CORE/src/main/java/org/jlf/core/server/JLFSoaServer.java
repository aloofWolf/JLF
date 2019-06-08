package org.jlf.core.server;

import java.util.Set;

import org.jlf.common.exception.JLFException;
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
	 * @Title: stop
	 * @Description:ֹͣ�������
	 */
	public abstract void jStart() throws Exception;

	/**
	 * 
	 * @Title: reSatrt
	 * @Description:�����������
	 */
	public abstract void jreStart() throws Exception;

	/**
	 * 
	 * @Title: start
	 * @Description:�����������
	 */
	public void start() throws Exception {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%s������ʼ������", serverName));
		try {
			jStart();
		} catch (Exception e) {
			System.out.println(String.format("%s����ʧ�ܡ�����", serverName));
			throw new JLFException(e);
		}

		System.out.println(String.format("%s�����ɹ�������", serverName));
	}

	/**
	 * 
	 * @Title: reSatrt
	 * @Description:�����������
	 */
	public void reSatrt() throws Exception {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%s������ʼ������", serverName));
		try {
			jreStart();
		} catch (Exception e) {
			System.out.println(String.format("%s����ʧ�ܡ�����", serverName));
			throw new JLFException(e);
		}

		System.out.println(String.format("%s�����ɹ�������", serverName));
	}
}
