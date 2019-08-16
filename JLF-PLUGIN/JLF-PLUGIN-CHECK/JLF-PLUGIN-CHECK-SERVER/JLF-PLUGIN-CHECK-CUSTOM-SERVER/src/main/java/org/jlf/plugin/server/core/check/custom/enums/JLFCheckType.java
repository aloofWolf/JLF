package org.jlf.plugin.server.core.check.custom.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFCheckType
 * @Description: JLFCheckType
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ16ÈÕ
 */
public enum JLFCheckType implements IEnum {

	FIELD(0, "FIELD"), PARAMETER(1, "PARAMETER");
	private Integer id;
	private String desc;

	JLFCheckType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return this.id;
	}

	@Override
	public String getDesc() {
		return desc;
	}

}
