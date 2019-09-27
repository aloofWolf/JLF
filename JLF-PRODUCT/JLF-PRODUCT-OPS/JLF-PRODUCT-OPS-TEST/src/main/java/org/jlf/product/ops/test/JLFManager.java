package org.jlf.product.ops.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.LogUtil;
import org.jlf.core.JLFCore;
import org.jlf.plugin.client.dbPool.JLFDbPoolClient;

/**
 * 
 * @ClassName: JLFManager
 * @Description:JLFManager
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class JLFManager extends JLFCore {

	
	
	//@Override
    public void afterStartPlugins(){
		LogUtil.get().debug("初始化子数据库开始。。。。。。。。。");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=1;i<=10;i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("dbName", "wolf"+i);
			map.put("driver", "com.mysql.jdbc.Driver");
			map.put("url", "jdbc:mysql://39.108.166.34:3306/wolf"+i+"?useUnicode=true&characterEncoding=utf8");
			map.put("userName", "root");
			map.put("password", "yun4xue2wen2");
			list.add(map);
		}
		JLFDbPoolClient.get().initChildDatabases(list);
		LogUtil.get().debug("初始化子数据库结束。。。。。。。。。");
	}

}
