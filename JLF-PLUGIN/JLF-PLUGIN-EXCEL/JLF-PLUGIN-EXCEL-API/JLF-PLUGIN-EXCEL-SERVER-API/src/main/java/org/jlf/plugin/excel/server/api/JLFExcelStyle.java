package org.jlf.plugin.excel.server.api;

import org.jlf.plugin.excel.server.api.enums.JLFExcelAlignmentType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelBorderType;
import org.jlf.plugin.excel.server.api.enums.JLFExcelVerticalAlignmentType;

/**
 * 
 * @ClassName: JLFExcelStyle
 * @Description:ExcelStyle
 * @author Lone Wolf
 * @date 2019��7��1��
 */
public interface JLFExcelStyle {

	/**
	 * 
	 * @Title: setFontSize
	 * @Description:���õ�Ԫ�������С
	 * @param fontSize
	 */
	public void setFontSize(short fontSize);

	/**
	 * 
	 * @Title: setBold
	 * @Description:���õ�Ԫ������Ӵ�
	 * @param isBold
	 */
	public void setBold(boolean isBold);

	/**
	 * 
	 * @Title: setFontColor
	 * @Description:���õ�Ԫ��������ɫ
	 * @param fontColor
	 */
	public void setFontColor(short fontColor);

	/**
	 * 
	 * @Title: setFontSelfColor
	 * @Description: ���õ�Ԫ��������ɫ ,��ԭ����ɫ�滻���Զ�����ɫ
	 * @param fontOldColor
	 *            ԭ����ɫ
	 * @param fontSelfColor
	 *            �Զ�����ɫ
	 */
	public void setFontSelfColor(short fontOldColor, short[] fontSelfColor);

	/**
	 * 
	 * @Title: setFackGroundSelfBaseColor
	 * @Description:���õ�Ԫ�񱳾�ɫ
	 * @param fackGroundSelfBaseColor
	 */
	public void setFackGroundColor(short fackGroundColor);

	/**
	 * 
	 * @Title: setFackGroundSelfColor
	 * @Description:���õ�Ԫ�񱳾��Զ�����ɫ,��ԭ����ɫ�滻���Զ�����ɫ
	 * @param fackGroundOldColor
	 *            ԭ����ɫ
	 * @param fackGroundSelfColor
	 *            �Զ�����ɫ
	 */
	public void setFackGroundSelfColor(short fackGroundOldColor, short[] fackGroundSelfColor);

	/**
	 * 
	 * @Title: setFontName
	 * @Description:���õ�Ԫ������
	 * @param fontName
	 */
	public void setFontName(String fontName);

	/**
	 * 
	 * @Title: setAlignmentType
	 * @Description:����ˮƽ���뷽ʽ
	 * @param alignmentType
	 */
	public void setAlignmentType(JLFExcelAlignmentType alignmentType);

	/**
	 * 
	 * @Title: setVerticalAlignmentType
	 * @Description:���ô�ֱ���뷽ʽ
	 * @param verticalAlignmentType
	 */
	public void setVerticalAlignmentType(JLFExcelVerticalAlignmentType verticalAlignmentType);

	/**
	 * 
	 * @Title: setChangeLine
	 * @Description:�����Ƿ��Զ�����
	 * @param isChangeLine
	 */
	public void setChangeLine(boolean isChangeLine);

	/**
	 * 
	 * @Title: setBorderTop
	 * @Description:�����Ƿ���ϱ߿�
	 * @param borderType
	 */
	public void setBorderTop(JLFExcelBorderType borderType);

	/**
	 * 
	 * @Title: setBorderBottom
	 * @Description:�����Ƿ���±߿�
	 * @param borderType
	 */
	public void setBorderBottom(JLFExcelBorderType borderType);

	/**
	 * 
	 * @Title: setBorderLeft
	 * @Description:�Ƿ����߿�
	 * @param borderType
	 */
	public void setBorderLeft(JLFExcelBorderType borderType);

	/**
	 * 
	 * @Title: setBorderRight
	 * @Description:�Ƿ���ұ߿�
	 * @param borderType
	 */
	public void setBorderRight(JLFExcelBorderType borderType);

	/**
	 * 
	 * @Title: setViewType
	 * @Description:������ʾ���ͣ�ֵ���£�
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
