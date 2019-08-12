package org.jlf.plugin.push.test.http.inter;

import org.jlf.plugin.push.server.api.JLFPushInterAnn;
import org.jlf.plugin.push.test.http.channel.HttpChannel;
import org.jlf.plugin.push.test.http.config.HttpConfig;
import org.jlf.plugin.push.test.http.metadata.HttpSaveRequest;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;

@JLFPushInterAnn(channelCode = "http", interCode = "httpSaveInter")
public class HttpSaveInter extends JLFPushInter<HttpSaveRequest, HttpConfig, HttpChannel> {

	public HttpSaveInter(HttpChannel channel) {
		super(channel);
	}

	@Override
	public Class<HttpSaveRequest> getReqCls() {
		return HttpSaveRequest.class;
	}
}
