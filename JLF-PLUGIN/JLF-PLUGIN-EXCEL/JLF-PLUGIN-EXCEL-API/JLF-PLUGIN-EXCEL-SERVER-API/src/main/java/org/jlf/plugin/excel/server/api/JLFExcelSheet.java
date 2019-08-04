package org.jlf.plugin.excel.server.api;

/**
 * 
 * @ClassName: JLFExcelSheet
 * @Description:ExcelSheetApi
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public interface JLFExcelSheet {

	/**
	 * 
	 * @Title: createRow
	 * @Description:����JLFExcelRow
	 * @param rowNum
	 * @return
	 */
	public JLFExcelRow createRow(int rowNum);

	/**
	 * 
	 * @Title: createRow
	 * @Description:����JLFExcelRow
	 * @param rowNum
	 * @param rowHigeht
	 * @return
	 */
	public JLFExcelRow createRow(int rowNum, int rowHigeht);

	/**
	 * 
	 * @Title: createRow
	 * @Description:����JLFExcelRow
	 * @param rowNum
	 * @param style
	 * @return
	 */
	public JLFExcelRow createRow(int rowNum, JLFExcelStyle style);

	/**
	 * 
	 * @Title: createRow
	 * @Description:����JLFExcelRow
	 * @param rowNum
	 * @param rowHigeht
	 * @param style
	 * @return
	 */
	public JLFExcelRow createRow(int rowNum, int rowHigeht, JLFExcelStyle style);

	/**
	 * 
	 * @Title: MergedRegion
	 * @Description:�ϲ���Ԫ��
	 * @param firstRow
	 * @param lastRow
	 * @param firstCol
	 * @param lastCol
	 */
	public void MergedRegion(int firstRow, int lastRow, int firstCol, int lastCol);

	/**
	 * 
	 * @Title: MergedRegion
	 * @Description:�ϲ���Ԫ��
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
	 * @Description:��ȡfirstRowIndex
	 * @return
	 */
	public int getFirstRowIndex();

	/**
	 * 
	 * @Title: getlastRowIndex
	 * @Description:��ȡLastRowIndex
	 * @return
	 */
	public int getLastRowIndex();

	/**
	 * 
	 * @Title: getRow
	 * @Description:����rowIndex��ȡJLFExcelRow
	 * @param rowIndex
	 * @return
	 */
	public JLFExcelRow getRow(int rowIndex);

	/**
	 * 
	 * @Title: setColumnWidth
	 * @Description:�����п�
	 * @param columnIndex
	 * @param width
	 */
	public void setColumnWidth(int columnIndex, int width);
	
	/**
	 * 
	 * @Title: setColumnWidth
	 * @Description:�Զ������п�
	 * @param columnIndex
	 */
	public void autoSizeColumn(int columnIndex);

	/**
	 * 
	 * @Title: setColumnStyle
	 * @Description:��������ʽ
	 * @param columnIndex
	 * @param style
	 */
	public void setColumnStyle(int columnIndex, JLFExcelStyle style);

	/**
	 * 
	 * @Title: setBackGroundImg
	 * @Description:���ñ���ͼƬ
	 * @param imgPath
	 *            ͼƬ��·��
	 * @param imgType
	 *            ͼƬ���� jpg png�ȵ�
	 * @param dx1
	 *            ��������
	 * @param dy1
	 *            ���������
	 * @param dx2
	 *            �յ������
	 * @param dy2
	 *            �յ�������
	 * @param col1
	 *            �����
	 * @param row1
	 *            �����
	 * @param col2
	 *            �յ���
	 * @param row2
	 *            �յ���
	 */
	void setBackGroundImg(String imgPath, String imgType, int dx1, int dy1, int dx2, int dy2, int col1, int row1,
			int col2, int row2);

}
