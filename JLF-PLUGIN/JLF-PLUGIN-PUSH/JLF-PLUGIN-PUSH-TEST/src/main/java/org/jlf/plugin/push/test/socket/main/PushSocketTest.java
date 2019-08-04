package org.jlf.plugin.push.test.socket.main;

import java.util.HashMap;
import java.util.Map;

import org.jlf.common.util.LogUtil;
import org.jlf.core.JLFCore;
import org.jlf.plugin.client.push.JLFPushClient;
import org.jlf.plugin.push.test.socket.metadata.Response;

/**
 * 
    * @ClassName: PushWolfSocketTest
    * @Description:PushWolfSocket≤‚ ‘
    * @author Lone Wolf
    * @date 2019ƒÍ7‘¬5»’
 */
public class PushSocketTest extends JLFCore {

	public static void main(String[] args) throws Exception {
		PushSocketTest test = new PushSocketTest();
		JLFCore.starts();
		for(int i = 0;i<1;i++){
			Thread t = new Thread(test.new SocketThread());
			t.start();
		}
		Thread.sleep(10000);
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
