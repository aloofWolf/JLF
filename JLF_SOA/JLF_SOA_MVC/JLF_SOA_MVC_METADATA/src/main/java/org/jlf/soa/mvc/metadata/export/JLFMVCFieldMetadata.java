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

	private boolean isPrimary; // �Ƿ�����

	private boolean isNotNull; // �Ƿ�ǿ�

	private boolean isUnique; // �Ƿ�Ψһ

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

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public boolean isNotNull() {
		return isNotNull;
	}

	public void setNotNull(boolean isNotNull) {
		this.isNotNull = isNotNull;
	}

	public boolean isUnique() {
		return isUnique;
	}

	public void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
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
