package org.jlf.product.quartz.wolf.server.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: QuartzType
 * @Description:��ʱ��������ö��
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public enum QuartzType implements IEnum {

	MAIN(1, "������"), COMMON(2, "��ͨ����");
	private Integer id;
	private String desc;

	QuartzType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return this.id;
	}

	public String getDesc() {
		return desc;
	}

}
