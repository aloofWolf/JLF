package org.jlf.plugin.push.test.http.tool;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.client.json.JLFJsonClient;
import org.jlf.plugin.push.user.api.JLFPushDatagramTool;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;
import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: HttpDatagramTool
 * @Description:���Ĺ���
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class HttpDatagramTool implements JLFPushDatagramTool {

	@Override
	public String createDatagram(JLFPushInter<?, ?, ?> inter, JLFPushRequest req) {
		return JLFJsonClient.get().beanToJsonStr(req);
	}

	@Override
	public JLFPushResponse createResponseBean(JLFPushInter<?, ?, ?> inter, String respDatagram) {
		LogUtil.get().info("respDatagram={}", respDatagram);
		return null;
	}

}
