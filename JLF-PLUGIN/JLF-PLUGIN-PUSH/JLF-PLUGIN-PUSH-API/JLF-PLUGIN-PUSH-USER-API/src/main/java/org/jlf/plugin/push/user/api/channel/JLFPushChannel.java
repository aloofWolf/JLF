package org.jlf.plugin.push.user.api.channel;

import java.util.Properties;

import org.jlf.plugin.push.user.api.JLFPushDatagramTool;
import org.jlf.plugin.push.user.api.JLFPushSignTool;
import org.jlf.plugin.push.user.api.config.JLFPushTransferConfig;

/**
 * 
 * @ClassName: JLFPushChannel
 * @Description:�����ӿ�
 * @author Lone Wolf
 * @date 2019��6��7��
 * @param <T>
 */
public interface JLFPushChannel<T extends JLFPushTransferConfig> {

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
	public abstract JLFPushDatagramTool getDatagramTool();

	/**
	 * 
	 * @Title: getSignTool
	 * @Description:��ȡǩ������
	 * @return
	 */
	public abstract JLFPushSignTool getSignTool();

	/**
	 * 
	 * @Title: initConfig
	 * @Description:��ʼ������
	 * @param props
	 */
	public abstract void initConfig(Properties props);

}
