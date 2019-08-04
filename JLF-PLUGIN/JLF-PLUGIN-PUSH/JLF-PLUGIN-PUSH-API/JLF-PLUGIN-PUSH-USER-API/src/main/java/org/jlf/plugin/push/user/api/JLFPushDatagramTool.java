package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: JLFPushDatagramTool
 * @Description:���Ĺ���
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public interface JLFPushDatagramTool {

	/**
	 * 
	 * @Title: createDatagram
	 * @Description:������req��װ�ɱ���
	 * @param inter
	 * @param req
	 * @return
	 */
	public String createDatagram(JLFPushInter<?, ?, ?> inter, JLFPushRequest req);

	/**
	 * 
	 * @Title: createResponseBean
	 * @Description:�����ر��ķ�װ��resp����
	 * @param inter
	 * @param respDatagram
	 * @return
	 */
	public JLFPushResponse createResponseBean(JLFPushInter<?, ?, ?> inter, String respDatagram);

}
