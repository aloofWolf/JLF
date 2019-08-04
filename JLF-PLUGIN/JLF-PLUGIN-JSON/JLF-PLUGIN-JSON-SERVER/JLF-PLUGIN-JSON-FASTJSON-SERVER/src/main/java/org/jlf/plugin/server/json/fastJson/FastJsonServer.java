package org.jlf.plugin.server.json.fastJson;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.json.server.api.JLFJsonFactory;
import org.jlf.plugin.server.core.json.fastJson.FastJsonFactory;

/**
 * 
 * @ClassName: JsonFastJsonServer
 * @Description:FastJson服务端
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class FastJsonServer extends JLFPluginServer<JLFJsonFactory> {

	@Override
	public JLFJsonFactory getServerApi() {
		return new FastJsonFactory();
	}
}
