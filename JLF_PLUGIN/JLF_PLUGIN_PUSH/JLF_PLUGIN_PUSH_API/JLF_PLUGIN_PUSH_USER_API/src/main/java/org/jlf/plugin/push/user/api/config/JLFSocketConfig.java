package org.jlf.plugin.push.user.api.config;

/**
 * 
 * @ClassName: JLFSocketConfig
 * @Description:socket配置信息
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public abstract class JLFSocketConfig extends JLFTransferConfig {

	/**
	 * 
	 * @Title: getIp
	 * @Description:获取ip
	 * @return
	 */
	public abstract String getIp();

	/**
	 * 
	 * @Title: getPort
	 * @Description:获取端口
	 * @return
	 */
	public abstract Integer getPort();

	/**
	 * 
	 * @Title: getMaxConnCount
	 * @Description:获取连接池的最大连接数,可被子类覆盖,如果为0,则为短连接
	 * @return
	 */
	public Integer getMaxConnCount() {
		return 10;
	}
}
