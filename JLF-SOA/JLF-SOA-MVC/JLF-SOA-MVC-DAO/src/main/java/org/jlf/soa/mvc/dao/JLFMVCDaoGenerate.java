package org.jlf.soa.mvc.dao;

import org.jlf.core.exception.JLFException;
import org.jlf.soa.mvc.container.generate.JLFMVCBeanGenerate;

/**
 * 
 * @ClassName: JLFMVCDaoGenerate
 * @Description:dao������
 * @author Lone Wolf
 * @date 2019��5��27��
 */
public class JLFMVCDaoGenerate implements JLFMVCBeanGenerate {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T beanGenerate(Class<T> cls) {
		JLFMVCDao<?> dao;
		try {
			dao = (JLFMVCDao<?>) cls.newInstance();
			dao.init();
			return (T) dao;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}
}