package jlf.canal.service.process.impl.dblog.api;


import jlf.canal.metadata.bean.BinLogBean;

/**
 * 
 * @ClassName: CanalProcessDblogApi
 * @Description: 记录数据库的变更日志API
 * @author Lone Wolf
 * @date 2023年11月20日
 */
public interface CanalProcessDblogApi {

	public void process(BinLogBean bean);

}
