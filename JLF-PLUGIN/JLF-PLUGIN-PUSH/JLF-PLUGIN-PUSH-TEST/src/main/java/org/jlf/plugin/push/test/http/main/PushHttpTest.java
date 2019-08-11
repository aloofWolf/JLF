package org.jlf.plugin.push.test.http.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.LogUtil;
import org.jlf.core.JLFCore;
import org.jlf.plugin.client.push.JLFPushClient;
import org.jlf.plugin.client.threadPool.JLFThreadPoolClient;
import org.jlf.plugin.threadPool.api.JLFThreadPoolResult;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolExecute;

/**
 * 
 * @ClassName: PushHttpTest
 * @Description:PushHttpTest
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class PushHttpTest {

	public static void main(String[] args) throws Exception {
		JLFCore.starts();
		Long statrTime = System.currentTimeMillis();
		Map<String, Object> params;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 2000; i++) {
			params = new HashMap<String, Object>();
			params.put("reqType", "getQuartzJob");
			params.put("id", 1);
			list.add(params);
		}

		JLFThreadPoolResult<Map<String, Object>> result = JLFThreadPoolClient.get().execute(list,
				new ThreadPoolExecute());
		LogUtil.get().info("successCount={}", result.getSuccessCount());
		LogUtil.get().info("failCount={}", result.getFailCount());
		Long endTime = System.currentTimeMillis();
		LogUtil.get().info("所花费时间" + (endTime - statrTime));
	}

}

class ThreadPoolExecute implements JLFThreadPoolExecute<Map<String, Object>> {

	@Override
	public void execute(Map<String, Object> params) throws Exception {
		JLFPushClient.get().send("http", "httpInter", params);

	}

	@Override
	public int getThreadPoolNum() {
		return 2000;
	}
}
