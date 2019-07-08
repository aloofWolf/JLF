package org.jlf.plugin.excel.server.api;

/**
 * 
 * @ClassName: JLFExcelSheet
 * @Description:ExcelSheetApi
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public interface JLFExcelSheet {

	/**
	 * 
	 * @Title: createRow
	 * @Description:创建JLFExcelRow
	 * @param rowNum
	 * @return
	 */
	public JLFExcelRow createRow(int rowNum);

	/**
	 * 
	 * @Title: createRow
	 * @Description:创建JLFExcelRow
	 * @param rowNum
	 * @param rowHigeht
	 * @return
	 */
	public JLFExcelRow createRow(int rowNum, int rowHigeht);

	/**
	 * 
	 * @Title: createRow
	 * @Description:创建JLFExcelRow
	 * @param rowNum
	 * @param style
	 * @return
	 */
	public JLFExcelRow createRow(int rowNum, JLFExcelStyle style);

	/**
	 * 
	 * @Title: createRow
	 * @Description:创建JLFExcelRow
	 * @param rowNum
	 * @param rowHigeht
	 * @param style
	 * @return
	 */
	public JLFExcelRow createRow(int rowNum, int rowHigeht, JLFExcelStyle style);

	/**
	 * 
	 * @Title: MergedRegion
	 * @Description:合并单元格
	 * @param firstRow
	 * @param lastRow
	 * @param firstCol
	 * @param lastCol
	 */
	public void MergedRegion(int firstRow, int lastRow, int firstCol, int lastCol);

	/**
	 * 
	 * @Title: MergedRegion
	 * @Description:合并单元格
	 * @param firstRow
	 * @param lastRow
	 * @param firstCol
	 * @param lastCol
	 * @param style
	 */
	public void MergedRegion(int firstRow, int lastRow, int firstCol, int lastCol, JLFExcelStyle style);

	/**
	 * 
	 * @Title: getFirstRowIndex
	 * @Description:获取firstRowIndex
	 * @return
	 */
	public int getFirstRowIndex();

	/**
	 * 
	 * @Title: getlastRowIndex
	 * @Description:获取LastRowIndex
	 * @return
	 */
	public int getLastRowIndex();

	/**
	 * 
	 * @Title: getRow
	 * @Description:根据rowIndex获取JLFExcelRow
	 * @param rowIndex
	 * @return
	 */
	public JLFExcelRow getRow(int rowIndex);

	/**
	 * 
	 * @Title: setColumnWidth
	 * @Description:设置列宽
	 * @param columnIndex
	 * @param width
	 */
	public void setColumnWidth(int columnIndex, int width);
	
	/**
	 * 
	 * @Title: setColumnWidth
	 * @Description:自动调整列宽
	 * @param columnIndex
	 */
	public void autoSizeColumn(int columnIndex);

	/**
	 * 
	 * @Title: setColumnStyle
	 * @Description:设置列样式
	 * @param columnIndex
	 * @param style
	 */
	public void setColumnStyle(int columnIndex, JLFExcelStyle style);

	/**
	 * 
	 * @Title: setBackGroundImg
	 * @Description:设置背景图片
	 * @param imgPath
	 *            图片；路径
	 * @param imgType
	 *            图片类型 jpg png等等
	 * @param dx1
	 *            起点横坐标
	 * @param dy1
	 *            起点总坐标
	 * @param dx2
	 *            终点横坐标
	 * @param dy2
	 *            终点总坐标
	 * @param col1
	 *            起点列
	 * @param row1
	 *            起点行
	 * @param col2
	 *            终点列
	 * @param row2
	 *            终点行
	 */
	void setBackGroundImg(String imgPath, String imgType, int dx1, int dy1, int dx2, int dy2, int col1, int row1,
			int col2, int row2);

}
