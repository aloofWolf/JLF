package org.jlf.product.ops.web.api;

import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: JLFOpsExecuteAction
 * @Description:JLFOpsExecuteActionApi
 * @author Lone Wolf
 * @date 2019��7��6��
 */
@JLFMVCRoute(name = "opsDriver")
public interface JLFOpsExecuteAction {

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
