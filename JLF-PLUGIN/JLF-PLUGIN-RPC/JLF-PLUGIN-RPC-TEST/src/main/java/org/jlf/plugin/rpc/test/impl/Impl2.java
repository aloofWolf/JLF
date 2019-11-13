package org.jlf.plugin.rpc.test.impl;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.rpc.test.api.Api2;

/**
 * 
 * @ClassName: Impl2
 * @Description: 实现2
 * @author Lone Wolf
 * @date 2019年10月27日
 */
public class Impl2 implements Api2 {

	@Override
	public String print() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LogUtil.get().debug("Impl2.....");
		return "Impl2";
	}
}
