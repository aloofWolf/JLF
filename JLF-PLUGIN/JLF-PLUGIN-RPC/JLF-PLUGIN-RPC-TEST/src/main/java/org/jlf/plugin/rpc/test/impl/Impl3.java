package org.jlf.plugin.rpc.test.impl;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.rpc.test.api.Api3;

/**
 * 
 * @ClassName: Impl3
 * @Description: 实现3
 * @author Lone Wolf
 * @date 2019年10月27日
 */
public class Impl3 implements Api3 {

	@Override
	public void print() {
		LogUtil.get().debug("Impl3.....");

	}

}
