package org.jlf.soa.mvc.util;

import java.util.List;

import org.jlf.common.util.FileUtil;
import org.jlf.common.util.StringUtil;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.core.util.JLFPluginUtil;
import org.jlf.plugin.excel.server.api.JLFExcel;
import org.jlf.plugin.excel.server.api.JLFExcelCell;
import org.jlf.plugin.excel.server.api.JLFExcelRow;
import org.jlf.plugin.excel.server.api.JLFExcelSheet;
import org.jlf.plugin.excel.server.api.JLFExcelStyle;
import org.jlf.plugin.excel.server.api.JLFExcelWorkBook;
import org.jlf.plugin.excel.server.api.enums.JLFExcelAlignmentType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelBorderType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelVerticalAlignmentType;
import org.jlf.soa.mvc.metadata.export.JLFMVCFieldMetadata;
import org.jlf.soa.mvc.metadata.export.JLFMVCTableMetadata;
import org.jlf.soa.mvc.metadata.export.JLFMVCTablesMetadata;

/**
 * 
 * @ClassName: JLFDataBaseDictionaryExportUtil
 * @Description:将bean实体导出到excel数据字典工具类
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class JLFDataBaseDictionaryExportUtil extends JLFDataBaseExport {

	/**
	 * 
	 * @Title: exportDataDictionary
	 * @Description:将bean实体导出到excel数据字典,未指定excel服务端编号
	 * @param serverJarPath
	 * @param filePath
	 * @param packageName
	 */
	public static void exportDataDictionary(String serverJarPath, String filePath, String packageName) {
		exportDataDictionary(serverJarPath, "excel_apachePoi", filePath, packageName);
	}

	/**
	 * 
	 * @Title: exportDataDictionary
	 * @Description:将bean实体导出到excel数据字典,指定excel服务端编号
	 * @param serverJarPath
	 * @param excelServerCode
	 * @param filePath
	 * @param packageName
	 */
	public static void exportDataDictionary(String serverJarPath, String excelServerCode, String filePath,
			String packageName) {
		JLFPluginServer<JLFExcel> excelServer = JLFPluginUtil.getServerObjByServerCodeAndClientCode("excel",
				excelServerCode, serverJarPath);
		JLFExcel excelApi = excelServer.getServerApi();
		String dir = FileUtil.getDirByFilePath(filePath);
		String fileName = FileUtil.getFileNameByFilePath(filePath);
		JLFExcelWorkBook workBook = excelApi.createWorkBook(dir, fileName);
		JLFExcelStyle headStyle = createHeadStyle(workBook);
		JLFExcelStyle bodyStyle = createBodyStyle(workBook);
		JLFExcelSheet sheet = workBook.createSheet("mySheet");
		JLFMVCTablesMetadata tablesMetadata = genDataBaseMetadata(packageName);
		List<JLFMVCTableMetadata> metadata = tablesMetadata.getTables();
		for (JLFMVCTableMetadata tableMetadata : metadata) {
			parseTableMetadata(tableMetadata, sheet, headStyle, bodyStyle);
		}
		sheet.setColumnWidth(0, 22);
		sheet.setColumnWidth(1, 22);
		sheet.setColumnWidth(2, 15);
		sheet.setColumnWidth(3, 15);
		sheet.setColumnWidth(4, 15);
		sheet.setColumnWidth(5, 22);
		sheet.setColumnWidth(6, 15);
		sheet.setColumnWidth(7, 22);
		sheet.setColumnWidth(8, 22);
		sheet.setColumnWidth(9, 15);
		workBook.writeToFile();
	}

	/**
	 * 
	 * @Title: parseTableMetadata
	 * @Description:解析table
	 * @param tableMetadata
	 * @param sheet
	 * @param headStyle
	 * @param bodyStyle
	 */
	private static void parseTableMetadata(JLFMVCTableMetadata tableMetadata, JLFExcelSheet sheet,
			JLFExcelStyle headStyle, JLFExcelStyle bodyStyle) {

		int lastRowIndex = sheet.getLastRowIndex();
		int headRowIndex = 0;
		if (lastRowIndex != 0) {
			headRowIndex = lastRowIndex + 2;
		}
		int tableRowIndex = headRowIndex + 1;
		int titleRowIndex = headRowIndex + 2;
		JLFExcelRow headRow = sheet.createRow(headRowIndex);
		JLFExcelCell headRowCell0 = headRow.createCell(0);
		JLFExcelCell headRowCell5 = headRow.createCell(5);
		headRowCell0.setStrValue("TABLE_NAME");
		headRowCell5.setStrValue("DESC");
		sheet.MergedRegion(headRowIndex, headRowIndex, 0, 4, headStyle);
		sheet.MergedRegion(headRowIndex, headRowIndex, 5, 9, headStyle);

		JLFExcelRow tableRow = sheet.createRow(tableRowIndex);
		JLFExcelCell tableRowCell0 = tableRow.createCell(0);
		JLFExcelCell tableRowCell5 = tableRow.createCell(5);
		tableRowCell0.setStrValue(tableMetadata.getTableName());
		tableRowCell5.setStrValue(tableMetadata.getDesc());
		sheet.MergedRegion(tableRowIndex, tableRowIndex, 0, 4, headStyle);
		sheet.MergedRegion(tableRowIndex, tableRowIndex, 5, 9, headStyle);
		List<JLFMVCFieldMetadata> fieldMetadatas = tableMetadata.getFields();

		JLFExcelRow titleRow = sheet.createRow(titleRowIndex);
		JLFExcelCell titleRowCell0 = titleRow.createCell(0, headStyle);
		JLFExcelCell titleRowCell1 = titleRow.createCell(1, headStyle);
		JLFExcelCell titleRowCell2 = titleRow.createCell(2, headStyle);
		JLFExcelCell titleRowCell3 = titleRow.createCell(3, headStyle);
		JLFExcelCell titleRowCell4 = titleRow.createCell(4, headStyle);
		JLFExcelCell titleRowCell5 = titleRow.createCell(5, headStyle);
		JLFExcelCell titleRowCell6 = titleRow.createCell(6, headStyle);
		JLFExcelCell titleRowCell7 = titleRow.createCell(7, headStyle);
		JLFExcelCell titleRowCell8 = titleRow.createCell(8, headStyle);
		JLFExcelCell titleRowCell9 = titleRow.createCell(9, headStyle);
		titleRowCell0.setStrValue("FIELD_NAME");
		titleRowCell1.setStrValue("DATA_TYPE");
		titleRowCell2.setStrValue("PRIMARY");
		titleRowCell3.setStrValue("NOTNULL");
		titleRowCell4.setStrValue("UNIQUE");
		titleRowCell5.setStrValue("UNIQUE_NAME");
		titleRowCell6.setStrValue("JOIN_UNION_FIELD");
		titleRowCell7.setStrValue("CHECK");
		titleRowCell8.setStrValue("DEFAULT_VALUE");
		titleRowCell9.setStrValue("DESC");
		for (JLFMVCFieldMetadata fieldMetadata : fieldMetadatas) {
			parseFieldMetadata(fieldMetadata, sheet, bodyStyle);
		}

	}

	/**
	 * 
	 * @Title: parseFieldMetadata
	 * @Description:解析field
	 * @param fieldMetadata
	 * @param sheet
	 * @param bodyStyle
	 */
	private static void parseFieldMetadata(JLFMVCFieldMetadata fieldMetadata, JLFExcelSheet sheet,
			JLFExcelStyle bodyStyle) {

		int lastRowIndex = sheet.getLastRowIndex();
		int bodyRowIndex = lastRowIndex + 1;
		JLFExcelRow bodyRow = sheet.createRow(bodyRowIndex);
		JLFExcelCell bodyRow0 = bodyRow.createCell(0, bodyStyle);
		JLFExcelCell bodyRow1 = bodyRow.createCell(1, bodyStyle);
		JLFExcelCell bodyRow2 = bodyRow.createCell(2, bodyStyle);
		JLFExcelCell bodyRow3 = bodyRow.createCell(3, bodyStyle);
		JLFExcelCell bodyRow4 = bodyRow.createCell(4, bodyStyle);
		JLFExcelCell bodyRow5 = bodyRow.createCell(5, bodyStyle);
		JLFExcelCell bodyRow6 = bodyRow.createCell(6, bodyStyle);
		JLFExcelCell bodyRow7 = bodyRow.createCell(7, bodyStyle);
		JLFExcelCell bodyRow8 = bodyRow.createCell(8, bodyStyle);
		JLFExcelCell bodyRow9 = bodyRow.createCell(9, bodyStyle);
		bodyRow0.setStrValue(fieldMetadata.getFieldName());
		bodyRow1.setStrValue(fieldMetadata.getDataType());
		bodyRow2.setStrValue(fieldMetadata.isPrimary() == true ? "Y" : "");
		bodyRow3.setStrValue(fieldMetadata.isNotNull() == true ? "Y" : "");
		bodyRow4.setStrValue(fieldMetadata.isUnique() == true ? "Y" : "");
		bodyRow5.setStrValue(fieldMetadata.getUniqueName());
		bodyRow6.setStrValue(StringUtil.arrToStr(fieldMetadata.getJoinUniqueField()));
		bodyRow7.setStrValue(fieldMetadata.getCheckStr());
		bodyRow8.setStrValue(fieldMetadata.getDefaultValue());
		bodyRow9.setStrValue(fieldMetadata.getDesc());
	}

	/**
	 * 
	 * @Title: createHeadStyle
	 * @Description:创建headStyle
	 * @param workBook
	 * @return
	 */
	private static JLFExcelStyle createHeadStyle(JLFExcelWorkBook workBook) {
		JLFExcelStyle headStyle = workBook.createStyle();
		headStyle.setFontSize((short) 11);
		headStyle.setBold(true);
		headStyle.setFontColor((short) 0x8);
		headStyle.setFackGroundColor((short) 23);
		headStyle.setFontName("宋体");
		headStyle.setAlignmentType(JLFExcelAlignmentType.CENTER);
		headStyle.setVerticalAlignmentType(JLFExcelVerticalAlignmentType.CENTER);
		headStyle.setBorderBottom(JLFExcelBorderType.THIN);
		headStyle.setBorderTop(JLFExcelBorderType.THIN);
		headStyle.setBorderLeft(JLFExcelBorderType.THIN);
		headStyle.setBorderRight(JLFExcelBorderType.THIN);
		return headStyle;
	}

	/**
	 * 
	 * @Title: createBodyStyle
	 * @Description:创建bodyStyle
	 * @param workBook
	 * @return
	 */
	private static JLFExcelStyle createBodyStyle(JLFExcelWorkBook workBook) {
		JLFExcelStyle bodyStyle = workBook.createStyle();
		bodyStyle.setFontSize((short) 11);
		bodyStyle.setFontColor((short) 0x8);
		bodyStyle.setFontName("宋体");
		bodyStyle.setAlignmentType(JLFExcelAlignmentType.CENTER);
		bodyStyle.setVerticalAlignmentType(JLFExcelVerticalAlignmentType.CENTER);
		bodyStyle.setBorderBottom(JLFExcelBorderType.THIN);
		bodyStyle.setBorderTop(JLFExcelBorderType.THIN);
		bodyStyle.setBorderLeft(JLFExcelBorderType.THIN);
		bodyStyle.setBorderRight(JLFExcelBorderType.THIN);
		return bodyStyle;
	}
}
