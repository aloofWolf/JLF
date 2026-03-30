package jlf.canal.service.chain;

import jlf.canal.metadata.bean.BinLogBean;
import jlf.canal.service.process.api.CanalProcessApi;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: CanalChain
 * @Description: canal处理的责任链
 * @author Lone Wolf
 * @date 2023年11月20日
 */
@Component
public class CanalChain {

	private static List<CanalProcessApi> list = new ArrayList<>(); // 责任链

	public static void register(CanalProcessApi api) { // 向责任链中注册
		list.add(api);
	}
	
	@Autowired
	private CanalChainAsync async;

	/**
	 * 
	 * @Title: execute
	 * @Description: canal处理
	 * @param bean
	 */
	@Async("baseAsync")
	@SneakyThrows
	public void execute(BinLogBean bean) {
		if (bean.isDdl()) {
			return;
		}
		for (CanalProcessApi api : list) {
			async.execute(api, bean);
		}
	}
}
