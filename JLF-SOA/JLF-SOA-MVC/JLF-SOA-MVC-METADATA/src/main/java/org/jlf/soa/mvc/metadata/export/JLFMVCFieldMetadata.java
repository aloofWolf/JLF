package org.jlf.soa.mvc.metadata.export;

import org.jlf.common.util.StringUtil;

/**
 * 
 * @ClassName: JLFMVCFieldMetadata
 * @Description:JLFMVCFieldMetadata
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class JLFMVCFieldMetadata {

	private String fieldName; // 字段名称

	private String dataType; // 数据类型

	private boolean primary; // 是否主键

	private boolean notNull; // 是否非空

	private boolean unique; // 是否唯一

	private String uniqueName; // 唯一约束名称

	private String[] joinUniqueField; // 联合唯一约束字段

	private Integer[] check; // check约束

	private String checkStr; // check约束字符串

	private String defaultValue; // 默认值

	private String desc; // 字段描述

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Boolean isPrimary() {
		return primary;
	}

	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	public boolean isNotNull() {
		return notNull;
	}

	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public String[] getJoinUniqueField() {
		return joinUniqueField;
	}

	public void setJoinUniqueField(String[] joinUniqueField) {
		this.joinUniqueField = joinUniqueField;
	}

	public Integer[] getCheck() {
		return check;
	}

	public void setCheck(Integer[] check) {
		this.check = check;
		this.checkStr = StringUtil.arrToStr(check);
	}

	public String getCheckStr() {
		return checkStr;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
