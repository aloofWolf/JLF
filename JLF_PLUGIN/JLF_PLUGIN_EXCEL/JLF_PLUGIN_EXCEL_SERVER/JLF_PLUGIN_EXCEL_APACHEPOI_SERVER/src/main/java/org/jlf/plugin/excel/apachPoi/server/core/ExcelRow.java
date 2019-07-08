package org.jlf.plugin.excel.apachPoi.server.core;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.jlf.plugin.excel.server.api.JLFExcelCell;
import org.jlf.plugin.excel.server.api.JLFExcelRow;
import org.jlf.plugin.excel.server.api.JLFExcelStyle;

/**
 * 
 * @ClassName: ExcelRow
 * @Description:JLFExcelRow实现
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public class ExcelRow implements JLFExcelRow {

	private HSSFRow row;

	protected ExcelRow(HSSFRow row) {
		this.row = row;
	}

	@Override
	public JLFExcelCell createCell(int colunmNum) {
		HSSFCell cell = row.createCell(colunmNum);
		return new ExcelCell(cell);
	}

	@Override
	public JLFExcelCell createCell(Integer colunmNum, JLFExcelStyle style) {
		HSSFCell cell = row.createCell(colunmNum);
		ExcelStyle excelStyle = (ExcelStyle) style;
		cell.setCellStyle(excelStyle.getCellStyle());
		return new ExcelCell(cell);
	}

	@Override
	public int getFirstColumnIndex() {
		return row.getFirstCellNum();
	}

	@Override
	public int getLastColumnIndex() {
		return row.getLastCellNum();
	}

	@Override
	public JLFExcelCell getCell(int colunmIndex) {
		HSSFCell cell = row.getCell(colunmIndex);
		return new ExcelCell(cell);
	}

}
