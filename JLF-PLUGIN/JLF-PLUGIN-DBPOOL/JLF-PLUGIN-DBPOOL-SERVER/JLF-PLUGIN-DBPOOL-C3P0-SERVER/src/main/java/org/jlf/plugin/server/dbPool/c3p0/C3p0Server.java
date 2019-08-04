package org.jlf.plugin.server.dbPool.c3p0;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jlf.common.util.IniUtil;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFClientNoInitExecption;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.plugin.check.server.api.JLFCheck;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.dbPool.server.api.JLFDbPool;
import org.jlf.plugin.server.core.dbPool.c3p0.C3p0Core;
import org.jlf.plugin.server.core.dbPool.c3p0.C3p0Pool;
import org.jlf.plugin.server.core.dbPool.c3p0.config.C3p0MainConfig;

/**
 * 
 * @ClassName: C3p0Server
 * @Description:DbPool服务端
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class C3p0Server extends JLFPluginServer<JLFDbPool> {

	private static final String configFileName = "c3p0.ini";

	@Override
	public JLFDbPool getServerApi() {
		return new C3p0Core();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initConfig() {
		JLFCheck ckeck = JLFCheckClient.get();
		if (ckeck == null) {
			throw new JLFClientNoInitExecption(JLFCheckClient.class);
		}
		IniUtil ini = new IniUtil(JLFConfig.getPluginConfigFilePath(configFileName));
		Properties prop = ini.getPros();
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		C3p0MainConfig config = ckeck.check(map, C3p0MainConfig.class);
		C3p0Pool.initMainDataSource(config);
	}

}
