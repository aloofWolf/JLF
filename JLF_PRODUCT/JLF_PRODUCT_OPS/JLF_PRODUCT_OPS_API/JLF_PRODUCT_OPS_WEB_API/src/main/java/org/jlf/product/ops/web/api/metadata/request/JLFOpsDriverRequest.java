package org.jlf.product.ops.web.api.metadata.request;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.request.JLFMVCRequest;

/**
 * 
 * @ClassName: JLFServerOpsRequest
 * @Description:JLFServerOpsRequest
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public class JLFOpsDriverRequest extends JLFMVCRequest {

	@JLFCheckAnn(maxLength = 50, desc = "�ͻ��˱��")
	private String clientCode;
	@JLFCheckAnn(maxLength = 50, desc = "����˱��")
	private String serverCode;

	public String getServerCode() {
		return serverCode;
	}

	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

}
