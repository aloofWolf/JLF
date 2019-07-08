package org.jlf.product.quartz.wolf.server.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: QuartzType
 * @Description:定时任务类型枚举
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public enum QuartzType implements IEnum {

	MAIN(1, "主任务"), COMMON(2, "普通任务");
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
