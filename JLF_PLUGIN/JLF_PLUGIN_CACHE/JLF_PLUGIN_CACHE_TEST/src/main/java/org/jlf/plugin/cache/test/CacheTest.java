package org.jlf.plugin.cache.test;

import org.jlf.common.util.ClassLoaderUtil;
import org.jlf.core.JLFCore;
import org.jlf.plugin.cache.client.JLFCacheClient;

/**
 * 
    * @ClassName: CacheTest
    * @Description:Cache测试
    * @author Lone Wolf
    * @date 2019年6月4日
 */
public class CacheTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		Thread.currentThread().setContextClassLoader(ClassLoaderUtil.getLoader());
		CacheTest server = new CacheTest();
		server.starts();
		JLFCacheClient.get().save("aa", "bb");
		JLFCacheClient.get().save("obj", new CacheBean());
		CacheBean bean = JLFCacheClient.get().getObj("obj", CacheBean.class);
		System.out.println(bean.toString());
		//JLFCacheClient.get().update("aa", "CC");
		//CacheBean bean = new CacheBean();
		//bean.setName("我是谁");
		//JLFCacheClient.get().update("obj", bean);
		//bean = JLFCacheClient.get().getObj("obj", CacheBean.class);
		//System.out.println(bean.toString());
		//JLFCacheClient.get().add("arr", "bb","cc","dd","ee");
		
	}
}