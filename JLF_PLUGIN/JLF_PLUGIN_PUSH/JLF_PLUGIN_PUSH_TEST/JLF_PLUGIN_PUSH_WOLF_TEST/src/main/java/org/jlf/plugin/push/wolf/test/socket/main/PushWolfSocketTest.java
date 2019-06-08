package org.jlf.plugin.push.wolf.test.socket.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.LogUtil;
import org.jlf.core.JLFCore;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.client.JLFProductClient;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.check.client.JLFCheckClient;
import org.jlf.plugin.check.wolf.server.CheckWolfServer;
import org.jlf.plugin.json.client.JLFJsonClient;
import org.jlf.plugin.json.fastjson.server.FastJsonServer;
import org.jlf.plugin.push.client.JLFPushClient;
import org.jlf.plugin.push.wolf.server.PushWolfServer;
import org.jlf.plugin.push.wolf.test.socket.metadata.Response;

public class PushWolfSocketTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		PushWolfSocketTest test = new PushWolfSocketTest();
		test.starts();
		for(int i = 0;i<1;i++){
			Thread t = new Thread(test.new SocketThread());
			t.start();
		}
		Thread.sleep(10000);
	}
	

	@Override
	protected List<JLFPluginClient<?>> getPluginClients() throws Exception {	
		List<JLFPluginClient<?>> plugins = new ArrayList<JLFPluginClient<?>>();
		plugins.add(new JLFCheckClient(new CheckWolfServer()));
		plugins.add(new JLFJsonClient(new FastJsonServer()));
		plugins.add(new JLFPushClient(new PushWolfServer()));
		return plugins;
	}

	@Override
	protected List<JLFProductClient<?>> getProductClients() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <SERVER extends JLFSoaServer> List<SERVER> getSoaServers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	class SocketThread implements Runnable {

		@Override
		public void run() {
			try{
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("ss", "11");
				params.put("aa", "22");
				Response resp = (Response) JLFPushClient.get().send("socket", "inter1", params);
				LogUtil.get().debug("resp={}",resp);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}

	}
}
