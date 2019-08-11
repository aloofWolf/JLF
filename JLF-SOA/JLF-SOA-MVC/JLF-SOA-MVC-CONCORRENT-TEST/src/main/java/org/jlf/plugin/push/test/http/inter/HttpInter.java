package org.jlf.plugin.push.test.http.inter;

import org.jlf.plugin.push.server.api.JLFPushInterAnn;
import org.jlf.plugin.push.test.http.channel.HttpChannel;
import org.jlf.plugin.push.test.http.config.HttpConfig;
import org.jlf.plugin.push.test.http.metadata.HttpRequest;
import org.jlf.plugin.push.user.api.inter.JLFPushInter;

/**
 * 
 * @ClassName: HttpInter
 * @Description:HttpInter
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ11ÈÕ
 */
@JLFPushInterAnn(channelCode = "http", interCode = "httpInter")
public class HttpInter extends JLFPushInter<HttpRequest, HttpConfig, HttpChannel> {

	public HttpInter(HttpChannel channel) {
		super(channel);
	}

	@Override
	public Class<HttpRequest> getReqCls() {
		return HttpRequest.class;
	}

}
