package jlf.canal.metadata.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import jlf.plus.enums.EnumApi;
import lombok.Getter;

/**
 * 
 * @ClassName: DbUpdateType
 * @Description: 数据库变更类型
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Getter
public enum DbUpdateType implements EnumApi<Integer> {
	INSERT(0, "新增"), UPDATE(1, "更新"), DELETE(2, "删除");

	@EnumValue
	private int id;
	@JsonValue
	private String name;

	DbUpdateType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static DbUpdateType getDbUpdateType(String desc) {
		if ("INSERT".equals(desc)) {
			return DbUpdateType.INSERT;
		} else if ("UPDATE".equals(desc)) {
			return DbUpdateType.UPDATE;
		} else if ("DELETE".equals(desc)) {
			return DbUpdateType.DELETE;
		} else {
			return null;
		}
	}
}
