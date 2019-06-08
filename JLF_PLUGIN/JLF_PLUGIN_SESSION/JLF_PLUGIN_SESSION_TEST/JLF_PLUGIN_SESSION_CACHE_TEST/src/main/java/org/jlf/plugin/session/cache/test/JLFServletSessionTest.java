package org.jlf.plugin.session.cache.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.aop.client.JLFSessionClient;

/**
 * 
 * @ClassName: JLFServletSessionTest
 * @Description:JLFSession测试
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class JLFServletSessionTest extends HttpServlet {

	private static final long serialVersionUID = 889050996999846622L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		String optype = request.getParameter("optype");
		if ("create".equals(optype)) {
			createToken(request, response);
		} else if ("validate".equals(optype)) {
			validate(request);
		} else if ("delete".equals(optype)) {
			delete(request);
		}

	}

	/**
	 * 
	 * @Title: createToken
	 * @Description:创建token测试
	 * @param request
	 * @param response
	 */
	private void createToken(HttpServletRequest request, HttpServletResponse response) {
		Long userId = Long.parseLong(request.getParameter("userId"));
		String dbName = request.getParameter("dbName");
		LogUtil.get().debug("userId={}", userId);
		LogUtil.get().debug("dbName={}", dbName);
		SessionBean bean = new SessionBean();
		bean.setUserId(userId);
		bean.setDbName(dbName);
		bean.setUserName("你是谁");
		bean.setDeptId(2l);
		bean.setPostId(3l);
		try {
			JLFSessionClient.get().createToken(dbName, userId, bean, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: validate
	 * @Description:校验token并取出sessionBean测试
	 * @param request
	 */
	private void validate(HttpServletRequest request) {
		try {
			JLFSessionClient.get().validateToken(request);
			LogUtil.get().debug("校验成功");
			SessionBean bean = JLFSessionClient.get().getSessionBean();
			LogUtil.get().debug("bean={}", bean.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.get().debug("校验失败");
		}

	}

	/**
	 * 
	 * @Title: delete
	 * @Description:删除token测试
	 * @param request
	 */
	public void delete(HttpServletRequest request) {
		try {
			JLFSessionClient.get().deleteToken(request);
			LogUtil.get().debug("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.get().debug("删除失败");
		}
	}

}
