package org.jlf.common.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: BooleanType
 * @Description:布尔类型枚举
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public enum BooleanType implements IEnum {

	TRUE(0, true,"是"), FALSE(1, false,"否");
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
