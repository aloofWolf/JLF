package org.jlf.soa.mvc.util;

import org.jlf.common.util.FileUtil;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.core.util.JLFPluginUtil;
import org.jlf.plugin.template.server.api.JLFTemplate;
import org.jlf.soa.mvc.metadata.export.JLFMVCTablesMetadata;

/**
 * 
 * @ClassName: JLFDataBaseSqlExportUtil
 * @Description:��beanʵ�嵼����sql�ű�������
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class JLFDataBaseSqlScrtipExportUtil extends JLFDataBaseExport {

	/**
	 * 
	 * @Title: exportDataDictionary
	 * @Description:��beanʵ�嵼����sql�ű�,δָ��template����˱��
	 * @param serverJarPath
	 * @param filePath
	 * @param packageName
	 * @throws Exception
	 */
	public static void exportDataDictionary(String configPath, String filePath, String packageName) throws Exception {
		exportDataDictionary(configPath, "template_velocity", filePath, packageName);
	}

	/**
	 * 
	 * @Title: exportDataDictionary
	 * @Description:��beanʵ�嵼����sql�ű�,ָ��template����˱��
	 * @param serverJarPath
	 * @param templateServerCode
	 * @param filePath
	 * @param packageName
	 */
	public static void exportDataDictionary(String serverJarPath, String templateServerCode, String filePath,
			String packageName) {
		JLFPluginServer<JLFTemplate> templateServer = JLFPluginUtil.getServerObjByServerCodeAndClientCode("template",
				templateServerCode, serverJarPath);
		JLFTemplate templateApi = templateServer.getServerApi();
		JLFMVCTablesMetadata metadatas = genDataBaseMetadata(packageName);
		String sqlScript = templateApi.getStringFromClassPath("sql.vm", metadatas, "obj");
		sqlScript = sqlScript.replaceAll(",\r\n  \\)", "\r\n  )");
		FileUtil.strWriteToFile(sqlScript, filePath);
	}

}
