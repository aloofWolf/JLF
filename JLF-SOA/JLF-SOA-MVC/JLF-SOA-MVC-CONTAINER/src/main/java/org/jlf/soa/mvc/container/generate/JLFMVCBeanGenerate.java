package org.jlf.soa.mvc.container.generate;

/**
 * 
 * @ClassName: JLFMVCBeanGenerate
 * @Description: bean�������ӿ�
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public interface JLFMVCBeanGenerate {

	public <T> T beanGenerate(Class<T> cls);
}
