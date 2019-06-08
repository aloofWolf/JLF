package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: JLFDatagramTool
 * @Description:���Ĺ���
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public interface JLFDatagramTool {

	/**
	 * 
	 * @Title: createDatagram
	 * @Description:������req��װ�ɱ���
	 * @param inter
	 * @param req
	 * @return
	 * @throws Exception 
	 */
	public String createDatagram(JLFInter<?, ?, ?> inter, JLFPushRequest req) throws Exception;

	/**
	 * 
	 * @Title: createResponseBean
	 * @Description:�����ر��ķ�װ��resp����
	 * @param inter
	 * @param respDatagram
	 * @return
	 * @throws Exception 
	 */
	public JLFPushResponse createResponseBean(JLFInter<?, ?, ?> inter, String respDatagram) throws Exception;

}
