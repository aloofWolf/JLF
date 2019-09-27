package org.jlf.soa.mvc.web.route;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFMVCRouteType
 * @Description: JLFMVCRouteType
 * @author Lone Wolf
 * @date 2019��9��24��
 */
public enum JLFMVCRouteType implements IEnum {

	COMM(1, "��ͨ��"), INTER(2, "�ӿ���"), IMPL(3, "ʵ����");

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