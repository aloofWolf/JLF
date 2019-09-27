package org.jlf.product.quartz.wolf.server.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: QuartzExecuteResult
 * @Description:��ʱ����ִ�н��ö��
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public enum JLFQuartzExecuteResult implements IEnum {

	SUCCESS(0, "ִ�гɹ�"), FAIL(1, "ִ��ʧ��");
	private Integer id;
	private String desc;

	JLFQuartzExecuteResult(Integer id, String desc) {
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
