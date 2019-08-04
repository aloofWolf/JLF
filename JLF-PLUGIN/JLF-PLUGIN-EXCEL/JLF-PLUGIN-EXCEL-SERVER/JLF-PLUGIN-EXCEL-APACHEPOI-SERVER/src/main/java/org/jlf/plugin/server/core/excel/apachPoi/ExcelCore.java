package org.jlf.plugin.server.core.excel.apachPoi;

import org.jlf.plugin.excel.server.api.JLFExcel;
import org.jlf.plugin.excel.server.api.JLFExcelWorkBook;

/**
 * 
 * @ClassName: ExcelCore
 * @Description:ExcelCore
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public class ExcelCore implements JLFExcel {

	@Override
	public JLFExcelWorkBook createWorkBook(String xlsFilePath, String xlsFileName) {
		return new ExcelWorkBook(xlsFilePath, xlsFileName);
	}

	@Override
	public JLFExcelWorkBook getWorkBook(String filePathAndName) {
		return new ExcelWorkBook(filePathAndName);
	}

}
