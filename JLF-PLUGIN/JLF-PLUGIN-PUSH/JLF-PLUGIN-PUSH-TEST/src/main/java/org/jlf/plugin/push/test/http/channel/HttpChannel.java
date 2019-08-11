package org.jlf.plugin.push.test.http.channel;

import java.util.Properties;

import org.jlf.plugin.push.server.api.JLFPushChannelAnn;
import org.jlf.plugin.push.test.http.config.HttpConfig;
import org.jlf.plugin.push.test.http.tool.HttpDatagramTool;
import org.jlf.plugin.push.test.http.tool.HttpSignTool;
import org.jlf.plugin.push.user.api.JLFPushDatagramTool;
import org.jlf.plugin.push.user.api.JLFPushSignTool;
import org.jlf.plugin.push.user.api.channel.JLFPushChannel;

/**
 * 
 * @ClassName: HttpChannel
 * @Description: HttpChannel
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ11ÈÕ
 */
@JLFPushChannelAnn(channelCode = "http")
public class HttpChannel implements JLFPushChannel<HttpConfig> {

	private HttpConfig config;

	@Override
	public HttpConfig getConfig() {
		return this.config;
	}

	@Override
	public JLFPushDatagramTool getDatagramTool() {
		return new HttpDatagramTool();
	}

	@Override
	public JLFPushSignTool getSignTool() {
		return new HttpSignTool();
	}

	@Override
	public void initConfig(Properties props) {
		this.config = new HttpConfig(props.getProperty("hostName"), props.getProperty("url"));

	}

}
