package jlf.canal.service.process.impl.redis.api;

import jlf.canal.metadata.bean.BinLogBean;

/**
 * 
 * @ClassName: CanalProcessRedisApi
 * @Description: redis数据同步的api
 * @author Lone Wolf
 * @date 2023年11月20日
 */
public interface CanalProcessRedisApi {

	/**
	 * 
	 * @Title: insert
	 * @Description: 监听到insert数据的动作
	 * @param binLogBean
	 */
	public void insert(BinLogBean binLogBean);

	/**
	 * 
	 * @Title: update
	 * @Description: 监听到update数据的动作
	 * @param binLogBean
	 */
	public void update(BinLogBean binLogBean);

	/**
	 * 
	 * @Title: delete
	 * @Description: 监听到delete数据的操作
	 * @param binLogBean
	 */
	public void delete(BinLogBean binLogBean);

}
