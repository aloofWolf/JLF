package org.jlf.plugin.push.test.http.inter;

import org.jlf.plugin.push.server.api.JLFPushInterAnn;
import org.jlf.plugin.push.test.http.channel.HttpChannel;
import org.jlf.plugin.push.test.http.config.HttpConfig;
import org.jlf.plugin.push.test.http.metadata.HttpDeleteRequest;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;

@JLFPushInterAnn(channelCode = "http", interCode = "httpDeleteInter")
public class HttpDeleteInter extends JLFPushInter<HttpDeleteRequest, HttpConfig, HttpChannel> {

	public HttpDeleteInter(HttpChannel channel) {
		super(channel);
	}

	@Override
	public Class<HttpDeleteRequest> getReqCls() {
		return HttpDeleteRequest.class;
	}
}