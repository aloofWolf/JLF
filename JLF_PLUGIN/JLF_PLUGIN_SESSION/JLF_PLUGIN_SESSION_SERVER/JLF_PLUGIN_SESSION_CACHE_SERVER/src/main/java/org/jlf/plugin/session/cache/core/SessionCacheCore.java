package org.jlf.plugin.session.cache.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.cache.client.JLFCacheClient;
import org.jlf.plugin.session.server.api.JLFSession;
import org.jlf.plugin.session.user.api.JLFSessionBean;

/**
 * 
 * @ClassName: SessionCacheCore
 * @Description:SessionCacheCore
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class SessionCacheCore implements JLFSession {

	@Override
	public void createToken(String dbName, Long userId, JLFSessionBean sessionBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String TokenKey = String.format("%s_%s", dbName, userId);
		String lastToken = JLFCacheClient.get().getString(TokenKey);
		if (lastToken != null) {
			JLFCacheClient.get().delete(lastToken);
			JLFCacheClient.get().delete(TokenKey);
		}
		String newToken = request.getSession().getId();
		JLFCacheClient.get().save(TokenKey, newToken, SessionCacheBean.getConfig().getTimeOut());
		JLFCacheClient.get().save(newToken, sessionBean, SessionCacheBean.getConfig().getTimeOut());
		SessionCacheBean.setSessionBean(sessionBean);
		response.addHeader(JLFSession.TOKEN_CONSTANT, newToken);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends JLFSessionBean> T validateToken(HttpServletRequest request) throws Exception {
		String token = request.getHeader(JLFSession.TOKEN_CONSTANT);
		T sessionBean = JLFCacheClient.get().getObj(token,
				(Class<T>) SessionCacheBean.getConfig().getSessionBeanCls());
		if (sessionBean == null) {
			throw new JLFException("登录超时,请重新登录");
		}
		JLFCacheClient.get().setKeyPeriod(token, SessionCacheBean.getConfig().getTimeOut());
		SessionCacheBean.setSessionBean(sessionBean);
		return sessionBean;
	}

	@Override
	public void deleteToken(HttpServletRequest request) throws Exception {
		String token = request.getHeader(JLFSession.TOKEN_CONSTANT);
		JLFCacheClient.get().delete(token);
		SessionCacheBean.setSessionBean(null);

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends JLFSessionBean> T getSessionBean() throws Exception {
		return (T) SessionCacheBean.getSessionBean();
	}

}
