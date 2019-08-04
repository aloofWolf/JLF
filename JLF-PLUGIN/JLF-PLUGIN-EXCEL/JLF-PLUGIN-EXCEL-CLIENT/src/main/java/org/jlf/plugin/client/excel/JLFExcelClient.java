package org.jlf.plugin.client.excel;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.excel.server.api.JLFExcel;

/**
 * 
 * @ClassName: JLFExcelClient
 * @Description:JLFExcelClient
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public class JLFExcelClient implements JLFPluginClient<JLFExcel> {

	private static JLFExcel api; // apiʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public static JLFExcel get() {
		return api;
	}

	@Override
	public <SERVER extends JLFPluginServer<JLFExcel>> void bindServer(SERVER server) {
		api = server.getServerApi();
	}

}
