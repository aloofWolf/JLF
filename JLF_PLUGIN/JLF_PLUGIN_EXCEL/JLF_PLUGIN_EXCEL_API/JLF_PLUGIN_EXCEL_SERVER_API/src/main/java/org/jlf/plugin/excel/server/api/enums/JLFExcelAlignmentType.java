package org.jlf.plugin.excel.server.api.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFExcelAlignmentType
 * @Description:水平对齐方式
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public enum JLFExcelAlignmentType implements IEnum {

	LEFT(1, "左对齐"), CENTER(2, "居中对齐"), RIGHT(3, "右对齐"), FILL(4, "填充对齐"), JUSTIFY(5, "两端对齐"), CENTER_SELECTION(6,
			"跨列居中对齐");

	private Integer id;
	private String desc;

	JLFExcelAlignmentType(Integer id, String desc) {
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
