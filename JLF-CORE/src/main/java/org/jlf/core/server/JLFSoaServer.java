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
		LogUtil.get().debug(String.format("%s������ʼ������", serverName));
		try {
			initConfig();
			doOther();
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
	 * @Description:��ȡ���������
	 * @return
	 */
	public Properties getConfig() {
		return JLFConfig.getSoaConfig(getSoaName());
	}
}
