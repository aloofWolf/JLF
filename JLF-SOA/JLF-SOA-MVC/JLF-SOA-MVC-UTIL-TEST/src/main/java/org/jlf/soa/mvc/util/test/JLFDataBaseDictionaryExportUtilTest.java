package org.jlf.soa.mvc.util.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.server.core.excel.apachPoi.ExcelCore;
import org.jlf.soa.mvc.util.JLFDataBaseDictionaryExportUtil;

/**
 * 
 * @ClassName: JLFDataBaseDictionaryExportUtilTest
 * @Description:JLFDataBaseDictionaryExport����
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class JLFDataBaseDictionaryExportUtilTest extends JLFCore {

	/**
	 * 
	 * @Title: main
	 * @Description:���������ֵ����
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		JLFDataBaseDictionaryExportUtil.exportDataDictionary(new ExcelCore(), "J:/test/data.xls",
				"org.jlf.product.quartz.wolf.server.metadata.bean");
	}

}
