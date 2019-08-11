package org.jlf.core.provide;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.server.JLFPluginServer;

/**
 * 
 * @ClassName: JLFPluginProvide
 * @Description:��������ṩ�˽ӿ�
 * @author Lone Wolf
 * @date 2019��8��10��
 * @param <SERVER_API>
 */
public interface JLFPluginProvide<SERVER_API extends JLFPluginServerApi> {

	/**
	 * 
	 * @Title: getDefaultServer
	 * @Description:���Ĭ�ϰ󶨵ķ����
	 * @return
	 */
	public Class<? extends JLFPluginServer<SERVER_API>> getDefaultServer();

}
