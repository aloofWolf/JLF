package org.jlf.soa.mvc.service;

import org.jlf.plugin.client.aop.JLFAopClient;
import org.jlf.soa.mvc.container.generate.JLFMVCBeanGenerate;

/**
 * 
 * @ClassName: JLFMVCServiceGenerate
 * @Description:service������
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCServiceGenerate implements JLFMVCBeanGenerate{

	@Override
	public <T> T beanGenerate(Class<T> cls) {
		return JLFAopClient.get().getProxy(cls, new JLFMVCServiceAopDo());
	}
}
