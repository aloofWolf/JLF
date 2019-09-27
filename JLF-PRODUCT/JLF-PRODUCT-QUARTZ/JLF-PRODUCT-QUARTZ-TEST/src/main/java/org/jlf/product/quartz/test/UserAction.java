package org.jlf.product.quartz.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jlf.plugin.client.session.JLFSessionClient;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: JLFServletSessionTest
 * @Description:JLFSession测试
 * @author Lone Wolf
 * @date 2019年6月4日
 */
@JLFMVCRoute(name="user")
public class UserAction{

	public void login(UserLoginRequest req) throws Exception{
		SessionBean bean = new SessionBean();
		bean.setUserId(req.getUserId());
		bean.setDbName(req.getDbName());
		bean.setUserName("你是谁");
		bean.setDeptId(2l);
		bean.setPostId(3l);
		JLFSessionClient.get().createToken(req.getDbName(), req.getUserId(), bean, (HttpServletRequest)JLFMVCThreadLocal.getAsyncContext().getRequest(), (HttpServletResponse)JLFMVCThreadLocal.getAsyncContext().getResponse());
	}

}
