package org.jlf.plugin.rpc.test;

import org.jlf.core.JLFCore;
import org.jlf.plugin.client.rpc.JLFRpcClient;
import org.jlf.plugin.rpc.test.api.Api1;
import org.jlf.plugin.rpc.test.api.Api2;
import org.jlf.plugin.rpc.test.api.Api3;

/**
 * 
 * @ClassName: RpcTest
 * @Description: RpcTest
 * @author Lone Wolf
 * @date 2019Äê10ÔÂ27ÈÕ
 */
public class RpcTest {

	public static void main(String[] args) throws InterruptedException {
		JLFCore.starts();
		Thread.sleep(5000);
		JLFRpcClient.get().get(Api1.class).print();
		JLFRpcClient.get().get(Api2.class).print();
		JLFRpcClient.get().get(Api3.class).print();
	}
}
