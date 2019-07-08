package org.jlf.soa.mvc.web.jump.way;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFMVCJumpWay
 * @Description:跳转方式枚举
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public enum JLFMVCJumpWay implements IEnum {

	ASYN(1, "异步", new JLFMVCJumpAsynProcess()), FORWARD(2, "转发", new JLFMVCJumpForwardProcess()), REDIRECT(3, "重定向",
			new JLFMVCJumpRedirectProcess());

	private Integer id;
	private String desc;
	private JLFMVCIJumpProcess type;

	private JLFMVCJumpWay(Integer id, String desc, JLFMVCIJumpProcess type) {
		this.id = id;
		this.desc = desc;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	public JLFMVCIJumpProcess getType() {
		return type;
	}

}
