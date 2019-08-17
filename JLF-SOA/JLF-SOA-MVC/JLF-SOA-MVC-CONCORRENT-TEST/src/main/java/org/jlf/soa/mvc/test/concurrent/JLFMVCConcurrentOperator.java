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
		
		/*params.put("reqType", "saveQuartzJob");
		params.put("templateId", 10);*/
		//params.put("cron", "*/10 * * * * ?");
		
		/*params.put("reqType", "updateQuartzJob");
		params.put("id", 1);
		params.put("version", 24);
		params.put("templateId", 100);*/
		
		/*params.put("reqType", "deleteQuartzJob");
		params.put("id", 1);
		params.put("version", 26);*/
		
		/*params.put("reqType", "transQuartzJob");
		params.put("templateId", 100);*/
		//params.put("cron", "*/30 * * * * ?");
		/*params.put("templateName", "qqqq");
		params.put("clsName", "org.jlf.ccc");*/
		
	}

	@Override
	public void execute() {
		JLFPushClient.get().send("http", "httpInter", params);
		//JLFPushClient.get().send("http", "httpSaveInter", params);
		//JLFPushClient.get().send("http", "httpUpdateInter", params);
		//JLFPushClient.get().send("http", "httpDeleteInter", params);
		//JLFPushClient.get().send("http", "httpTransInter", params);
		
	}

}
