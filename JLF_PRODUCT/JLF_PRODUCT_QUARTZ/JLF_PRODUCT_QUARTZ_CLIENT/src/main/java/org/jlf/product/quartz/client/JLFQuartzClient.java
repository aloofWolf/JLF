package org.jlf.product.quartz.client;

import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFProductServer;
import org.jlf.product.quartz.server.api.JLFQuartz;
import org.jlf.product.quartz.web.api.JLFQuartzAcion;

/**
 * 
    * @ClassName: JLFQuartzClient
    * @Description:JLFQuartzClient
    * @author Lone Wolf
    * @date 2019��7��6��
 */
public class JLFQuartzClient implements JLFProductClient<JLFQuartz, JLFQuartzAcion> {

	private static JLFQuartz api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFQuartz get() {
		return api;
	}

	@Override
	public <SERVER extends JLFProductServer<JLFQuartz, JLFQuartzAcion>> void bindServer(SERVER server) {
		api = server.getServerApi();

	}

}
