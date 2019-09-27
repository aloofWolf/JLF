package org.jlf.product.quartz.wolf.server.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFOpsResult
 * @Description:运维结果
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public enum JLFOpsResult implements IEnum {

	SUCCESS(0, "运维成功"), FAIL(1, "运维失败");
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
