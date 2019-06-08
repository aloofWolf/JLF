package org.jlf.soa.mvc.metadata.request;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: JLFMVCIdRequest
 * @Description:Я��id���������
 * @author Lone Wolf
 * @date 2019��5��31��
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
