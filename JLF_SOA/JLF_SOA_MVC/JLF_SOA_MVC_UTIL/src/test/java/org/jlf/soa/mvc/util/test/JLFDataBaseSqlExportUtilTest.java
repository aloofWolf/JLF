package org.jlf.soa.mvc.util.test;

import org.jlf.core.JLFCore;
import org.jlf.soa.mvc.util.JLFDataBaseSqlScrtipExportUtil;

/**
 * 
 * @ClassName: JLFDataBaseSqlExportUtilTest
 * @Description:JLFDataBaseSqlExportUtil测试
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class JLFDataBaseSqlExportUtilTest extends JLFCore {

	/**
	 * 
	 * @Title: main
	 * @Description:导出sql脚本测试
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		JLFDataBaseSqlExportUtilTest server = new JLFDataBaseSqlExportUtilTest();
		server.starts();
		JLFDataBaseSqlScrtipExportUtil.exportDataDictionary("", "template_velocity", "J:/test/data.sql",
				"org.jlf.product.quartz.wolf.server.metadata.bean");
	}

}
