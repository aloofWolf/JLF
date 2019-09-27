package org.jlf.product.client.quartz;

import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;
import org.jlf.product.quartz.server.api.JLFQuartz;

/**
 * 
 * @ClassName: JLFQuartzClient
 * @Description:JLFQuartzClient
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class JLFQuartzClient implements JLFProductClient<JLFQuartz> {

	private static JLFQuartz api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
	 * @return
	 */
	public static JLFQuartz get() {
		return api;
	}

	@Override
	public <SERVER extends JLFProductServer<JLFQuartz>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
