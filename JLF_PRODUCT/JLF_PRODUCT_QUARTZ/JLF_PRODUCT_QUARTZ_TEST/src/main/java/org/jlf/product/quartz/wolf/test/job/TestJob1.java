package org.jlf.product.quartz.wolf.test.job;

import java.util.Map;

import org.jlf.common.util.LogUtil;
import org.jlf.product.quartz.user.api.JLFJob;

public class TestJob1 implements JLFJob{

	@Override
	public void execute(Map<String, Object> params) throws Exception {
		String dbName = (String) params.get("dbName");
		LogUtil.get().debug("Test1¿ªÊ¼Ö´ÐÐ,dbName:{}",dbName);
		
	}

}
