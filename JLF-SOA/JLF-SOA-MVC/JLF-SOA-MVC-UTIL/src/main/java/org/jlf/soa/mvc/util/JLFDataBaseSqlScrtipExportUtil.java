package org.jlf.soa.mvc.util;

import org.jlf.common.util.FileUtil;
import org.jlf.plugin.template.server.api.JLFTemplate;
import org.jlf.soa.mvc.metadata.export.JLFMVCTablesMetadata;

/**
 * 
 * @ClassName: JLFDataBaseSqlExportUtil
 * @Description:将bean实体导出到sql脚本工具类
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class JLFDataBaseSqlScrtipExportUtil extends JLFDataBaseExport {

	/**
	 * 
	 * @Title: exportDataDictionary
	 * @Description:将bean实体导出到sql脚本
	 * @param templateApi
	 * @param filePath
	 * @param packageName
	 */
	public static void exportDataDictionary(JLFTemplate templateApi, String filePath, String packageName) {
		JLFMVCTablesMetadata metadatas = genDataBaseMetadata(packageName);
		String sqlScript = templateApi.getStringFromClassPath("sql.vm", metadatas, "obj");
		sqlScript = sqlScript.replaceAll(",\r\n  \\)", "\r\n  )");
		sqlScript = sqlScript.replaceAll(", uniqueEnd", "");
		
		FileUtil.strWriteToFile(sqlScript, filePath);
	}

}
