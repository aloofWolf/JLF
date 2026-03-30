package jlf.canal.service.chain;

import jlf.canal.metadata.bean.BinLogBean;
import jlf.canal.service.process.api.CanalProcessApi;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: CanalChainAsync
 * @Description: 责任链异步处理
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Component
public class CanalChainAsync {

	/**
	 * 
	 * @Title: execute
	 * @Description: 责任链异步处理
	 * @param api
	 * @param bean
	 */
	@Async("baseAsync")
	public void execute(CanalProcessApi api, BinLogBean bean) {
		api.process(bean);
	}

}
