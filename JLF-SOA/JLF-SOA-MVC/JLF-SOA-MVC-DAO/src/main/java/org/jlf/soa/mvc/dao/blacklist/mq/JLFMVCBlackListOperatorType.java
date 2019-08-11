package org.jlf.soa.mvc.dao.blacklist.mq;

import org.jlf.common.enums.api.IEnum;

public enum JLFMVCBlackListOperatorType implements IEnum {

	ADD(1, "����"), REMOVE(2, "ɾ��");

	private Integer id;
	private String desc;

	JLFMVCBlackListOperatorType(Integer id, String desc) {
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

