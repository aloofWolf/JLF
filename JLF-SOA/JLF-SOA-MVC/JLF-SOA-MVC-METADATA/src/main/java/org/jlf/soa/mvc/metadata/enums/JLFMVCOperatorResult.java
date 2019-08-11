package org.jlf.soa.mvc.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFMVCOperatorResult
 * @Description:请求结果枚举
 * @author Lone Wolf
 * @date 2019年5月25日
 */
public enum JLFMVCOperatorResult  implements IEnum{

	SUCCESS(1, "请求成功"), FAIL(2, "请求失败");

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
