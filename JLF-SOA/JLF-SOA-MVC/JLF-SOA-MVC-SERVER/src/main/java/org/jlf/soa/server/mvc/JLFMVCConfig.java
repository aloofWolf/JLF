package org.jlf.soa.server.mvc;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: JLFMVCConfig
 * @Description:JLFMVCConfig
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class JLFMVCConfig {

	@JLFCheckAnn(desc = "beanɨ���")
	private String beanPackages;// beanɨ���,�����֮���ԡ�,�ָ���

	public String getBeanPackages() {
		return beanPackages;
	}

	public void setBeanPackages(String beanPackages) {
		this.beanPackages = beanPackages;
	}

}
