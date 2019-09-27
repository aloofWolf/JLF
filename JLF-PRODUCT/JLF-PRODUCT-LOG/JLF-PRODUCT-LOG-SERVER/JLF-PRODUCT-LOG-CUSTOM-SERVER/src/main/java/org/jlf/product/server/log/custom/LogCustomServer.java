package org.jlf.product.server.log.custom;

import org.jlf.core.server.JLFProductServer;
import org.jlf.product.log.server.api.JLFLog;
import org.jlf.product.server.core.log.custom.service.LogService;
import org.jlf.product.server.core.log.custom.service.TableManagerService;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;

/**
 * 
 * @ClassName: LogCustomServer
 * @Description: LogCustomServer
 * @author Lone Wolf
 * @date 2019Äê9ÔÂ24ÈÕ
 */
public class LogCustomServer extends JLFProductServer<JLFLog> {

	@Override
	public JLFLog getServerApi() {
		return JLFMVCBeanContainer.get(LogService.class);
	}

	@Override
	public void start() {
		TableManagerService tableManagerService = JLFMVCBeanContainer.get(TableManagerService.class);
		tableManagerService.startQuartz();
	}
	
	@Override
	public void reStart() {
		start();
	}

}
