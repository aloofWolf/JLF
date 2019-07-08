package org.jlf.plugin.excel.server.api;

/**
 * 
 * @ClassName: JLFExcelCell
 * @Description:ExcelRowApi
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public interface JLFExcelRow {

	/**
	 * 
	 * @Title: createCell
	 * @Description:创建JLFExcelCell
	 * @param colunmNum
	 * @return
	 */
	public JLFExcelCell createCell(int colunmNum);

	/**
	 * 
	 * @Title: createCell
	 * @Description:创建JLFExcelCell
	 * @param colunmNum
	 * @param style
	 * @return
	 */
	public JLFExcelCell createCell(Integer colunmNum, JLFExcelStyle style);

	/**
	 * 
	 * @Title: getFirstColumnIndex
	 * @Description:获取firstColumnIndex
	 * @return
	 */
	public int getFirstColumnIndex();

	/**
	 * 
	 * @Title: getLastColumnIndex
	 * @Description:获取LastColumnIndex
	 * @return
	 */
	public int getLastColumnIndex();

	/**
	 * 
	 * @Title: getCell
	 * @Description:获取JLFExcelCell
	 * @param colunmIndex
	 * @return
	 */
	public JLFExcelCell getCell(int colunmIndex);

}
