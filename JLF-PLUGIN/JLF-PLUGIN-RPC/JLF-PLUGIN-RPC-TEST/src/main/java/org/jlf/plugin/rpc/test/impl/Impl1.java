package org.jlf.plugin.rpc.test.impl;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.rpc.test.api.Api1;

/**
 * 
 * @ClassName: Impl1
 * @Description: ʵ��1
 * @author Lone Wolf
 * @date 2019��10��27��
 */
public class Impl1 implements Api1 {

	@Override
	public String print() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LogUtil.get().debug("Impl1.....");
		return "Impl1";

	}

}
