package org.jlf.product.quartz.wolf.server.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFOpsType
 * @Description:��ά����
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public enum JLFOpsType implements IEnum {

	START(0, "���������"), STOP(1, "ֹͣ�����"), RESTART(2, "���������"), REBIND(3, "�ͻ������°�"), RELOADCONFIG(4, "���¼��������ļ�");
	private Integer id;
	private String desc;

	JLFOpsType(Integer id, String desc) {
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
