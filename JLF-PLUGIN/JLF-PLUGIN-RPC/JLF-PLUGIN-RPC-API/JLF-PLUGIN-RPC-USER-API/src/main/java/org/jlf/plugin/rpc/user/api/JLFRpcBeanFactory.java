package org.jlf.plugin.rpc.user.api;

/**
 * 
 * @ClassName: JLFRpcBeanFactory
 * @Description: JLFRpcBeanFactory
 * @author Lone Wolf
 * @date 2019年10月27日
 */
public interface JLFRpcBeanFactory {

	/**
	 * 
	 * @Title: getImpl
	 * @Description: 根据接口class获取实现类对象
	 * @param cls
	 * @return
	 */
	public <API, IMPL extends API> IMPL getImpl(Class<API> cls);

}
