package org.jlf.plugin.push.test.socket.metadata;

import org.jlf.plugin.push.user.api.metadata.JLFPushResponse;

/**
 * 
 * @ClassName: Response
 * @Description:��Ӧ����
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class Response extends JLFPushResponse {

	private String qq;
	private String zz;

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getZz() {
		return zz;
	}

	public void setZz(String zz) {
		this.zz = zz;
	}

	@Override
	public String toString() {
		return "Response [qq=" + qq + ", zz=" + zz + "]";
	}

}
