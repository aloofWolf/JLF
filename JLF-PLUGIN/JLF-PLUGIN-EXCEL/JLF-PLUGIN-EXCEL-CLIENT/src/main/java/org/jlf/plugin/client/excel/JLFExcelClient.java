package org.jlf.plugin.client.excel;

import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.excel.server.api.JLFExcel;

/**
 * 
 * @ClassName: JLFExcelClient
 * @Description:JLFExcelClient
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public class JLFExcelClient implements JLFPluginClient<JLFExcel> {

	private static JLFExcel api; // api实例

	/**
	 * 
	 * @Title: get
	 * @Description:获取api实例
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
