package org.jlf.core.server;

import java.util.Properties;

import org.jlf.common.util.LogUtil;
import org.jlf.core.config.JLFConfig;

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
	 * @Title: getSoaName
	 * @Description:��ȡ�ܹ�����
	 * @return
	 */
	public abstract String getSoaName();

	/**
	 * 
	 * @Title: initConfig
	 * @Description:��������
	 */
	public void start() {
	}

	/**
	 * 
	 * @Title: reStart
	 * @Description:�����������
	 */
	public void reStart() {

	}

	/**
	 * 
	 * @Title: start
	 * @Description:�����ܹ�����
	 */
	public void startServer() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s������ʼ������", serverName));
		try {
			start();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug(String.format("%s����ʧ�ܡ�����", serverName));
			throw e;
		}
		LogUtil.get().debug(String.format("%s�����ɹ�������", serverName));
	}

	/**
	 * 
	 * @Title: reStartServer
	 * @Description:�����������
	 * @throws JLFClientNoInitExecption
	 */
	public void reStartServer() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s������ʼ������", serverName));
		try {
			reStart();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug(String.format("%s����ʧ�ܡ�����", serverName));
			throw e;
		}

		LogUtil.get().debug(String.format("%s�����ɹ�������", serverName));
	}

	/**
	 * 
	 * @Title: getConfig
	 * @Description:��ȡ���������,�������¼��������ļ�
	 * @return
	 */
	public Properties getConfig() {
		return getConfig(false);
	}

	/**
	 * 
	 * @Title: getConfig
	 * @Description: ��ȡ���������
	 * @param reLoadConfig
	 *            �Ƿ���Ҫ���¼��������ļ�
	 * @return
	 */
	public Properties getConfig(boolean reLoadConfig) {
		Properties config = JLFConfig.getSoaConfig(getSoaName(), reLoadConfig);
		if (config == null) {
			config = new Properties();
		}
		return config;
	}
}
