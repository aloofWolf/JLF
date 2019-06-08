package org.jlf.soa.mvc.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFMVCBeanDatabaseType
 * @Description:实体类匹配的表所在的数据库类型
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public enum JLFMVCBeanDatabaseType implements IEnum{

	MAIN(1, "主库"), CHILD(2, "子库");

	private Integer id;
	private String desc;

	JLFMVCBeanDatabaseType(Integer id, String desc) {
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
