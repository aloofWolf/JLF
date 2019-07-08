package org.jlf.product.ops.server.api;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;

/**
 * 
 * @ClassName: JLFOps
 * @Description:JLFOpsApi
 * @author Lone Wolf
 * @date 2019��7��4��
 */
public interface JLFOps extends JLFProductServerApi {

	/**
	 * 
	 * @Title: reLoadPluginConfigFile
	 * @Description:�����������¼��������ļ�
	 * @param clientCode
	 * @param serverCode
	 */
	public <SERVER_API extends JLFPluginServerApi> void reLoadPluginConfigFile(String clientCode, String serverCode);

	/**
	 * 
	 * @Title: reLoadProductConfigFile
	 * @Description:��Ʒ��������¼��������ļ�
	 * @param clientCode
	 * @param serverCode
	 */
	public <SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi> void reLoadProductConfigFile(
			String clientCode, String serverCode);

	/**
	 * 
	 * @Title: reLoadSoaConfigFile
	 * @Description:�ܹ���������¼��������ļ�
	 * @param serverCode
	 */
	public void reLoadSoaConfigFile(String serverCode);

}
