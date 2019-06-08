package org.jlf.plugin.push.server.api;

import java.util.Map;

import org.jlf.core.api.JLFIPlugin;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: JLFPush
 * @Description:JLFPush API
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public interface JLFPush extends JLFIPlugin {

	/**
	 * 
	 * @Title: send
	 * @Description:项对方发送数据
	 * @param channelCode
	 *            渠道编号
	 * @param interCode
	 *            接口编号
	 * @param params
	 *            发送参数
	 * @return
	 * @throws Exception
	 */
	public <T extends JLFPushRequest> JLFPushResponse send(String channelCode, String interCode,
			Map<String, Object> params) throws Exception;

}
