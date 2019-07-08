package org.jlf.plugin.threadPool.api;

import java.util.List;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolExecute;

/**
 * 
 * @ClassName: JLFThreadPool
 * @Description:�̳߳�API
 * @author Lone Wolf
 * @date 2019��5��28��
 */
public interface JLFThreadPool extends JLFPluginServerApi {

	/**
	 * 
	 * @Title: execute
	 * @Description:�̳߳�ִ��
	 * @param beans
	 * @param config
	 * @return
	 */
	public <T extends Object> JLFThreadPoolResult<T> execute(List<T> beans, JLFThreadPoolExecute execute);

}
