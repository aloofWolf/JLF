package org.jlf.core.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: CodeEnvironment
 * @Description:环境变量枚举
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public enum CodeEnvironment implements IEnum {

	DEVELOP(1, "开发环境"), TEST(2, "测试环境"), PRODUCE(3, "生产环境");

	private Integer id;
	private String desc;

	CodeEnvironment(Integer id, String desc) {
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
