package org.jlf.plugin.server.core.session.cache;

import org.jlf.plugin.server.core.session.cache.config.SessionCacheConfig;
import org.jlf.plugin.session.user.api.JLFSessionBean;

/**
 * 
 * @ClassName: SessionCacheBean
 * @Description:SessionCacheBean
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class SessionCacheBean {

	private static SessionCacheConfig config; // ������Ϣ
	private static InheritableThreadLocal<JLFSessionBean> sessionBean = new InheritableThreadLocal<JLFSessionBean>();// ��ǰsession�����ʵ��

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
