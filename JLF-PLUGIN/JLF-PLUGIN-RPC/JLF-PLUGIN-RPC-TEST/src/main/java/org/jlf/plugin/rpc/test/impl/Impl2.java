package org.jlf.plugin.rpc.test.impl;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.rpc.test.api.Api2;

/**
 * 
 * @ClassName: Impl2
 * @Description: ʵ��2
 * @author Lone Wolf
 * @date 2019��10��27��
 */
public class Impl2 implements Api2 {

	@Override
	public void print() {
		LogUtil.get().debug("Impl2.....");

	}
}
