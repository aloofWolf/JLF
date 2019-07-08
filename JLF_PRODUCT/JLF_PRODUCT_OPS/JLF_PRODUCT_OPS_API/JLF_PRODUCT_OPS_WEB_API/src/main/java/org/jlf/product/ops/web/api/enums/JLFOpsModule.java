package org.jlf.product.ops.web.api.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFOpsModule
 * @Description:��άģ��
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public enum JLFOpsModule implements IEnum {

	PLUGIN(0, "���"), PRODUCT(1, "��Ʒ"), SOA(2, "�ܹ�");
	private Integer id;
	private String desc;

	JLFOpsModule(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String getDesc() {
		return this.desc;
	}
}
