package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: JLFSignTool
 * @Description:ǩ������
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public interface JLFSignTool {

	/**
	 * 
	 * @Title: sign
	 * @Description:�Է��ͱ��Ľ���ǩ��,�õ�ǩ����ı�������
	 * @param datagram
	 * @param inter
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public String sign(String datagram, JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception;

	/**
	 * 
	 * @Title: checkSign
	 * @Description:�Է��ر��Ľ�����ǩ
	 * @param datagram
	 * @param inter
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public boolean checkSign(String datagram, JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception;

}
