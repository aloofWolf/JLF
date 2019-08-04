package org.jlf.plugin.push.user.api.channel;

import java.util.Properties;

import org.jlf.plugin.push.user.api.JLFPushDatagramTool;
import org.jlf.plugin.push.user.api.JLFPushSignTool;
import org.jlf.plugin.push.user.api.config.JLFPushTransferConfig;

/**
 * 
 * @ClassName: JLFPushChannel
 * @Description:渠道接口
 * @author Lone Wolf
 * @date 2019年6月7日
 * @param <T>
 */
public interface JLFPushChannel<T extends JLFPushTransferConfig> {

	/**
	 * 
	 * @Title: getConfig
	 * @Description:获取渠道配置
	 * @return
	 */
	public abstract T getConfig();

	/**
	 * 
	 * @Title: getDatagramTool
	 * @Description:获取报文工具
	 * @return
	 */
	public abstract JLFPushDatagramTool getDatagramTool();

	/**
	 * 
	 * @Title: getSignTool
	 * @Description:获取签名工具
	 * @return
	 */
	public abstract JLFPushSignTool getSignTool();

	/**
	 * 
	 * @Title: initConfig
	 * @Description:初始化配置
	 * @param props
	 */
	public abstract void initConfig(Properties props);

}
