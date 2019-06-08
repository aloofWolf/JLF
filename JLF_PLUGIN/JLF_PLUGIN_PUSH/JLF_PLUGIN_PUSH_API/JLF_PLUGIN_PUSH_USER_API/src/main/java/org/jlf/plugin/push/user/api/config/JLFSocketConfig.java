package org.jlf.plugin.push.user.api.config;

/**
 * 
 * @ClassName: JLFSocketConfig
 * @Description:socket������Ϣ
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public abstract class JLFSocketConfig extends JLFTransferConfig {

	/**
	 * 
	 * @Title: getIp
	 * @Description:��ȡip
	 * @return
	 */
	public abstract String getIp();

	/**
	 * 
	 * @Title: getPort
	 * @Description:��ȡ�˿�
	 * @return
	 */
	public abstract Integer getPort();

	/**
	 * 
	 * @Title: getMaxConnCount
	 * @Description:��ȡ���ӳص����������,�ɱ����า��,���Ϊ0,��Ϊ������
	 * @return
	 */
	public Integer getMaxConnCount() {
		return 10;
	}
}
