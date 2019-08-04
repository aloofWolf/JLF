package org.jlf.plugin.excel.server.api.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFExcelBorderType
 * @Description:边框模式,依次增强
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public enum JLFExcelBorderType implements IEnum {

	NONE(1, "NONE"), THIN(2, "THIN"), MEDIUM(3, "MEDIUM"), DASHED(4, "DASHED"), HAIR(5, "HAIR"), THICK(6,
			"THICK"), DOUBLE(7, "DOUBLE"), DOTTED(8, "DOTTED"), MEDIUM_DASHED(9, "MEDIUM_DASHED"), DASH_DOT(10,
					"DASH_DOT"), MEDIUM_DASH_DOT(11, "MEDIUM_DASH_DOT"), DASH_DOT_DOT(12,
							"DASH_DOT_DOT"), MEDIUM_DASH_DOT_DOT(13,
									"MEDIUM_DASH_DOT_DOT"), SLANTED_DASH_DOT(14, "SLANTED_DASH_DOT");

	private Integer id;
	private String desc;

	JLFExcelBorderType(Integer id, String desc) {
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
