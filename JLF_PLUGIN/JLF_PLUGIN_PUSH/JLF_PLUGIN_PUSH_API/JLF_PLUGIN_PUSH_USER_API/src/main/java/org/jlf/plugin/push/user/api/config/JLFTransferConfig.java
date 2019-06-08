package org.jlf.plugin.push.user.api.config;

/**
 * 
 * @ClassName: JLFTransferConfig
 * @Description:�����������
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public class JLFTransferConfig {

	private final String charset = "UTF-8"; // Ĭ�ϱ���

	private final Integer connTimeOut = 8000; // Ĭ�����ӳ�ʱʱ��

	private final Integer readConnTimeOut = 80000000; // Ĭ�϶�ȡ��ʱʱ��

	/**
	 * 
	 * @Title: getCharset
	 * @Description:��ȡ����,�ɱ����า��
	 * @return
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * 
	 * @Title: getConntimeout
	 * @Description:��ȡ���ӳ�ʱʱ��,�ɱ����า��
	 * @return
	 */
	public Integer getConntimeout() {
		return connTimeOut;
	}

	/**
	 * 
	 * @Title: getReadconntimeout
	 * @Description:��ȡ��ȡ��ʱʱ��,�ɱ����า��
	 * @return
	 */
	public Integer getReadconntimeout() {
		return readConnTimeOut;
	}

}
