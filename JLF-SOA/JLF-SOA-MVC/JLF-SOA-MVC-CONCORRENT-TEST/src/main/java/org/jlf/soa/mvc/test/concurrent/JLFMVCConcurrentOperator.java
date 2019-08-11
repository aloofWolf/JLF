package org.jlf.soa.mvc.test.concurrent;

import java.util.HashMap;
import java.util.Map;

import org.jlf.common.util.concurrent.ConcurrentOperator;
import org.jlf.core.JLFCore;
import org.jlf.plugin.client.push.JLFPushClient;

/**
 * 
 * @ClassName: JLFMVCConcurrentOperator
 * @Description:测试MVC框架并发操作
 * @author Lone Wolf
 * @date 2019年8月11日
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
