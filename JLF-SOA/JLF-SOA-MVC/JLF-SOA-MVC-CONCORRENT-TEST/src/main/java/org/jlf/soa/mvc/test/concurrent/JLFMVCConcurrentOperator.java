package org.jlf.soa.mvc.test.concurrent;

import java.util.HashMap;
import java.util.Map;

import org.jlf.common.util.concurrent.ConcurrentOperator;
import org.jlf.core.JLFCore;
import org.jlf.plugin.client.push.JLFPushClient;

/**
 * 
 * @ClassName: JLFMVCConcurrentOperator
 * @Description:����MVC��ܲ�������
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class JLFMVCConcurrentOperator implements ConcurrentOperator {

	private static final Map<String, Object> params = new HashMap<String, Object>();
	static {
		JLFCore.starts();
		params.put("reqType", "getQuartzJob");
		params.put("id", 1);
	}

	@Override
	public void execute() {
		JLFPushClient.get().send("http", "httpInter", params);
	}

}
