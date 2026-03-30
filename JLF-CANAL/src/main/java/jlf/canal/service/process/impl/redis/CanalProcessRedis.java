package jlf.canal.service.process.impl.redis;

import jlf.canal.metadata.bean.BinLogBean;
import jlf.canal.service.chain.CanalChain;
import jlf.canal.service.process.api.CanalProcessApi;
import jlf.canal.service.process.impl.redis.api.CanalProcessRedisApi;
import jlf.canal.service.process.impl.redis.factory.CanalProcessRedisFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: CanalProcessRedis
 * @Description: redis与数据库的同步
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Component
public class CanalProcessRedis implements CanalProcessApi {

	@Autowired
	private CanalProcessRedisFactory factory;

	public CanalProcessRedis() {
		CanalChain.register(this);
	}

	@Override
	public void process(BinLogBean bean) {
		String tableName = bean.getTable();
		CanalProcessRedisApi api = factory.get(tableName);
		String operatorType = bean.getType();
		if ("INSERT".equals(operatorType)) {
			api.insert(bean);
		} else if ("UPDATE".equals(operatorType)) {
			api.update(bean);
		} else if ("DELETE".equals(operatorType)) {
			api.delete(bean);
		}

	}

}
