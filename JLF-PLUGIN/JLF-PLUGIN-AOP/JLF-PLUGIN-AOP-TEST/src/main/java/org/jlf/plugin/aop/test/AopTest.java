package org.jlf.plugin.aop.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.client.aop.JLFAopClient;

/**
 * 
 * @ClassName: AopTest
 * @Description:Aop测试类
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class AopTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		JLFCore.starts();
		MyThread t = new MyThread();
		t.start();
		t.join();
	}
}

class MyThread extends Thread{
	
	 @Override
	    public void run() {
		 ITargetInstance target = JLFAopClient.get().getProxy(TargetInstance.class, new AopDoTest());
			target.Test1("aa", "bb", "cc");
			target.Test2();
			target.Test3();
	    }
	
}


