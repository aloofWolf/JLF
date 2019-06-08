package org.jlf.soa.mvc.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFMVCBeanDatabaseType
 * @Description:ʵ����ƥ��ı����ڵ����ݿ�����
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public enum JLFMVCBeanDatabaseType implements IEnum{

	MAIN(1, "����"), CHILD(2, "�ӿ�");

	private Integer id;
	private String desc;

	JLFMVCBeanDatabaseType(Integer id, String desc) {
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
