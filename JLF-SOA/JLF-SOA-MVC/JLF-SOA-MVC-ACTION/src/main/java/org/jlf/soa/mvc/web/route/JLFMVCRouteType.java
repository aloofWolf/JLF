package org.jlf.soa.mvc.web.route;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFMVCRouteType
 * @Description: JLFMVCRouteType
 * @author Lone Wolf
 * @date 2019年9月24日
 */
public enum JLFMVCRouteType implements IEnum {

	COMM(1, "普通类"), INTER(2, "接口类"), IMPL(3, "实现类");

	private Integer id;
	private String desc;

	private JLFMVCRouteType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
}