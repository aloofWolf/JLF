package org.jlf.plugin.excel.server.api.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFExcelVerticalAlignmentType
 * @Description:��ֱ���뷽ʽ
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public enum JLFExcelVerticalAlignmentType implements IEnum {

	TOP(1, "�϶���"), CENTER(2, "���ж���"), BOTTOM(3, "�¶���"), JUSTIFY(4, "���˶���");

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
