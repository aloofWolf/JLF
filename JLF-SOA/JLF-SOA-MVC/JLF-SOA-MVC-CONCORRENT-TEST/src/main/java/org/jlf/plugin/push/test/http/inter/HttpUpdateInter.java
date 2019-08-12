package org.jlf.plugin.push.test.http.inter;

import org.jlf.plugin.push.server.api.JLFPushInterAnn;
import org.jlf.plugin.push.test.http.channel.HttpChannel;
import org.jlf.plugin.push.test.http.config.HttpConfig;
import org.jlf.plugin.push.test.http.metadata.HttpUpdateRequest;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;

@JLFPushInterAnn(channelCode = "http", interCode = "httpUpdateInter")
public class HttpUpdateInter extends JLFPushInter<HttpUpdateRequest, HttpConfig, HttpChannel> {

	public HttpUpdateInter(HttpChannel channel) {
		super(channel);
	}

	@Override
	public Class<HttpUpdateRequest> getReqCls() {
		return HttpUpdateRequest.class;
	}
}