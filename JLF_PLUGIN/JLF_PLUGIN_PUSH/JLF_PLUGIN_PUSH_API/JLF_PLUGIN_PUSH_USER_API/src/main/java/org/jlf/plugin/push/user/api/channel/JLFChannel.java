package org.jlf.plugin.push.user.api.channel;

import java.util.Properties;

import org.jlf.plugin.push.user.api.JLFDatagramTool;
import org.jlf.plugin.push.user.api.JLFSignTool;
import org.jlf.plugin.push.user.api.config.JLFTransferConfig;

/**
 * 
 * @ClassName: JLFChannel
 * @Description:�����ӿ�
 * @author Lone Wolf
 * @date 2019��6��7��
 * @param <T>
 */
public interface JLFChannel<T extends JLFTransferConfig> {

	/**
	 * 
	 * @Title: getConfig
	 * @Description:��ȡ��������
	 * @return
	 */
	public abstract T getConfig();

	/**
	 * 
	 * @Title: getDatagramTool
	 * @Description:��ȡ���Ĺ���
	 * @return
	 */
	public abstract JLFDatagramTool getDatagramTool();

	/**
	 * 
	 * @Title: getSignTool
	 * @Description:��ȡǩ������
	 * @return
	 */
	public abstract JLFSignTool getSignTool();

	/**
	 * 
	 * @Title: initConfig
	 * @Description:��ʼ������
	 * @param props
	 */
	public abstract void initConfig(Properties props);

}
