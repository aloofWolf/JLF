package org.jlf.plugin.server.core.rpc.dubbo.manager;

import org.jlf.plugin.rpc.server.api.JLFRpc;

/**
 * 
 * @ClassName: DubboCore
 * @Description: DubboCore
 * @author Lone Wolf
 * @date 2019��10��27��
 */
public class DubboCore implements JLFRpc {

	@SuppressWarnings("unchecked")
	@Override
	public <API, IMPL extends API> IMPL get(Class<API> apiCls) {
		return (IMPL) DubboManager.getInstance().getImpl(apiCls);
	}

}
