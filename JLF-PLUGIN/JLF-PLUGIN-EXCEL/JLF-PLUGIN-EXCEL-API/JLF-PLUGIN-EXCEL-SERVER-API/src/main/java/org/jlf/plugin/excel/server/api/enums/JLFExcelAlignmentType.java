package org.jlf.plugin.excel.server.api.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFExcelAlignmentType
 * @Description:ˮƽ���뷽ʽ
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public enum JLFExcelAlignmentType implements IEnum {

	LEFT(1, "�����"), CENTER(2, "���ж���"), RIGHT(3, "�Ҷ���"), FILL(4, "������"), JUSTIFY(5, "���˶���"), CENTER_SELECTION(6,
			"���о��ж���");

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
