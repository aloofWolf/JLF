package org.jlf.plugin.rpc.test.impl;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.rpc.test.api.Api3;

/**
 * 
 * @ClassName: Impl3
 * @Description: ʵ��3
 * @author Lone Wolf
 * @date 2019��10��27��
 */
public class Impl3 implements Api3 {

	@Override
	public void print() {
		LogUtil.get().debug("Impl3.....");

	}

}
