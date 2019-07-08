package org.jlf.plugin.excel.server.api;

/**
 * 
 * @ClassName: JLFExcelWorkBook
 * @Description:ExcelWorkBookApi
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public interface JLFExcelWorkBook {

	/**
	 * 
	 * @Title: createSheet
	 * @Description:����JLFExcelSheet
	 * @return
	 */
	public JLFExcelSheet createSheet();

	/**
	 * 
	 * @Title: createSheet
	 * @Description:����JLFExcelSheet
	 * @param sheetName
	 * @return
	 */
	public JLFExcelSheet createSheet(String sheetName);

	/**
	 * 
	 * @Title: getSheet
	 * @Description:��ȡJLFExcelSheet
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
	 * @Description:����JLFExcelStyle
	 * @return
	 */
	public JLFExcelStyle createStyle();

	/**
	 * 
	 * @Title: writeToFile
	 * @Description:��JLFExcelWorkBookд��excel�ļ�
	 */
	public void writeToFile();

}
