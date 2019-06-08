package org.jlf.core.server;

import java.util.Set;

import org.jlf.common.exception.JLFException;
import org.jlf.core.api.JLFIPlugin;
import org.jlf.core.client.JLFPluginClient;

/**
 * 
 * @ClassName: JLFPluginServer
 * @Description:JLF��������
 * @author Lone Wolf
 * @date 2019��5��28��
 * @param <T>
 */
public abstract class JLFPluginServer<API extends JLFIPlugin> {

	/**
	 * 
	 * @Title: getApi
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public abstract API get();

	/**
	 * 
	 * @Title: getDepends
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
	 * @Title: stop
	 * @Description:ֹͣ�������
	 */
	public abstract void jStop() throws Exception;

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
	 * @Title: stop
	 * @Description:ֹͣ�������
	 */
	public void stop() throws Exception {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%sֹͣ��ʼ������", serverName));
		try {
			jStop();
		} catch (Exception e) {
			System.out.println(String.format("%sֹͣʧ�ܡ�����", serverName));
			throw new JLFException(e);
		}

		System.out.println(String.format("%sֹͣ�ɹ�������", serverName));
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
