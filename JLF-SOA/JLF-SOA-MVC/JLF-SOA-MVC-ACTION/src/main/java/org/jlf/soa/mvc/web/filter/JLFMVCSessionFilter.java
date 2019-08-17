package org.jlf.soa.mvc.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.jlf.common.util.LogUtil;
import org.jlf.plugin.client.session.JLFSessionClient;
import org.jlf.plugin.session.user.api.JLFSessionBean;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;

/**
 * 
 * @ClassName: JLFMVCSessionFilter
 * @Description:session过滤器
 * @author Lone Wolf
 * @date 2019年6月5日
 */

@WebFilter(filterName = "SessionFilter", urlPatterns = "/session")
public class JLFMVCSessionFilter extends JLFMVCFilter {


	/**
	 * 验证登陆是否超时
	 */
	@Override
	public void doFilterProcess(ServletRequest request, ServletResponse response, FilterChain chain) {
		LogUtil.get().debug("JLFMVCSessionFilter过滤器开始执行.......");
		JLFSessionBean sessionBean = null;
		sessionBean = JLFSessionClient.get().validateToken((HttpServletRequest) request);
		JLFMVCThreadLocal.setDbName(sessionBean.getDbName());
		LogUtil.get().debug("JLFMVCSessionFilter过滤器执行结束.......");
	}
}
