package org.jlf.plugin.server.core.session.cache;

import org.jlf.plugin.server.core.session.cache.config.SessionCacheConfig;
import org.jlf.plugin.session.user.api.JLFSessionBean;

/**
 * 
 * @ClassName: SessionCacheBean
 * @Description:SessionCacheBean
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class SessionCacheBean {

	private static SessionCacheConfig config; // 配置信息
	private static InheritableThreadLocal<JLFSessionBean> sessionBean = new InheritableThreadLocal<JLFSessionBean>();// 当前session保存的实体

	public static JLFSessionBean getSessionBean() {
		return sessionBean.get();
	}

	public static void setSessionBean(JLFSessionBean value) {
		sessionBean.set(value);
	}

	public static SessionCacheConfig getConfig() {
		return config;
	}

	public static void setConfig(SessionCacheConfig config) {
		SessionCacheBean.config = config;
	}
	
	public static void clear(){
		sessionBean.remove();
	}

}
