package org.jlf.plugin.server.json.fastJson;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.json.server.api.JLFJsonFactory;
import org.jlf.plugin.server.core.json.fastJson.GsonJsonFactory;

/**
 * 
 * @ClassName: JsonFastJsonServer
 * @Description:FastJson�����
 * @author Lone Wolf
 * @date 2019��6��6��
 */
public class GsonServer extends JLFPluginServer<JLFJsonFactory> {

	@Override
	public JLFJsonFactory getServerApi() {
		return new GsonJsonFactory();
	}
}
