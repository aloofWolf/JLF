package jlf.canal.service.process.impl.redis.factory;

import jlf.canal.service.process.impl.redis.api.CanalProcessRedisApi;
import jlf.canal.service.process.impl.redis.impl.CanalProcessRedisDefaultImpl;
import jlf.plus.factory.FactoryLazyLooadApi;
import jlf.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: CanalProcessRedisFactory
 * @Description: CanalProcessRedisApi实现的工厂CanalProcessRedisApi
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Component
public class CanalProcessRedisFactory extends FactoryLazyLooadApi<String, CanalProcessRedisApi> {

	@Autowired
	private CanalProcessRedisDefaultImpl canalProcessRedisDefaultImpl;

	@Override
	public CanalProcessRedisApi getDefault() {
		return canalProcessRedisDefaultImpl;
	}

	@Override
	public String getValueClsFullName(String key) {
		return StringUtil.appendWithUnSafe("ops.service.canal.process.redis.impl.CanalProcessRedis_", key.toLowerCase(),
				"_impl");
	}

}