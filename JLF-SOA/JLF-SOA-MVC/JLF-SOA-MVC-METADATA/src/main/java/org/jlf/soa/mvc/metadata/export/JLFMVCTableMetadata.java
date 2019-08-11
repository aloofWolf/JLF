package org.jlf.soa.mvc.metadata.export;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: JLFMVCTableMetadata
 * @Description:JLFMVCFieldMetadata
 * @author Lone Wolf
 * @date 2019��7��6��
 */
public class JLFMVCTableMetadata {

	private String tableName; // ������

	private String desc; // ������

	private List<JLFMVCFieldMetadata> fields = new ArrayList<JLFMVCFieldMetadata>(); // �ֶ��б�

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<JLFMVCFieldMetadata> getFields() {
		return fields;
	}

	public void setField(JLFMVCFieldMetadata field) {
		this.fields.add(field);
	}

}
