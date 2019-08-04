package org.jlf.plugin.server.core.excel.apachPoi;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.excel.server.api.JLFExcelRow;
import org.jlf.plugin.excel.server.api.JLFExcelSheet;
import org.jlf.plugin.excel.server.api.JLFExcelStyle;

/**
 * 
 * @ClassName: ExcelSheet
 * @Description:JLFExcelSheet实现
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public class ExcelSheet implements JLFExcelSheet {

	private HSSFSheet sheet;
	private ExcelWorkBook workbook;

	protected ExcelSheet(HSSFSheet sheet, ExcelWorkBook workbook) {
		this.sheet = sheet;
		this.workbook = workbook;
	}

	@Override
	public JLFExcelRow createRow(int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		return new ExcelRow(row);
	}

	@Override
	public JLFExcelRow createRow(int rowNum, int rowHigeht) {
		HSSFRow row = sheet.createRow(rowNum);
		row.setHeight((short) rowHigeht);
		return new ExcelRow(row);
	}

	@Override
	public JLFExcelRow createRow(int rowNum, JLFExcelStyle style) {
		HSSFRow row = sheet.createRow(rowNum);
		ExcelStyle excelStyle = (ExcelStyle) style;
		row.setRowStyle(excelStyle.getCellStyle());
		return new ExcelRow(row);
	}

	@Override
	public JLFExcelRow createRow(int rowNum, int rowHigeht, JLFExcelStyle style) {
		HSSFRow row = sheet.createRow(rowNum);
		ExcelStyle excelStyle = (ExcelStyle) style;
		row.setHeight((short) rowHigeht);
		row.setRowStyle(excelStyle.getCellStyle());
		return new ExcelRow(row);
	}

	@Override
	public void MergedRegion(int firstRow, int lastRow, int firstCol, int lastCol) {
		CellRangeAddress region = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
		sheet.addMergedRegion(region);
	}

	@Override
	public void MergedRegion(int firstRow, int lastRow, int firstCol, int lastCol, JLFExcelStyle style) {
		CellRangeAddress region = new CellRangeAddress(firstRow, lastRow, firstCol, lastCol);
		sheet.addMergedRegion(region);
		ExcelStyle excelStyle = (ExcelStyle) style;
		int rowStartNum = region.getFirstRow();
		int rowEndNum = region.getLastRow();
		int columnStartNum = region.getFirstColumn();
		int columnEndNum = region.getLastColumn();
		for (int i = rowStartNum; i <= rowEndNum; i++) {
			HSSFRow row = HSSFCellUtil.getRow(i, sheet);
			for (int j = columnStartNum; j <= columnEndNum; j++) {
				HSSFCell cell = HSSFCellUtil.getCell(row, (short) j);
				cell.setCellStyle(excelStyle.getCellStyle());
			}
		}
	}

	@Override
	public int getFirstRowIndex() {
		return sheet.getFirstRowNum();
	}

	@Override
	public int getLastRowIndex() {
		return sheet.getLastRowNum();
	}

	@Override
	public JLFExcelRow getRow(int rowIndex) {
		HSSFRow row = sheet.getRow(rowIndex);
		return new ExcelRow(row);
	}

	@Override
	public void setColumnWidth(int columnIndex, int width) {
		sheet.setColumnWidth(columnIndex, width * 256);
	}

	@Override
	public void autoSizeColumn(int columnIndex) {
		sheet.autoSizeColumn(columnIndex);
	}

	@Override
	public void setColumnStyle(int columnIndex, JLFExcelStyle style) {
		ExcelStyle excelStyle = (ExcelStyle) style;
		sheet.setDefaultColumnStyle(columnIndex, excelStyle.getCellStyle());
	}

	@Override
	public void setBackGroundImg(String imgPath, String imgType, int dx1, int dy1, int dx2, int dy2, int col1, int row1,
			int col2, int row2) {
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		HSSFClientAnchor anchor = new HSSFClientAnchor(dx1, dy1, dx2, dy2, (short) col1, row1, (short) col2, row2);
		BufferedImage bufferImg;
		try {
			bufferImg = ImageIO.read(new File(imgPath));
			ImageIO.write(bufferImg, imgType, byteArrayOut);
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		patriarch.createPicture(anchor,
				sheet.getWorkbook().addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
	}

	protected ExcelWorkBook getWorkbook() {
		return workbook;
	}

}
