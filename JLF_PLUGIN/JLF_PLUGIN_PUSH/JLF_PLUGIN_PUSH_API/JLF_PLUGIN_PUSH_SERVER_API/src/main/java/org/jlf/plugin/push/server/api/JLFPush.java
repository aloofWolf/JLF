package org.jlf.plugin.push.server.api;

import java.util.Map;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: JLFPush
 * @Description:JLFPush API
 * @author Lone Wolf
 * @date 2019��6��7��
 */
public interface JLFPush extends JLFPluginServerApi {

	/**
	 * 
	 * @Title: send
	 * @Description:��Է���������
	 * @param channelCode
	 *            �������
	 * @param interCode
	 *            �ӿڱ��
	 * @param params
	 *            ���Ͳ���
	 * @return
	 */
	public <T extends JLFPushRequest> JLFPushResponse send(String channelCode, String interCode,
			Map<String, Object> params);

}
