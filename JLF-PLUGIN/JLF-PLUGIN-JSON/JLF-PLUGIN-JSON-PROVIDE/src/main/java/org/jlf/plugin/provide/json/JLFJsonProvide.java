package org.jlf.plugin.provide.json;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.json.server.api.JLFJsonFactory;
import org.jlf.plugin.server.json.fastJson.FastJsonServer;

/**
 * 
 * @ClassName: JLFJsonProvide
 * @Description:JLFJsonProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFJsonProvide implements JLFPluginProvide<JLFJsonFactory> {

	@Override
	public Class<? extends JLFPluginServer<JLFJsonFactory>> getDefaultServer() {
		return FastJsonServer.class;
	}

}
