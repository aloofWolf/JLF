package org.jlf.product.ops.wolf.server;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: OpsConfig
 * @Description:ops配置信息
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class OpsConfig {

	@JLFCheckAnn(desc = "主机编号")
	private String HostCode;

	public String getHostCode() {
		return HostCode;
	}

	public void setHostCode(String hostCode) {
		HostCode = hostCode;
	}

}
