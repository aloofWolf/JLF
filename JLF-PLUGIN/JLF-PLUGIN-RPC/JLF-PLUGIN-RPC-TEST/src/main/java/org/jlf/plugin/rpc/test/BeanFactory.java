package org.jlf.plugin.rpc.test;

import org.jlf.plugin.rpc.test.api.Api1;
import org.jlf.plugin.rpc.test.api.Api2;
import org.jlf.plugin.rpc.test.api.Api3;
import org.jlf.plugin.rpc.test.impl.Impl1;
import org.jlf.plugin.rpc.test.impl.Impl2;
import org.jlf.plugin.rpc.test.impl.Impl3;
import org.jlf.plugin.rpc.user.api.JLFRpcBeanFactory;

/**
 * 
 * @ClassName: BeanFactory
 * @Description: BeanFactory
 * @author Lone Wolf
 * @date 2019Äê10ÔÂ27ÈÕ
 */
public class BeanFactory implements JLFRpcBeanFactory {

	@SuppressWarnings("unchecked")
	@Override
	public <API, IMPL extends API> IMPL getImpl(Class<API> cls) {
		if (cls.equals(Api1.class)) {
			return (IMPL) new Impl1();
		} else if (cls.equals(Api2.class)) {
			return (IMPL) new Impl2();
		} else if (cls.equals(Api3.class)) {
			return (IMPL) new Impl3();
		}
		return null;
	}

}
