package org.jlf.plugin.excel.server.api;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFExcel
 * @Description:ExcelApi
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public interface JLFExcel extends JLFPluginServerApi {

	public static final String PLUGIN_NAME = "excel";

	/**
	 * 
	 * @Title: createWorkBook
	 * @Description:����JLFExcelWorkBook
	 * @param xlsFilePath
	 * @param xlsFileName
	 * @return
	 */
	public JLFExcelWorkBook createWorkBook(String xlsFilePath, String xlsFileName);

	/**
	 * 
	 * @Title: getWorkBook
	 * @Description:����excel�ļ���ȡJLFExcelWorkBook
	 * @param filePathAndName
	 * @return
	 */
	public JLFExcelWorkBook getWorkBook(String filePathAndName);

}
