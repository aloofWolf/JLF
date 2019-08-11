package org.jlf.soa.server.mvc;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: JLFMVCConfig
 * @Description:JLFMVCConfig
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class JLFMVCConfig {

	@JLFCheckAnn(desc = "bean扫描包")
	private String beanPackages;// bean扫描包,多个包之间以“,分隔”

	public String getBeanPackages() {
		return beanPackages;
	}

	public void setBeanPackages(String beanPackages) {
		this.beanPackages = beanPackages;
	}

}
