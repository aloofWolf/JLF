package org.jlf.soa.mvc.metadata.request;

import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.soa.mvc.metadata.bean.JLFMVCBean;

/**
 * 
 * @ClassName: JLFMVCIdAndVersionRequest
 * @Description:携带id和version的请求参数
 * @author Lone Wolf
 * @date 2019年6月1日
 */
public final class JLFMVCIdAndVersionRequest extends JLFMVCRequest{

	@JLFCheckAnn
	private Long id;
	@JLFCheckAnn
	private Long version;

	/**
	 * 
	 * @Title: initBean
	 * @Description:初始化bean信息
	 * @param b
	 * @return
	 */
	public <B extends JLFMVCBean> B initBean(B b) {
		b.setId(id);
		b.setVersion(version);
		return b;
	}

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
