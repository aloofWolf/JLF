package org.jlf.soa.mvc.service;

import org.jlf.plugin.client.aop.JLFAopClient;
import org.jlf.soa.mvc.container.generate.JLFMVCBeanGenerate;

/**
 * 
 * @ClassName: JLFMVCServiceGenerate
 * @Description:service生成器
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMVCServiceGenerate implements JLFMVCBeanGenerate{

	@Override
	public <T> T beanGenerate(Class<T> cls) {
		return JLFAopClient.get().getProxy(cls, new JLFMVCServiceAopDo());
	}
}
