package org.jlf.plugin.push.user.api;

import org.jlf.plugin.push.user.api.inter.JLFInter;

/**
 * 
 * @ClassName: JLFSendTool
 * @Description:���͹���,���������ʵ�ִ˽ӿ�,����ô˽ӿڷ�������,��δʵ��,�����socket��http����
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public interface JLFSendTool {

	/**
	 * 
	 * @Title: send
	 * @Description:�������ݷ���
	 * @param inter
	 * @param datagram
	 * @return
	 */
	public String send(JLFInter<?, ?, ?> inter, String datagram);

}
