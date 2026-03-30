package jlf.canal.service.process.impl.dblog;

import jlf.canal.metadata.bean.BinLogBean;
import jlf.canal.service.chain.CanalChain;
import jlf.canal.service.process.api.CanalProcessApi;
import jlf.canal.service.process.impl.dblog.api.CanalProcessDblogApi;
import jlf.canal.service.process.impl.dblog.factory.CanalProcessDblogFactory;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: CanalProcessDblog
 * @Description: 记录数据库的变更日志
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Component
public class CanalProcessDblog implements CanalProcessApi {
	
	@Autowired
	private CanalProcessDblogFactory canalProcessDblogFactory;
	
	public CanalProcessDblog(){
		CanalChain.register(this);
	}

	@SneakyThrows
	@Override
	public void process(BinLogBean bean) {
		String table = bean.getTable();
		CanalProcessDblogApi api = canalProcessDblogFactory.get(table);
		api.process(bean);
		
	}

}
