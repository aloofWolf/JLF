package org.jlf.soa.mvc.metadata.export;

import java.util.List;

/**
 * 
 * @ClassName: JLFMVCTablesMetadata
 * @Description:JLFMVCTablesMetadata
 * @author Lone Wolf
 * @date 2019年7月6日
 */
public class JLFMVCTablesMetadata {

	private List<JLFMVCTableMetadata> tables; // 表列表

	public JLFMVCTablesMetadata(List<JLFMVCTableMetadata> tables) {
		this.tables = tables;
	}

	public List<JLFMVCTableMetadata> getTables() {
		return tables;
	}

	public void setTables(List<JLFMVCTableMetadata> tables) {
		this.tables = tables;
	}

}
