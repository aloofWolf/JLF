package org.jlf.product.quartz.test.job;

import java.util.Map;

import org.jlf.common.util.LogUtil;
import org.jlf.product.quartz.user.api.JLFQuartzJob;

public class TestJob2 implements JLFQuartzJob{

	@Override
	public void execute(Map<String, Object> params) throws Exception {
		String dbName = (String) params.get("dbName");
		LogUtil.get().debug("Test2¿ªÊ¼Ö´ÐÐ,dbName:{}",dbName);
		
	}

}
