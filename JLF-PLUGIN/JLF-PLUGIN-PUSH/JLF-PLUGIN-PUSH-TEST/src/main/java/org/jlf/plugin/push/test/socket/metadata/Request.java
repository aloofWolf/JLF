package org.jlf.plugin.push.test.socket.metadata;

import org.jlf.plugin.push.user.api.metadata.JLFPushRequest;

/**
 * 
 * @ClassName: Request
 * @Description:请求参数
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class Request extends JLFPushRequest {

	private String ss;
	private String aa;

	public String getSs() {
		return ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

}
