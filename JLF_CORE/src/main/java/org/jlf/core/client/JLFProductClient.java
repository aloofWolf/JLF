package org.jlf.core.client;

import org.jlf.core.api.JLFIProduct;
import org.jlf.core.server.JLFProductServer;

/**
 * 
 * @ClassName: JLFProductClient
 * @Description:JLF产品客户端
 * @author Lone Wolf
 * @date 2019年6月3日
 * @param <API>
 */
public interface JLFProductClient<API extends JLFIProduct> {

	/**
	 * 
	 * @Title: getServer
	 * @Description:获取产品的绑定的server端
	 * @return
	 */
	public <SERVER extends JLFProductServer<API>> SERVER getServer();

}
