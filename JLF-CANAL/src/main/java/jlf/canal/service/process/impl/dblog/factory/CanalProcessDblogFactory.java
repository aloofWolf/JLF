package jlf.canal.service.process.impl.dblog.factory;

import jlf.canal.service.process.impl.dblog.api.CanalProcessDblogApi;
import jlf.canal.service.process.impl.dblog.impl.CanalProcessDblogDefaultImpl;
import jlf.plus.factory.FactoryLazyLooadApi;
import jlf.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: CanalProcessDblogFactory
 * @Description: CanalProcessDblogApi实现的工厂
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Component
public class CanalProcessDblogFactory extends FactoryLazyLooadApi<String, CanalProcessDblogApi> {

	@Autowired
	private CanalProcessDblogDefaultImpl canalProcessDblogDefaultImpl;

	@Override
	public CanalProcessDblogApi getDefault() {
		return canalProcessDblogDefaultImpl;
	}

	@Override
	public String getValueClsFullName(String key) {
		return StringUtil.appendWithUnSafe("ops.canal.process.dblog.impl.CanalProcessDblog_", key.toLowerCase(),
				"Impl");
	}

}
