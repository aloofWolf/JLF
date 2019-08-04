package org.jlf.core.client;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.server.JLFPluginServer;

/**
 * 
 * @ClassName: JLFPluginClient
 * @Description:JLF����ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 * @param <SERVER_API>
 */
public interface JLFPluginClient<SERVER_API extends JLFPluginServerApi> {

	/**
	 * 
	 * @Title: bindServer
	 * @Description:�󶨵�ǰ�ͻ��˵ķ����
	 * @param server
	 */
	public <SERVER extends JLFPluginServer<SERVER_API>> void bindServer(SERVER server);

}
