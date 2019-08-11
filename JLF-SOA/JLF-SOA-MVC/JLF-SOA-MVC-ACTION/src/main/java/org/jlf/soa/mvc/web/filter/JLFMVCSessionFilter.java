package org.jlf.soa.mvc.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.jlf.common.util.LogUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.session.JLFSessionClient;
import org.jlf.plugin.session.user.api.JLFSessionBean;
import org.jlf.soa.mvc.metadata.threadLocal.JLFMVCThreadLocal;

/**
 * 
 * @ClassName: JLFMVCSessionFilter
 * @Description:session������
 * @author Lone Wolf
 * @date 2019��6��5��
 */

@WebFilter(filterName = "SessionFilter", urlPatterns = "/session")
public class JLFMVCSessionFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) {

	}

	/**
	 * @Title: paramsPackage
	 * @Description:��֤��½�Ƿ�ʱ
	 * @param request
	 */
	public void validateSession(ServletRequest request) {
		LogUtil.get().debug("JLFMVCSessionFilter��������ʼִ��.......");
		JLFSessionBean sessionBean = null;
		try {
			sessionBean = JLFSessionClient.get().validateToken((HttpServletRequest) request);

		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
		JLFMVCThreadLocal.setDbName(sessionBean.getDbName());
		LogUtil.get().debug("JLFMVCSessionFilter������ִ�н���.......");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		validateSession(request);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
