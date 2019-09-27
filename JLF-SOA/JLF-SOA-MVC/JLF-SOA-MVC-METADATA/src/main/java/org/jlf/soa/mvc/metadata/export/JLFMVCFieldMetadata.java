package org.jlf.soa.mvc.metadata.export;

import org.jlf.common.util.StringUtil;

/**
 * 
 * @ClassName: JLFMVCFieldMetadata
 * @Description:JLFMVCFieldMetadata
 * @author Lone Wolf
 * @date 2019��7��6��
 */
public class JLFMVCFieldMetadata {

	private String fieldName; // �ֶ�����

	private String dataType; // ��������

	private boolean primary; // �Ƿ�����

	private boolean notNull; // �Ƿ�ǿ�

	private boolean unique; // �Ƿ�Ψһ

	private String uniqueName; // ΨһԼ������

	private String[] joinUniqueField; // ����ΨһԼ���ֶ�

	private Integer[] check; // checkԼ��

	private String checkStr; // checkԼ���ַ���

	private String defaultValue; // Ĭ��ֵ

	private String desc; // �ֶ�����

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
