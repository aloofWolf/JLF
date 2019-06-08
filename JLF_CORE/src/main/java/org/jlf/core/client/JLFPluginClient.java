package org.jlf.core.client;

import org.jlf.core.api.JLFIPlugin;
import org.jlf.core.server.JLFPluginServer;

/**
 * 
 * @ClassName: JLFPluginClient
 * @Description:JLF����ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 * @param <API>
 */
public interface JLFPluginClient<API extends JLFIPlugin> {

	/**
	 * 
	 * @Title: getServer
	 * @Description:��ȡ����İ󶨵�server��
	 * @return
	 */
	public <SERVER extends JLFPluginServer<API>> SERVER getServer();

}
