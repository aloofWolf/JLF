package org.jlf.common.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: BooleanType
 * @Description:布尔类型枚举
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public enum BooleanType implements IEnum{

	TRUE(0), FALSE(1);
	private Integer id;

	BooleanType(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

}
