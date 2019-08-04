package org.jlf.plugin.provide.excel;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.excel.server.api.JLFExcel;
import org.jlf.plugin.server.excel.apachePoi.ExcelApachePoiServer;

/**
 * 
 * @ClassName: ExcelProvide
 * @Description:ExcelProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class ExcelProvide implements JLFPluginProvide<JLFExcel> {

	@Override
	public Class<? extends JLFPluginServer<JLFExcel>> getDefaultServer() {
		return ExcelApachePoiServer.class;
	}

}
