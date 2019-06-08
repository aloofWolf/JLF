package org.jlf.plugin.session.cache.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.aop.client.JLFSessionClient;

/**
 * 
 * @ClassName: JLFServletSessionTest
 * @Description:JLFSession����
 * @author Lone Wolf
 * @date 2019��6��4��
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
	 * @Description:����token����
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
		bean.setUserName("����˭");
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
	 * @Description:У��token��ȡ��sessionBean����
	 * @param request
	 */
	private void validate(HttpServletRequest request) {
		try {
			JLFSessionClient.get().validateToken(request);
			LogUtil.get().debug("У��ɹ�");
			SessionBean bean = JLFSessionClient.get().getSessionBean();
			LogUtil.get().debug("bean={}", bean.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.get().debug("У��ʧ��");
		}

	}

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ��token����
	 * @param request
	 */
	public void delete(HttpServletRequest request) {
		try {
			JLFSessionClient.get().deleteToken(request);
			LogUtil.get().debug("ɾ���ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.get().debug("ɾ��ʧ��");
		}
	}

}
