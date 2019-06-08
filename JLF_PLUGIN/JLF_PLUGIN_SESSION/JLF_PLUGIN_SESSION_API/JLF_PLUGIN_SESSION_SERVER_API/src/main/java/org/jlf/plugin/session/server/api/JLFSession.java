package org.jlf.plugin.session.server.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.core.api.JLFIPlugin;
import org.jlf.plugin.session.user.api.JLFSessionBean;

/**
 * 
 * @ClassName: JLFSession
 * @Description:SessionApi
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFSession extends JLFIPlugin {

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
	 * @throws Exception
	 */
	public <T extends JLFSessionBean> void createToken(String dbName, Long userId, T sessionBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception;;

	/**
	 * 
	 * @Title: validateToken
	 * @Description:У��token
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public <T extends JLFSessionBean> T validateToken(HttpServletRequest request) throws Exception;

	/**
	 * 
	 * @Title: deleteToken
	 * @Description:ɾ��token
	 * @param request
	 * @throws Exception
	 */
	public void deleteToken(HttpServletRequest request) throws Exception;

	/**
	 * 
	 * @Title: getSessionBean
	 * @Description:��ȡsession�д洢��bean��Ϣ
	 * @return
	 * @throws Exception
	 */
	public <T extends JLFSessionBean> T getSessionBean() throws Exception;

}
