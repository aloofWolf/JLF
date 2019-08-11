package org.jlf.soa.mvc.container.generate;

import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: JLFMVCBeanGenerateReflect
 * @Description: bean生成器默认实现,利用反射生成
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class JLFMVCBeanGenerateReflect implements JLFMVCBeanGenerate {

	@Override
	public <T> T beanGenerate(Class<T> cls) {
		try {
			return cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

}
