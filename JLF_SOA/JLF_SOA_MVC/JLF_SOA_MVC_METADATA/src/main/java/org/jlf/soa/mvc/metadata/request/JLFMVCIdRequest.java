package org.jlf.soa.mvc.metadata.request;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: JLFMVCIdRequest
 * @Description:携带id的请求参数
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public final class JLFMVCIdRequest extends JLFMVCRequest {

	@JLFCheckAnn
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
