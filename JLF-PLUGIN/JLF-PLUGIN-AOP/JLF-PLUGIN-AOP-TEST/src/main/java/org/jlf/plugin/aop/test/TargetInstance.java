package org.jlf.plugin.aop.test;

import org.jlf.common.util.LogUtil;

/**
 * 
 * @ClassName: TargetInstance
 * @Description:目标实例
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class TargetInstance implements ITargetInstance{

	public void Test1(String str, String str2, String str3) {
		LogUtil.get().info("Test1方法正在执行");
	}

	public void Test2() {
		LogUtil.get().info("Test2方法正在执行");
	}

	public void Test3() {
		LogUtil.get().info("Test3方法正在执行");
	}

}
