package org.jlf.soa.mvc.web.jump.way;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFMVCJumpWay
 * @Description:��ת��ʽö��
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public enum JLFMVCJumpWay implements IEnum {

	ASYN(1, new JLFMVCJumpAsynProcess()), // �첽
	FORWARD(2, new JLFMVCJumpForwardProcess()), // ת��
	REDIRECT(3, new JLFMVCJumpRedirectProcess());// �ض���

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
