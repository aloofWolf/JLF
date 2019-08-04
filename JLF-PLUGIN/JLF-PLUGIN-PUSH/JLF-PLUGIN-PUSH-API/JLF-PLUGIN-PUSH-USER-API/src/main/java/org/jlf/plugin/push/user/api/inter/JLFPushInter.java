package org.jlf.plugin.push.user.api.inter;

import org.jlf.plugin.push.user.api.JLFPushDatagramTool;
import org.jlf.plugin.push.user.api.JLFPushSendTool;
import org.jlf.plugin.push.user.api.JLFPushSignTool;
import org.jlf.plugin.push.user.api.channel.JLFPushChannel;
import org.jlf.plugin.push.user.api.config.JLFPushTransferConfig;
import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: JLFPushInter
 * @Description:接口信息
 * @author Lone Wolf
 * @date 2019年6月7日
 * @param <REQ>
 * @param <CONFIG>
 * @param <CHANNEL>
 */
public abstract class JLFPushInter<REQ extends JLFPushRequest, CONFIG extends JLFPushTransferConfig, CHANNEL extends JLFPushChannel<CONFIG>> {

	private CHANNEL channel; // 渠道信息

	/**
	 * 
	 * 创建一个新的实例 JLFInter.
	 *
	 * @param channel
	 */
	public JLFPushInter(CHANNEL channel) {
		this.channel = channel;
	}

	/**
	 * 
	 * @Title: getReqCls
	 * @Description:获取参数bean的class类型
	 * @return
	 */
	public abstract Class<REQ> getReqCls();

	/**
	 * 
	 * @Title: getConfig
	 * @Description:获取传输配置,默认返回渠道的配置,如果每个接口有不同配置,可以子类覆盖此方法 如果对于同一个接口,
	 *                                                     每一次请求都有不同的配置,
	 *                                                     例如http的url需要根据每一次请求的具体参数拼接
	 *                                                     所以在此方法中传了请求参数req对象
	 * @return
	 */
	public CONFIG getConfig(REQ req) {
		return channel.getConfig();
	}

	/**
	 * 
	 * @Title: getDatagramTool
	 * @Description:获取报文工具,默认返回渠道的报文工具,可被子类覆盖
	 * @return
	 */
	public JLFPushDatagramTool getDatagramTool() {
		return channel.getDatagramTool();
	}

	/**
	 * 
	 * @Title: getSignTool
	 * @Description:获取签名工具,默认返回渠道的签名工具,可被子类覆盖
	 * @return
	 */
	public JLFPushSignTool getSignTool() {
		return channel.getSignTool();
	}

	/**
	 * 
	 * @Title: getSendTool
	 * @Description:获取发送工具,默认返回null,如果此方法不返回null,则采用此发送工具发送数据,否则采用http或socket发
	 * @return
	 */
	public JLFPushSendTool getSendTool() {
		return null;
	}

}
