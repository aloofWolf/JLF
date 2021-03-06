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
 * @date 2019年5月31日
 */
public interface JLFSession extends JLFPluginServerApi {

	/**
	 * 返回给用户的token的key值
	 */
	public static final String TOKEN_CONSTANT = "TOKEN";

	public static final String PLUGIN_NAME = "session";

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
	 */
	public <T extends JLFSessionBean> void createToken(String dbName, Long userId, T sessionBean,
			HttpServletRequest request, HttpServletResponse response);;

	/**
	 * 
	 * @Title: validateToken
	 * @Description:校验token
	 * @param request
	 * @return
	 */
	public <T extends JLFSessionBean> T validateToken(HttpServletRequest request);

	/**
	 * 
	 * @Title: deleteToken
	 * @Description:删除token
	 * @param request
	 */
	public void deleteToken(HttpServletRequest request);

	/**
	 * 
	 * @Title: getSessionBean
	 * @Description:获取session中存储的bean信息
	 * @return
	 */
	public <T extends JLFSessionBean> T getSessionBean();

	/**
	 * 
	 * @Title: clearThreadLocal
	 * @Description:清空threadLocal变量,如果服务端没有使用threadLocal,可不用实现此方法
	 */
	public default void clearThreadLocal() {
	}

}
