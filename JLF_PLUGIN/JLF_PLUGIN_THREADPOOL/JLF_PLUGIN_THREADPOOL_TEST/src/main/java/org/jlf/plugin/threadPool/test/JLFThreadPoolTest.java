package org.jlf.plugin.threadPool.test;

import java.util.ArrayList;
import java.util.List;

import org.jlf.common.util.LogUtil;
import org.jlf.core.JLFCore;
import org.jlf.plugin.threadPool.api.JLFThreadPoolResult;
import org.jlf.plugin.threadPool.client.JLFThreadPoolClient;

/**
 * 
 * @ClassName: JLFThreadPoolTest
 * @Description:JLFThreadPool测试
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class JLFThreadPoolTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		Long statrTime = System.currentTimeMillis();
		JLFThreadPoolTest test = new JLFThreadPoolTest();
		test.starts();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		JLFThreadPoolResult<Integer> result = JLFThreadPoolClient.get().execute(list, new ThreadPoolExecute());
		LogUtil.get().debug("successCount={}", result.getSuccessCount());
		LogUtil.get().debug("failCount={}", result.getFailCount());
		Long endTime = System.currentTimeMillis();
		LogUtil.get().debug("所花费时间"+(endTime-statrTime));
	}

}
