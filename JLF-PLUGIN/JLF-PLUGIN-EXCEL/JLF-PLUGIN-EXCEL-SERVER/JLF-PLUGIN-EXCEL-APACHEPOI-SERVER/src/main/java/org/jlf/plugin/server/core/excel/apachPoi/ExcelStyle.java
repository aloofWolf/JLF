package org.jlf.plugin.server.core.excel.apachPoi;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.jlf.plugin.excel.server.api.JLFExcelStyle;
import org.jlf.plugin.excel.server.api.enums.JLFExcelAlignmentType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelBorderType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelVerticalAlignmentType;

/**
 * 
 * @ClassName: ExcelStyle
 * @Description:ExcelStyle实现
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class ExcelStyle implements JLFExcelStyle {

	private HSSFWorkbook workbook;
	private HSSFCellStyle cellStyle;
	private HSSFFont font;

	protected ExcelStyle(HSSFCellStyle cellStyle, HSSFFont font, HSSFWorkbook workbook) {
		this.cellStyle = cellStyle;
		this.font = font;
		this.workbook = workbook;
		this.cellStyle.setFont(font);
	}

	@Override
	public void setFontSize(short fontSize) {
		font.setFontHeightInPoints(fontSize);
	}

	@Override
	public void setBold(boolean isBold) {
		if (isBold) {
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		} else {
			font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		}
	}

	@Override
	public void setFontColor(short fontColor) {
		font.setColor(fontColor);
	}

	@Override
	public void setFontSelfColor(short fontOldColor, short[] fontSelfColor) {
		HSSFPalette palette = colorSelf(fontOldColor, fontSelfColor);
		font.setColor(palette.getColor(fontOldColor).getIndex());

	}

	@Override
	public void setFackGroundColor(short fackGroundColor) {
		cellStyle.setFillForegroundColor(fackGroundColor);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

	}

	@Override
	public void setFackGroundSelfColor(short fackGroundOldColor, short[] fackGroundSelfColor) {
		HSSFPalette palette = colorSelf(fackGroundOldColor, fackGroundSelfColor);
		cellStyle.setFillForegroundColor(palette.getColor(fackGroundOldColor).getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

	}

	@Override
	public void setFontName(String fontName) {
		font.setFontName(fontName);

	}

	@Override
	public void setAlignmentType(JLFExcelAlignmentType alignmentType) {
		if (JLFExcelAlignmentType.LEFT.equals(alignmentType)) {
			cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		} else if (JLFExcelAlignmentType.CENTER.equals(alignmentType)) {
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		} else if (JLFExcelAlignmentType.RIGHT.equals(alignmentType)) {
			cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		} else if (JLFExcelAlignmentType.FILL.equals(alignmentType)) {
			cellStyle.setAlignment(CellStyle.ALIGN_FILL);
		} else if (JLFExcelAlignmentType.JUSTIFY.equals(alignmentType)) {
			cellStyle.setAlignment(CellStyle.ALIGN_JUSTIFY);
		} else if (JLFExcelAlignmentType.CENTER_SELECTION.equals(alignmentType)) {
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		}
	}

	@Override
	public void setVerticalAlignmentType(JLFExcelVerticalAlignmentType verticalAlignmentType) {
		if (JLFExcelVerticalAlignmentType.TOP.equals(verticalAlignmentType)) {
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		} else if (JLFExcelVerticalAlignmentType.BOTTOM.equals(verticalAlignmentType)) {
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_BOTTOM);
		} else if (JLFExcelVerticalAlignmentType.CENTER.equals(verticalAlignmentType)) {
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		} else if (JLFExcelVerticalAlignmentType.JUSTIFY.equals(verticalAlignmentType)) {
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
		}

	}

	@Override
	public void setChangeLine(boolean isChangeLine) {
		cellStyle.setWrapText(isChangeLine);

	}

	@Override
	public void setBorderTop(JLFExcelBorderType borderType) {
		if (JLFExcelBorderType.NONE.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_NONE);
		} else if (JLFExcelBorderType.THIN.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		} else if (JLFExcelBorderType.MEDIUM.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		} else if (JLFExcelBorderType.DASHED.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_DASHED);
		} else if (JLFExcelBorderType.HAIR.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_HAIR);
		} else if (JLFExcelBorderType.THICK.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_THICK);
		} else if (JLFExcelBorderType.DOUBLE.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		} else if (JLFExcelBorderType.DOTTED.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_DOTTED);
		} else if (JLFExcelBorderType.MEDIUM_DASHED.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		} else if (JLFExcelBorderType.DASH_DOT.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_DASH_DOT);
		} else if (JLFExcelBorderType.MEDIUM_DASH_DOT.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASH_DOT);
		} else if (JLFExcelBorderType.DASH_DOT_DOT.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_DASH_DOT_DOT);
		} else if (JLFExcelBorderType.MEDIUM_DASH_DOT_DOT.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM_DASH_DOT_DOT);
		} else if (JLFExcelBorderType.SLANTED_DASH_DOT.equals(borderType)) {
			cellStyle.setBorderTop(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);
		}

	}

	@Override
	public void setBorderBottom(JLFExcelBorderType borderType) {
		if (JLFExcelBorderType.NONE.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);
		} else if (JLFExcelBorderType.THIN.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		} else if (JLFExcelBorderType.MEDIUM.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
		} else if (JLFExcelBorderType.DASHED.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DASHED);
		} else if (JLFExcelBorderType.HAIR.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_HAIR);
		} else if (JLFExcelBorderType.THICK.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THICK);
		} else if (JLFExcelBorderType.DOUBLE.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
		} else if (JLFExcelBorderType.DOTTED.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DOTTED);
		} else if (JLFExcelBorderType.MEDIUM_DASHED.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		} else if (JLFExcelBorderType.DASH_DOT.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DASH_DOT);
		} else if (JLFExcelBorderType.MEDIUM_DASH_DOT.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM_DASH_DOT);
		} else if (JLFExcelBorderType.DASH_DOT_DOT.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_DASH_DOT_DOT);
		} else if (JLFExcelBorderType.MEDIUM_DASH_DOT_DOT.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM_DASH_DOT_DOT);
		} else if (JLFExcelBorderType.SLANTED_DASH_DOT.equals(borderType)) {
			cellStyle.setBorderBottom(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);
		}
	}

	@Override
	public void setBorderLeft(JLFExcelBorderType borderType) {
		if (JLFExcelBorderType.NONE.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE);
		} else if (JLFExcelBorderType.THIN.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		} else if (JLFExcelBorderType.MEDIUM.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
		} else if (JLFExcelBorderType.DASHED.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DASHED);
		} else if (JLFExcelBorderType.HAIR.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_HAIR);
		} else if (JLFExcelBorderType.THICK.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THICK);
		} else if (JLFExcelBorderType.DOUBLE.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
		} else if (JLFExcelBorderType.DOTTED.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DOTTED);
		} else if (JLFExcelBorderType.MEDIUM_DASHED.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		} else if (JLFExcelBorderType.DASH_DOT.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DASH_DOT);
		} else if (JLFExcelBorderType.MEDIUM_DASH_DOT.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM_DASH_DOT);
		} else if (JLFExcelBorderType.DASH_DOT_DOT.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_DASH_DOT_DOT);
		} else if (JLFExcelBorderType.MEDIUM_DASH_DOT_DOT.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM_DASH_DOT_DOT);
		} else if (JLFExcelBorderType.SLANTED_DASH_DOT.equals(borderType)) {
			cellStyle.setBorderLeft(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);
		}
	}

	@Override
	public void setBorderRight(JLFExcelBorderType borderType) {
		if (JLFExcelBorderType.NONE.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_NONE);
		} else if (JLFExcelBorderType.THIN.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		} else if (JLFExcelBorderType.MEDIUM.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
		} else if (JLFExcelBorderType.DASHED.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_DASHED);
		} else if (JLFExcelBorderType.HAIR.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_HAIR);
		} else if (JLFExcelBorderType.THICK.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_THICK);
		} else if (JLFExcelBorderType.DOUBLE.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOUBLE);
		} else if (JLFExcelBorderType.DOTTED.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_DOTTED);
		} else if (JLFExcelBorderType.MEDIUM_DASHED.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM_DASHED);
		} else if (JLFExcelBorderType.DASH_DOT.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_DASH_DOT);
		} else if (JLFExcelBorderType.MEDIUM_DASH_DOT.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM_DASH_DOT);
		} else if (JLFExcelBorderType.DASH_DOT_DOT.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_DASH_DOT_DOT);
		} else if (JLFExcelBorderType.MEDIUM_DASH_DOT_DOT.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM_DASH_DOT_DOT);
		} else if (JLFExcelBorderType.SLANTED_DASH_DOT.equals(borderType)) {
			cellStyle.setBorderRight(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);
		}

	}

	@Override
	public void setViewType(short viewType) {
		cellStyle.setDataFormat(viewType);

	}

	private HSSFPalette colorSelf(short index, short[] colorCode) {
		HSSFPalette palette = workbook.getCustomPalette();
		palette.setColorAtIndex(index, (byte) colorCode[0], (byte) colorCode[1], (byte) colorCode[2]);
		return palette;
	}

	protected HSSFWorkbook getWorkbook() {
		return workbook;
	}

	protected HSSFCellStyle getCellStyle() {
		return cellStyle;
	}

	protected HSSFFont getFont() {
		return font;
	}

}
