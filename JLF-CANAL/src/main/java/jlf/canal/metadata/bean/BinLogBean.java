package jlf.canal.metadata.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 
 * @ClassName: BinLogBean
 * @Description: BinLogBean
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Data
@ToString
public class BinLogBean {

	private List<JSONObject> data;
	private String database;
	private String es;
	private Long id;
	private boolean isDdl;
	private JSONObject mysqlType;
	private List<JSONObject> old;
	private JSONArray pkNames;
	private String sql;
	private JSONObject sqpType;
	private String table;
	private String ts;
	private String type;

}
