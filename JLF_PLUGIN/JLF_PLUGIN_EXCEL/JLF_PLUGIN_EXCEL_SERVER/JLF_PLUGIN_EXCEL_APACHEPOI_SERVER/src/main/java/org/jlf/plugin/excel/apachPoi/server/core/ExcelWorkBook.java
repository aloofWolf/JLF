package org.jlf.plugin.excel.apachPoi.server.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jlf.common.exception.JLFException;
import org.jlf.common.util.FileUtil;
import org.jlf.common.util.OSUtil;
import org.jlf.plugin.excel.server.api.JLFExcelSheet;
import org.jlf.plugin.excel.server.api.JLFExcelStyle;
import org.jlf.plugin.excel.server.api.JLFExcelWorkBook;

/**
 * 
 * @ClassName: ExcelWorkBook
 * @Description:JLFExcelWorkBook实现
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public class ExcelWorkBook implements JLFExcelWorkBook {

	private HSSFWorkbook workbook;
	private String xlsFilePath;
	private String xlsFileName;

	protected ExcelWorkBook(String xlsFilePath, String xlsFileName) {
		if (xlsFilePath == null) {
			throw new JLFException("文件路径不能为空");
		}
		if (xlsFileName == null) {
			throw new JLFException("文件名不能为空");
		}
		if (!xlsFileName.endsWith(".xls") && !xlsFileName.endsWith(".xlsx")) {
			throw new JLFException("文件格式不正确,必须以.xls或。xlsx结尾");
		}
		FileUtil.createDir(xlsFilePath);// 创建文件夹
		this.xlsFilePath = xlsFilePath;
		this.xlsFileName = xlsFileName;
		this.workbook = new HSSFWorkbook();
	}

	protected ExcelWorkBook(String filePathAndName) {
		if (filePathAndName == null) {
			throw new JLFException("文件名不能为空");
		}
		if (!filePathAndName.endsWith(".xls") && !filePathAndName.endsWith(".xlsx")) {
			throw new JLFException("文件格式不正确,必须以.xls或。xlsx结尾");
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePathAndName);
			this.workbook = new HSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

	@Override
	public JLFExcelSheet createSheet() {
		HSSFSheet sheet = workbook.createSheet();
		return new ExcelSheet(sheet, this);
	}

	@Override
	public JLFExcelSheet createSheet(String sheetName) {
		HSSFSheet sheet = workbook.createSheet(sheetName);
		return new ExcelSheet(sheet, this);
	}

	@Override
	public JLFExcelSheet getSheet(String sheetName) {
		HSSFSheet sheet = workbook.getSheet(sheetName);
		return new ExcelSheet(sheet, this);
	}

	@Override
	public JLFExcelSheet getSheet(int sheetIndex) {
		HSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		return new ExcelSheet(sheet, this);
	}

	@Override
	public JLFExcelStyle createStyle() {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		return new ExcelStyle(cellStyle, font, workbook);
	}

	@Override
	public void writeToFile() {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(this.xlsFilePath + OSUtil.getPathSeparator() + this.xlsFileName);
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
