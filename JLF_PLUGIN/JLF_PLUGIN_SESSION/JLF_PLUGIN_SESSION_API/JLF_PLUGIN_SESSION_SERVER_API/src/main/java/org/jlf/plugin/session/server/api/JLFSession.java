package org.jlf.plugin.session.server.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.plugin.session.user.api.JLFSessionBean;

/**
 * 
 * @ClassName: JLFSession
 * @Description:SessionApi
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFSession extends JLFPluginServerApi {

	/**
	 * ���ظ��û���token��keyֵ
	 */
	public static final String TOKEN_CONSTANT = "TOKEN";

	/**
	 * 
	 * @Title: createToken
	 * @Description:����token,����tokenд��response
	 * @param dbName
	 * @param userId
	 * @param sessionBean
	 * @param request
	 * @param response
	 * @return
	 */
	public <T extends JLFSessionBean> void createToken(String dbName, Long userId, T sessionBean,
			HttpServletRequest request, HttpServletResponse response);;

	/**
	 * 
	 * @Title: validateToken
	 * @Description:У��token
	 * @param request
	 * @return
	 */
	public <T extends JLFSessionBean> T validateToken(HttpServletRequest request);

	/**
	 * 
	 * @Title: deleteToken
	 * @Description:ɾ��token
	 * @param request
	 */
	public void deleteToken(HttpServletRequest request);

	/**
	 * 
	 * @Title: getSessionBean
	 * @Description:��ȡsession�д洢��bean��Ϣ
	 * @return
	 */
	public <T extends JLFSessionBean> T getSessionBean();

}
