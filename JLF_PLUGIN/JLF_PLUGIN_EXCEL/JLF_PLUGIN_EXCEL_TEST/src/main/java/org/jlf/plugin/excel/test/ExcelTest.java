package org.jlf.plugin.excel.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.excel.client.JLFExcelClient;
import org.jlf.plugin.excel.server.api.JLFExcelCell;
import org.jlf.plugin.excel.server.api.JLFExcelRow;
import org.jlf.plugin.excel.server.api.JLFExcelSheet;
import org.jlf.plugin.excel.server.api.JLFExcelStyle;
import org.jlf.plugin.excel.server.api.JLFExcelWorkBook;
import org.jlf.plugin.excel.server.api.enums.JLFExcelAlignmentType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelBorderType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelVerticalAlignmentType;

/**
 * 
 * @ClassName: ExcelTest
 * @Description:ExcelTest
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public class ExcelTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		ExcelTest server = new ExcelTest();
		server.starts();
		server.writeToExcel();
		server.readExcel();
	}

	/**
	 * 
	 * @Title: writeToExcel
	 * @Description:测试向excel中写数据
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private void writeToExcel() throws Exception {
		JLFExcelWorkBook workBook = JLFExcelClient.get().createWorkBook("J:/test", "data2.xls");
		JLFExcelSheet sheet = workBook.createSheet("mySheet");
		JLFExcelStyle style1 = workBook.createStyle();
		style1.setFontSize((short) 11);
		style1.setBold(true);
		style1.setFontColor((short) 0x8);
		style1.setFackGroundColor((short) 23);
		style1.setFontName("宋体");
		style1.setAlignmentType(JLFExcelAlignmentType.CENTER);
		style1.setVerticalAlignmentType(JLFExcelVerticalAlignmentType.CENTER);
		style1.setBorderBottom(JLFExcelBorderType.THIN);
		style1.setBorderTop(JLFExcelBorderType.THIN);
		style1.setBorderLeft(JLFExcelBorderType.THIN);
		style1.setBorderRight(JLFExcelBorderType.THIN);

		JLFExcelStyle style2 = workBook.createStyle();
		style2.setFontSize((short) 11);
		style2.setFontColor((short) 0x8);
		style2.setFontName("宋体");
		style2.setAlignmentType(JLFExcelAlignmentType.CENTER);
		style2.setVerticalAlignmentType(JLFExcelVerticalAlignmentType.CENTER);
		style2.setBorderBottom(JLFExcelBorderType.THIN);
		style2.setBorderTop(JLFExcelBorderType.THIN);
		style2.setBorderLeft(JLFExcelBorderType.THIN);
		style2.setBorderRight(JLFExcelBorderType.THIN);

		JLFExcelRow row1 = sheet.createRow(0);
		JLFExcelCell cell11 = row1.createCell(0);
		JLFExcelCell cell15 = row1.createCell(4);
		cell11.setStrValue("TABLE_NAME");
		cell15.setStrValue("DESC");
		sheet.MergedRegion(0, 0, 0, 3, style1);
		sheet.MergedRegion(0, 0, 4, 8, style1);

		JLFExcelRow row2 = sheet.createRow(1);
		JLFExcelCell cell21 = row2.createCell(0);
		JLFExcelCell cell25 = row2.createCell(4);
		cell21.setStrValue("pay_legal_data");
		cell25.setStrValue("付款信息合法数据表");
		sheet.MergedRegion(1, 1, 0, 3, style1);
		sheet.MergedRegion(1, 1, 4, 8, style1);

		JLFExcelRow row3 = sheet.createRow(2);
		JLFExcelCell cell31 = row3.createCell(0, style1);
		JLFExcelCell cell32 = row3.createCell(1, style1);
		JLFExcelCell cell33 = row3.createCell(2, style1);
		JLFExcelCell cell34 = row3.createCell(3, style1);
		JLFExcelCell cell35 = row3.createCell(4, style1);
		JLFExcelCell cell36 = row3.createCell(5, style1);
		JLFExcelCell cell37 = row3.createCell(6, style1);
		JLFExcelCell cell38 = row3.createCell(7, style1);
		JLFExcelCell cell39 = row3.createCell(8, style1);
		cell31.setStrValue("FIELD_NAME");
		cell32.setStrValue("DATA_TYPE");
		cell33.setStrValue("PRIMARY");
		cell34.setStrValue("NOTNULL");
		cell35.setStrValue("UNIQUE");
		cell36.setStrValue("UNIQUE_NAME");
		cell37.setStrValue("CHECK");
		cell38.setStrValue("DEFAULT_VALUE");
		cell39.setStrValue("DESC");

		JLFExcelRow row4 = sheet.createRow(3);
		JLFExcelCell cell41 = row4.createCell(0, style2);
		JLFExcelCell cell42 = row4.createCell(1, style2);
		JLFExcelCell cell43 = row4.createCell(2, style2);
		JLFExcelCell cell44 = row4.createCell(3, style2);
		JLFExcelCell cell45 = row4.createCell(4, style2);
		JLFExcelCell cell46 = row4.createCell(5, style2);
		JLFExcelCell cell47 = row4.createCell(6, style2);
		JLFExcelCell cell48 = row4.createCell(7, style2);
		JLFExcelCell cell49 = row4.createCell(8, style2);
		cell41.setStrValue("id");
		cell42.setStrValue("int(11)");
		cell43.setStrValue("Y");
		cell44.setStrValue("Y");
		cell45.setStrValue("Y");
		cell49.setStrValue("主键id");

		sheet.setColumnWidth(0, 22);
		sheet.setColumnWidth(1, 22);
		sheet.setColumnWidth(2, 22);
		sheet.setColumnWidth(3, 22);
		sheet.setColumnWidth(4, 22);
		sheet.setColumnWidth(5, 22);
		sheet.setColumnWidth(6, 22);
		sheet.setColumnWidth(7, 22);
		sheet.setColumnWidth(8, 22);
		workBook.writeToFile();
	}

	/**
	 * 
	 * @Title: readExcel
	 * @Description:测试从excel中读数据
	 * @throws Exception
	 */
	private void readExcel() throws Exception {
		JLFExcelWorkBook workBook = JLFExcelClient.get().getWorkBook("J:/test/data2.xls");
		JLFExcelSheet sheet = workBook.getSheet("mySheet");
		int firstRowIndex = sheet.getFirstRowIndex();
		int lastRowIndex = sheet.getLastRowIndex();
		for (int rowIndex = firstRowIndex; rowIndex <= lastRowIndex; rowIndex++) {
			JLFExcelRow row = sheet.getRow(rowIndex);
			int firstColumnIndex = row.getFirstColumnIndex();
			int lastColumnIndex = row.getLastColumnIndex();
			for (int columnIndex = firstColumnIndex; columnIndex < lastColumnIndex; columnIndex++) {
				JLFExcelCell cell = row.getCell(columnIndex);
				System.out.println("cell" + rowIndex + columnIndex + "=" + cell.getStrValue());
			}
		}

	}

}
