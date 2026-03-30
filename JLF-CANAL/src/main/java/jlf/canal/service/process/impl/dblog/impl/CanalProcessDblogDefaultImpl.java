package jlf.canal.service.process.impl.dblog.impl;

import com.alibaba.fastjson.JSONObject;
import jlf.canal.dao.DbUpdateLogDao;
import jlf.canal.metadata.bean.BinLogBean;
import jlf.canal.metadata.entity.DbUpdateLog;
import jlf.canal.metadata.enums.DbUpdateType;
import jlf.canal.service.process.impl.dblog.api.CanalProcessDblogApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName: CanalProcessDblogDefaultImpl
 * @Description: CanalProcessDblogApi的默认实现
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Component
public class CanalProcessDblogDefaultImpl implements CanalProcessDblogApi {

	@Autowired
	private DbUpdateLogDao dao;

	@Override
	public void process(BinLogBean bean) {
		List<JSONObject> dataList = bean.getData();
		DbUpdateLog log;
		for (int i = 0; i < dataList.size(); i++) {
			JSONObject json = dataList.get(i);
			log = new DbUpdateLog();
			log.setDatabaseName(bean.getDatabase());
			log.setTableName(bean.getTable());
			log.setPkValue(json.getLong("id"));

			log.setData(json.toJSONString());
			DbUpdateType type = DbUpdateType.getDbUpdateType(bean.getType());
			log.setType(type);
			if (DbUpdateType.UPDATE.equals(type)) {
				log.setUpdateDetail(bean.getOld().get(i).toJSONString());
			}
			log.setExecuteTime(new Date(Long.parseLong(bean.getTs())));
			log.setCreateTime(new Date());
			dao.insert(log);
		}
	}

}
