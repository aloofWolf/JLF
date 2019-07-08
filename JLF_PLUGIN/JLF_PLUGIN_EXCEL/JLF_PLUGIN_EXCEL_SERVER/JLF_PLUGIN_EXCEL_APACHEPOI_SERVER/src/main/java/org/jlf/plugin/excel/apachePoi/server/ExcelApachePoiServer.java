package org.jlf.plugin.excel.apachePoi.server;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.excel.apachPoi.server.core.ExcelCore;
import org.jlf.plugin.excel.server.api.JLFExcel;

/**
 * 
 * @ClassName: ExcelApachePoiServer
 * @Description:ExcelApachePoi服务端
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public class ExcelApachePoiServer extends JLFPluginServer<JLFExcel> {

	@Override
	public JLFExcel getServerApi() {
		return new ExcelCore();
	}

}
