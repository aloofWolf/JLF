package org.jlf.soa.mvc.metadata.request;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: JLFMVCIdAndVersionRequest
 * @Description:携带id和version的请求参数
 * @author Lone Wolf
 * @date 2019年6月1日
 */
public class JLFMVCIdAndVersionRequest {

	@JLFCheckAnn
	private Long id;
	@JLFCheckAnn
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
