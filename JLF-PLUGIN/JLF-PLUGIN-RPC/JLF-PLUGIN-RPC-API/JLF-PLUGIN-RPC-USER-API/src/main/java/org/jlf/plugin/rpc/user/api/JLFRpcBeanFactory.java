package org.jlf.plugin.rpc.user.api;

/**
 * 
 * @ClassName: JLFRpcBeanFactory
 * @Description: JLFRpcBeanFactory
 * @author Lone Wolf
 * @date 2019��10��27��
 */
public interface JLFRpcBeanFactory {

	/**
	 * 
	 * @Title: getImpl
	 * @Description: ���ݽӿ�class��ȡʵ�������
	 * @param cls
	 * @return
	 */
	public <API, IMPL extends API> IMPL getImpl(Class<API> cls);

}
