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

	ASYN(1, "�첽", new JLFMVCJumpAsynProcess()), FORWARD(2, "ת��", new JLFMVCJumpForwardProcess()), REDIRECT(3, "�ض���",
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
