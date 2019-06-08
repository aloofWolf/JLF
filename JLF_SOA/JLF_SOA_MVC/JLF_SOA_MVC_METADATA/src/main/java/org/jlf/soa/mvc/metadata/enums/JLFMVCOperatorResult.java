package org.jlf.soa.mvc.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFMVCOperatorResult
 * @Description:������ö��
 * @author Lone Wolf
 * @date 2019��5��25��
 */
public enum JLFMVCOperatorResult  implements IEnum{

	SUCCESS(1, "����ɹ�"), FAIL(2, "����ʧ��");

	private Integer id;
	private String desc;

	JLFMVCOperatorResult(Integer id, String desc) {
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
