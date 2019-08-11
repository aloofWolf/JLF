package org.jlf.soa.mvc.container.generate;

import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: JLFMVCBeanGenerateReflect
 * @Description: bean������Ĭ��ʵ��,���÷�������
 * @author Lone Wolf
 * @date 2019��8��11��
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
