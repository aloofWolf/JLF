package org.jlf.soa.mvc.metadata.export;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: JLFMVCTableMetadata
 * @Description:JLFMVCFieldMetadata
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class JLFMVCTableMetadata {

	private String tableName; // 表名称

	private String desc; // 表描述

	private List<JLFMVCFieldMetadata> fields = new ArrayList<JLFMVCFieldMetadata>(); // 字段列表

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
