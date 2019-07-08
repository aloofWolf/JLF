package org.jlf.plugin.excel.server.api.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFExcelVerticalAlignmentType
 * @Description:垂直对齐方式
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public enum JLFExcelVerticalAlignmentType implements IEnum {

	TOP(1, "上对齐"), CENTER(2, "居中对齐"), BOTTOM(3, "下对齐"), JUSTIFY(4, "两端对齐");

	private Integer id;
	private String desc;

	JLFExcelVerticalAlignmentType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return this.id;
	}

	public String getDesc() {
		return this.desc;
	}

}
