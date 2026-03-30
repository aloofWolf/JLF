package jlf.canal.metadata.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jlf.canal.metadata.enums.DbUpdateType;
import jlf.orm.metadata.ann.Cache;
import jlf.orm.metadata.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 
 * @ClassName: DbUpdateLog
 * @Description: DbUpdateLog
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("ops_db_update_log")
@Cache
public class DbUpdateLog extends BaseEntity {

	private static final long serialVersionUID = -1318569395364768462L;
	private String databaseName; // 数据库名称

	private String tableName; // 表名

	private Long pkValue; // id

	private Date executeTime; // 执行时间

	private DbUpdateType type; // 变更类型

	private String data; // 变更前

	private String updateDetail; // 变更后

	private Date createTime;
}
