package jlf.canal.service.process.api;


import jlf.canal.metadata.bean.BinLogBean;

/**
 * 
 * @ClassName: CanalProcessApi
 * @Description: cana处理的api
 * @author Lone Wolf
 * @date 2023年11月20日
 */
public interface CanalProcessApi {

	public void process(BinLogBean bean);

}
