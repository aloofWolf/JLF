package org.jlf.plugin.excel.server.api;

/**
 * 
 * @ClassName: JLFExcelCell
 * @Description:ExcelRowApi
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public interface JLFExcelRow {

	/**
	 * 
	 * @Title: createCell
	 * @Description:����JLFExcelCell
	 * @param colunmNum
	 * @return
	 */
	public JLFExcelCell createCell(int colunmNum);

	/**
	 * 
	 * @Title: createCell
	 * @Description:����JLFExcelCell
	 * @param colunmNum
	 * @param style
	 * @return
	 */
	public JLFExcelCell createCell(Integer colunmNum, JLFExcelStyle style);

	/**
	 * 
	 * @Title: getFirstColumnIndex
	 * @Description:��ȡfirstColumnIndex
	 * @return
	 */
	public int getFirstColumnIndex();

	/**
	 * 
	 * @Title: getLastColumnIndex
	 * @Description:��ȡLastColumnIndex
	 * @return
	 */
	public int getLastColumnIndex();

	/**
	 * 
	 * @Title: getCell
	 * @Description:��ȡJLFExcelCell
	 * @param colunmIndex
	 * @return
	 */
	public JLFExcelCell getCell(int colunmIndex);

}
