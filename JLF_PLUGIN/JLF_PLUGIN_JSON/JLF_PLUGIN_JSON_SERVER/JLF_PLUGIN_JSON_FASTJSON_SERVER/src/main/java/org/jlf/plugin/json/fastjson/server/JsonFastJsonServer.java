package org.jlf.plugin.json.fastJson.server;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.json.fastJson.server.core.FastJsonFactory;
import org.jlf.plugin.json.server.api.JLFJsonFactory;

/**
 * 
 * @ClassName: JsonFastJsonServer
 * @Description:FastJson服务端
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class JsonFastJsonServer extends JLFPluginServer<JLFJsonFactory> {

	@Override
	public JLFJsonFactory getServerApi() {
		return new FastJsonFactory();
	}
}
