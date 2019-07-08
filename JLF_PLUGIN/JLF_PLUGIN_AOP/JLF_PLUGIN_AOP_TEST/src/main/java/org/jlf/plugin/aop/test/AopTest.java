package org.jlf.plugin.aop.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.aop.client.JLFAopClient;

/**
 * 
 * @ClassName: AopTest
 * @Description:Aop������
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class AopTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		AopTest server = new AopTest();
		server.starts();
		TargetInstance target = JLFAopClient.get().getProxy(TargetInstance.class, new AopDoTest());
		target.Test1("aa", "bb", "cc");
		target.Test2();
		target.Test3();
	}


}
