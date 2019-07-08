package org.jlf.product.quartz.wolf.test;

import org.jlf.plugin.session.client.JLFSessionClient;
import org.jlf.soa.mvc.metadata.ann.JLFMVCRouteCls;

/**
 * 
 * @ClassName: JLFServletSessionTest
 * @Description:JLFSession����
 * @author Lone Wolf
 * @date 2019��6��4��
 */
@JLFMVCRouteCls(name="user")
public class UserAction{

	public void login(UserLoginRequest req) throws Exception{
		SessionBean bean = new SessionBean();
		bean.setUserId(req.getUserId());
		bean.setDbName(req.getDbName());
		bean.setUserName("����˭");
		bean.setDeptId(2l);
		bean.setPostId(3l);
		JLFSessionClient.get().createToken(req.getDbName(), req.getUserId(), bean, req.getRequest(), req.getResponse());
	}

}
