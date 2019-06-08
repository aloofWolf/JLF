package org.jlf.plugin.json.fastjson.server;

import java.util.Set;

import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.json.fastjson.server.core.FastJsonFactory;
import org.jlf.plugin.json.server.api.JLFJsonFactory;

/**
 * 
 * @ClassName: FastJsonServer
 * @Description:FastJson服务端
 * @author Lone Wolf
 * @date 2019年6月6日
 */
public class FastJsonServer extends JLFPluginServer<JLFJsonFactory> {

	@Override
	public JLFJsonFactory get() {
		return new FastJsonFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getDepends() {
		return null;
	}

	@Override
	public void jStart() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void jStop() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void jreStart() throws Exception {
		// TODO Auto-generated method stub

	}

}
