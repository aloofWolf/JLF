package org.jlf.plugin.excel.server.api;

import org.jlf.plugin.excel.server.api.enums.JLFExcelAlignmentType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelBorderType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelVerticalAlignmentType;

/**
 * 
 * @ClassName: JLFExcelStyle
 * @Description:ExcelStyle
 * @author Lone Wolf
 * @date 2019年7月1日
 */
public interface JLFExcelStyle {

	/**
	 * 
	 * @Title: setFontSize
	 * @Description:设置单元格字体大小
	 * @param fontSize
	 */
	public void setFontSize(short fontSize);

	/**
	 * 
	 * @Title: setBold
	 * @Description:设置单元格字体加粗
	 * @param isBold
	 */
	public void setBold(boolean isBold);

	/**
	 * 
	 * @Title: setFontColor
	 * @Description:设置单元格字体颜色
	 * @param fontColor
	 */
	public void setFontColor(short fontColor);

	/**
	 * 
	 * @Title: setFontSelfColor
	 * @Description: 设置单元格字体颜色 ,将原有颜色替换成自定义颜色
	 * @param fontOldColor
	 *            原有颜色
	 * @param fontSelfColor
	 *            自定义颜色
	 */
	public void setFontSelfColor(short fontOldColor, short[] fontSelfColor);

	/**
	 * 
	 * @Title: setFackGroundSelfBaseColor
	 * @Description:设置单元格背景色
	 * @param fackGroundSelfBaseColor
	 */
	public void setFackGroundColor(short fackGroundColor);

	/**
	 * 
	 * @Title: setFackGroundSelfColor
	 * @Description:设置单元格背景自定义颜色,将原有颜色替换成自定义颜色
	 * @param fackGroundOldColor
	 *            原有颜色
	 * @param fackGroundSelfColor
	 *            自定义颜色
	 */
	public void setFackGroundSelfColor(short fackGroundOldColor, short[] fackGroundSelfColor);

	/**
	 * 
	 * @Title: setFontName
	 * @Description:设置单元格字体
	 * @param fontName
	 */
	public void setFontName(String fontName);

	/**
	 * 
	 * @Title: setAlignmentType
	 * @Description:设置水平对齐方式
	 * @param alignmentType
	 */
	public void setAlignmentType(JLFExcelAlignmentType alignmentType);

	/**
	 * 
	 * @Title: setVerticalAlignmentType
	 * @Description:设置垂直对齐方式
	 * @param verticalAlignmentType
	 */
	public void setVerticalAlignmentType(JLFExcelVerticalAlignmentType verticalAlignmentType);

	/**
	 * 
	 * @Title: setChangeLine
	 * @Description:设置是否自动换行
	 * @param isChangeLine
	 */
	public void setChangeLine(boolean isChangeLine);

	/**
	 * 
	 * @Title: setBorderTop
	 * @Description:设置是否加上边框
	 * @param borderType
	 */
	public void setBorderTop(JLFExcelBorderType borderType);

	/**
	 * 
	 * @Title: setBorderBottom
	 * @Description:设置是否加下边框
	 * @param borderType
	 */
	public void setBorderBottom(JLFExcelBorderType borderType);

	/**
	 * 
	 * @Title: setBorderLeft
	 * @Description:是否加左边框
	 * @param borderType
	 */
	public void setBorderLeft(JLFExcelBorderType borderType);

	/**
	 * 
	 * @Title: setBorderRight
	 * @Description:是否加右边框
	 * @param borderType
	 */
	public void setBorderRight(JLFExcelBorderType borderType);

	/**
	 * 
	 * @Title: setViewType
	 * @Description:设置显示类型，值如下：
	 * @param viewType
	 */
	public void setViewType(short viewType);

	/*
	 * 0, "General" 1, "0" 2, "0.00" 3, "#,##0" 4, "#,##0.00" 5,
	 * "$#,##0_);($#,##0)" 6, "$#,##0_);[Red]($#,##0)" 7,
	 * "$#,##0.00);($#,##0.00)" 8, "$#,##0.00_);[Red]($#,##0.00)" 9, "0%" 0xa,
	 * "0.00%" 0xb, "0.00E+00" 0xc, "# ?/?" 0xd, "# ??/??" 0xe, "m/d/yy" 0xf,
	 * "d-mmm-yy" 0x10, "d-mmm" 0x11, "mmm-yy" 0x12, "h:mm AM/PM" 0x13,
	 * "h:mm:ss AM/PM" 0x14, "h:mm" 0x15, "h:mm:ss" 0x16, "m/d/yy h:mm"
	 * 
	 * // 0x17 - 0x24 reserved for international and undocumented 0x25,
	 * "#,##0_);(#,##0)" 0x26, "#,##0_);[Red](#,##0)" 0x27,
	 * "#,##0.00_);(#,##0.00)" 0x28, "#,##0.00_);[Red](#,##0.00)" 0x29,
	 * "_(*#,##0_);_(*(#,##0);_(* /"-/"_);_(@_)" 0x2a,
	 * "_($*#,##0_);_($*(#,##0);_($* /"-/"_);_(@_)" 0x2b,
	 * "_(*#,##0.00_);_(*(#,##0.00);_(* /"-/"??_);_(@_)" 0x2c,
	 * "_($*#,##0.00_);_($*(#,##0.00);_($* /"-/"??_);_(@_)" 0x2d, "mm:ss" 0x2e,
	 * "[h]:mm:ss" 0x2f, "mm:ss.0" 0x30, "##0.0E+0" 0x31, "@" - This is text
	 * format. 0x31 "text" - Alias for "@"
	 */

}
