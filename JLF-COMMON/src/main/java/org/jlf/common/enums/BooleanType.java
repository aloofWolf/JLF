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

	TRUE(0, true,"��"), FALSE(1, false,"��");
	private Integer id;
	private boolean bln;
	private String desc;

	BooleanType(Integer id, boolean bln,String desc) {
		this.id = id;
		this.bln = bln;
		this.desc = desc;
	}

	public Integer getId() {
		return this.id;
	}

	public boolean isBln() {
		return bln;
	}

	@Override
	public String getDesc() {
		return desc;
	}

}
