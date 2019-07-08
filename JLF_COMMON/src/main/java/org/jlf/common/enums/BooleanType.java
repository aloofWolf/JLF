package org.jlf.common.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: BooleanType
 * @Description:��������ö��
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public enum BooleanType implements IEnum {

	TRUE(0, "��"), FALSE(1, "��");
	private Integer id;
	private String desc;

	BooleanType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String getDesc() {
		return desc;
	}

}
