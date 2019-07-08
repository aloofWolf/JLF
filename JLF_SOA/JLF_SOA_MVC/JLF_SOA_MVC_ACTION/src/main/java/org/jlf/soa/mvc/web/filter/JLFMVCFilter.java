package org.jlf.soa.mvc.web.filter;

import javax.servlet.Filter;

import org.jlf.plugin.dbPool.client.JLFDbPoolClient;

/**
 * 
 * @ClassName: JLFMVCFilter
 * @Description:过滤器父类
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public abstract class JLFMVCFilter implements Filter {

	/**
	 * 关闭当前线程的所有数据库连接
	 */
	@Override
	public void destroy() {
		JLFDbPoolClient.get().closeAllConn();

	}

}
