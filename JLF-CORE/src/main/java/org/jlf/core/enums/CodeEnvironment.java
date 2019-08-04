package org.jlf.core.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: CodeEnvironment
 * @Description:��������ö��
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public enum CodeEnvironment implements IEnum {

	DEVELOP(1, "��������"), TEST(2, "���Ի���"), PRODUCE(3, "��������");

	private Integer id;
	private String desc;

	CodeEnvironment(Integer id, String desc) {
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
