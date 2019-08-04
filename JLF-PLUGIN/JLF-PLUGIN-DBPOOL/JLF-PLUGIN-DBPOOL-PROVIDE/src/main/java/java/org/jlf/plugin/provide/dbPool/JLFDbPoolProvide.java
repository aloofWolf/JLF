package java.org.jlf.plugin.provide.dbPool;

import org.jlf.core.provide.JLFPluginProvide;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.server.dbPool.c3p0.C3p0Server;

/**
 * 
 * @ClassName: JLFDbPoolProvide
 * @Description:JLFDbPoolProvide
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ3ÈÕ
 */
public class JLFDbPoolProvide implements JLFPluginProvide<JLFDbPool> {

	@Override
	public Class<? extends JLFPluginServer<JLFDbPool>> getDefaultServer() {
		return C3p0Server.class;
	}

}
