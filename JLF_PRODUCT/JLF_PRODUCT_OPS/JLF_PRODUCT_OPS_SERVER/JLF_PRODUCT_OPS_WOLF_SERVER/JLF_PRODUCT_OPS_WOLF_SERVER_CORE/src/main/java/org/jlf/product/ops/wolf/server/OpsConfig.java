package org.jlf.product.ops.wolf.server;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: OpsConfig
 * @Description:ops������Ϣ
 * @author Lone Wolf
 * @date 2019��7��5��
 */
public class OpsConfig {

	@JLFCheckAnn(desc = "�������")
	private String HostCode;

	public String getHostCode() {
		return HostCode;
	}

	public void setHostCode(String hostCode) {
		HostCode = hostCode;
	}

}
