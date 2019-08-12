package org.jlf.plugin.push.test.http.inter;

import org.jlf.plugin.push.server.api.JLFPushInterAnn;
import org.jlf.plugin.push.test.http.channel.HttpChannel;
import org.jlf.plugin.push.test.http.config.HttpConfig;
import org.jlf.plugin.push.test.http.metadata.HttpTransRequest;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;

@JLFPushInterAnn(channelCode = "http", interCode = "httpTransInter")
public class HttpTransInter extends JLFPushInter<HttpTransRequest, HttpConfig, HttpChannel> {

	public HttpTransInter(HttpChannel channel) {
		super(channel);
	}

	@Override
	public Class<HttpTransRequest> getReqCls() {
		return HttpTransRequest.class;
	}
}