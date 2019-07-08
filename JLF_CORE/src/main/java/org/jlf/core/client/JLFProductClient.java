package org.jlf.core.client;

import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;
import org.jlf.core.server.JLFProductServer;

/**
 * 
 * @ClassName: JLFProductClient
 * @Description:JLF��Ʒ�ͻ���
 * @author Lone Wolf
 * @date 2019��6��2��
 * @param <SERVER_API>
 * @param <WEB_API>
 */
public interface JLFProductClient<SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi> {

	/**
	 * 
	 * @Title: bindServer
	 * @Description:�󶨵�ǰ�ͻ��˵ķ����
	 * @param server
	 */
	public <SERVER extends JLFProductServer<SERVER_API, WEB_API>> void bindServer(SERVER server);

}
