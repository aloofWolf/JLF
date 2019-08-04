package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFPushInter;

/**
 * 
 * @ClassName: JLFPushSendTool
 * @Description:���͹���,���������ʵ�ִ˽ӿ�,����ô˽ӿڷ�������,��δʵ��,�����socket��http����
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public interface JLFPushSendTool {

	/**
	 * 
	 * @Title: send
	 * @Description:�������ݷ���
	 * @param inter
	 * @param datagram
	 * @return
	 */
	public String send(JLFPushInter<?, ?, ?> inter, String datagram);

}
