package org.jlf.plugin.excel.server.api;

/**
 * 
 * @ClassName: JLFExcelWorkBook
 * @Description:ExcelWorkBookApi
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public interface JLFExcelWorkBook {

	/**
	 * 
	 * @Title: createSheet
	 * @Description:创建JLFExcelSheet
	 * @return
	 */
	public JLFExcelSheet createSheet();

	/**
	 * 
	 * @Title: createSheet
	 * @Description:创建JLFExcelSheet
	 * @param sheetName
	 * @return
	 */
	public JLFExcelSheet createSheet(String sheetName);

	/**
	 * 
	 * @Title: getSheet
	 * @Description:获取JLFExcelSheet
	 * @param sheetName
	 * @return
	 */
	public JLFExcelSheet getSheet(String sheetName);

	/**
	 * 
	 * @Title: getSheet
	 * @Description:JLFExcelSheet
	 * @param sheetIndex
	 * @return
	 */
	public JLFExcelSheet getSheet(int sheetIndex);

	/**
	 * 
	 * @Title: getStyle
	 * @Description:创建JLFExcelStyle
	 * @return
	 */
	public JLFExcelStyle createStyle();

	/**
	 * 
	 * @Title: writeToFile
	 * @Description:将JLFExcelWorkBook写入excel文件
	 */
	public void writeToFile();

}
