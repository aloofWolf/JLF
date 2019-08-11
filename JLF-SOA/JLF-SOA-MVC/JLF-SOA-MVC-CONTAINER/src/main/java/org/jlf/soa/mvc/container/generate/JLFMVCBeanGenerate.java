package org.jlf.soa.mvc.container.generate;

/**
 * 
 * @ClassName: JLFMVCBeanGenerate
 * @Description: bean生成器接口
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public interface JLFMVCBeanGenerate {

	public <T> T beanGenerate(Class<T> cls);
}
