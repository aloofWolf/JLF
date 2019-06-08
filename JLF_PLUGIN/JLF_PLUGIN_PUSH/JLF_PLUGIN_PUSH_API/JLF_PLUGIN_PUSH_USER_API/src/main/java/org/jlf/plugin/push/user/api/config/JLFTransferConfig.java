package org.jlf.plugin.push.user.api.config;

/**
 * 
 * @ClassName: JLFTransferConfig
 * @Description:传输对象配置
 * @author Lone Wolf
 * @date 2019年6月7日
 */
public class JLFTransferConfig {

	private final String charset = "UTF-8"; // 默认编码

	private final Integer connTimeOut = 8000; // 默认连接超时时间

	private final Integer readConnTimeOut = 80000000; // 默认读取超时时间

	/**
	 * 
	 * @Title: getCharset
	 * @Description:获取编码,可被子类覆盖
	 * @return
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * 
	 * @Title: getConntimeout
	 * @Description:获取连接超时时间,可被子类覆盖
	 * @return
	 */
	public Integer getConntimeout() {
		return connTimeOut;
	}

	/**
	 * 
	 * @Title: getReadconntimeout
	 * @Description:获取读取超时时间,可被子类覆盖
	 * @return
	 */
	public Integer getReadconntimeout() {
		return readConnTimeOut;
	}

}
