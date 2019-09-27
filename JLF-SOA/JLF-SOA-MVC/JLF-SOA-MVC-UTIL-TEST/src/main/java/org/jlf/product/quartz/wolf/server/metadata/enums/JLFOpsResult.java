package org.jlf.product.quartz.wolf.server.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFOpsResult
 * @Description:��ά���
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public enum JLFOpsResult implements IEnum {

	SUCCESS(0, "��ά�ɹ�"), FAIL(1, "��άʧ��");
	private Integer id;
	private String desc;

	JLFOpsResult(Integer id, String desc) {
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
