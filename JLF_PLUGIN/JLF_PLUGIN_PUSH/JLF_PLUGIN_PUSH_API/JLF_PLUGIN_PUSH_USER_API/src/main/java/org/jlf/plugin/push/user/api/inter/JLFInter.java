package org.jlf.plugin.push.user.api.inter;

import org.jlf.plugin.push.user.api.JLFDatagramTool;
import org.jlf.plugin.push.user.api.JLFSendTool;
import org.jlf.plugin.push.user.api.JLFSignTool;
import org.jlf.plugin.push.user.api.channel.JLFChannel;
import org.jlf.plugin.push.user.api.config.JLFTransferConfig;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: JLFInter
 * @Description:�ӿ���Ϣ
 * @author Lone Wolf
 * @date 2019��6��7��
 * @param <REQ>
 * @param <CONFIG>
 * @param <CHANNEL>
 */
public abstract class JLFInter<REQ extends JLFPushRequest, CONFIG extends JLFTransferConfig, CHANNEL extends JLFChannel<CONFIG>> {

	private CHANNEL channel; // ������Ϣ

	/**
	 * 
	 * ����һ���µ�ʵ�� JLFInter.
	 *
	 * @param channel
	 */
	public JLFInter(CHANNEL channel) {
		this.channel = channel;
	}

	/**
	 * 
	 * @Title: getReqCls
	 * @Description:��ȡ����bean��class����
	 * @return
	 */
	public abstract Class<REQ> getReqCls();

	/**
	 * 
	 * @Title: getConfig
	 * @Description:��ȡ��������,Ĭ�Ϸ�������������,���ÿ���ӿ��в�ͬ����,�������า�Ǵ˷��� �������ͬһ���ӿ�,
	 *                                                     ÿһ�������в�ͬ������,
	 *                                                     ����http��url��Ҫ����ÿһ������ľ������ƴ��
	 *                                                     �����ڴ˷����д����������req����
	 * @return
	 */
	public CONFIG getConfig(REQ req) {
		return channel.getConfig();
	}

	/**
	 * 
	 * @Title: getDatagramTool
	 * @Description:��ȡ���Ĺ���,Ĭ�Ϸ��������ı��Ĺ���,�ɱ����า��
	 * @return
	 */
	public JLFDatagramTool getDatagramTool() {
		return channel.getDatagramTool();
	}

	/**
	 * 
	 * @Title: getSignTool
	 * @Description:��ȡǩ������,Ĭ�Ϸ���������ǩ������,�ɱ����า��
	 * @return
	 */
	public JLFSignTool getSignTool() {
		return channel.getSignTool();
	}

	/**
	 * 
	 * @Title: getSendTool
	 * @Description:��ȡ���͹���,Ĭ�Ϸ���null,����˷���������null,����ô˷��͹��߷�������,�������http��socket��
	 * @return
	 */
	public JLFSendTool getSendTool() {
		return null;
	}

}
