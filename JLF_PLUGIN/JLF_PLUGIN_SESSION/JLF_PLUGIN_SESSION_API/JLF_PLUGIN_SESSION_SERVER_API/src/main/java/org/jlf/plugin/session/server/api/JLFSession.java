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
 * @date 2019年5月31日
 */
public interface JLFSession extends JLFIPlugin {

	/**
	 * 返回给用户的token的key值
	 */
	public static final String TOKEN_CONSTANT = "TOKEN";

	/**
	 * 
	 * @Title: createToken
	 * @Description:创建token,并将token写进response
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
	 * @Description:校验token
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public <T extends JLFSessionBean> T validateToken(HttpServletRequest request) throws Exception;

	/**
	 * 
	 * @Title: deleteToken
	 * @Description:删除token
	 * @param request
	 * @throws Exception
	 */
	public void deleteToken(HttpServletRequest request) throws Exception;

	/**
	 * 
	 * @Title: getSessionBean
	 * @Description:获取session中存储的bean信息
	 * @return
	 * @throws Exception
	 */
	public <T extends JLFSessionBean> T getSessionBean() throws Exception;

}
