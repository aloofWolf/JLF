package org.jlf.plugin.aop.test;

import org.jlf.common.util.LogUtil;

/**
 * 
 * @ClassName: TargetInstance
 * @Description:Ŀ��ʵ��
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class TargetInstance implements ITargetInstance{

	public void Test1(String str, String str2, String str3) {
		LogUtil.get().info("Test1��������ִ��");
	}

	public void Test2() {
		LogUtil.get().info("Test2��������ִ��");
	}

	public void Test3() {
		LogUtil.get().info("Test3��������ִ��");
	}

}
