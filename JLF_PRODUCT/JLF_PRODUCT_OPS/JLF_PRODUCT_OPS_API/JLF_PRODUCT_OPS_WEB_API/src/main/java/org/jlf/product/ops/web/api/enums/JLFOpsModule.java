package org.jlf.product.ops.web.api.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFOpsModule
 * @Description:运维模块
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public enum JLFOpsModule implements IEnum {

	PLUGIN(0, "插件"), PRODUCT(1, "产品"), SOA(2, "架构");
	private Integer id;
	private String desc;

	JLFOpsModule(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String getDesc() {
		return this.desc;
	}
}
