package org.jlf.product.ops.server.api;

/**
 * 
 * @ClassName: JLFOpsExecute
 * @Description:JLFOpsExecuteApi
 * @author Lone Wolf
 * @date 2019��7��6��
 */
public interface JLFOpsExecute {

	/**
	 * 
	 * @Title: reStartPluginServer
	 * @Description: ����������������
	 * @param pluginServerClsName
	 */
	public void reStartPluginServer(String pluginServerClsName);

	/**
	 * 
	 * @Title: reStartProductServer
	 * @Description:����������Ʒ�����
	 * @param productServerClsName
	 */
	public void reStartProductServer(String productServerClsName);

	/**
	 * 
	 * @Title: reStartSoaServer
	 * @Description: ���������ܹ������
	 * @param soaServerClsName
	 */
	public void reStartSoaServer(String soaServerClsName);

}
