package org.jlf.soa.mvc.util.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.server.core.template.velocity.VelocityCore;
import org.jlf.soa.mvc.util.JLFDataBaseSqlScrtipExportUtil;

/**
 * 
 * @ClassName: JLFDataBaseSqlExportUtilTest
 * @Description:JLFDataBaseSqlExportUtil����
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class JLFDataBaseSqlExportUtilTest extends JLFCore {

	/**
	 * 
	 * @Title: main
	 * @Description:����sql�ű�����
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		JLFDataBaseSqlScrtipExportUtil.exportDataDictionary(new VelocityCore(), "J:/test/data.sql",
				"org.jlf.product.quartz.wolf.server.metadata.bean");
	}

}
