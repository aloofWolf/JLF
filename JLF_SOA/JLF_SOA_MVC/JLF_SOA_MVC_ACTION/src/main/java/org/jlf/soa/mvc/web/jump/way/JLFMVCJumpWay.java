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

	ASYN(1, new JLFMVCJumpAsynProcess()), // 异步
	FORWARD(2, new JLFMVCJumpForwardProcess()), // 转发
	REDIRECT(3, new JLFMVCJumpRedirectProcess());// 重定向

	private Integer id;
	private JLFMVCIJumpProcess type;

	private JLFMVCJumpWay(Integer id, JLFMVCIJumpProcess type) {
		this.id = id;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JLFMVCIJumpProcess getType() {
		return type;
	}

	public void setType(JLFMVCIJumpProcess type) {
		this.type = type;
	}

}
