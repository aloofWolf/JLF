package org.jlf.product.quartz.wolf.server.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: QuartzExecuteResult
 * @Description:定时任务执行结果枚举
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public enum QuartzExecuteResult implements IEnum {

	SUCCESS(0, "执行成功"), FAIL(1, "执行失败");
	private Integer id;
	private String name;

	QuartzExecuteResult(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

}
