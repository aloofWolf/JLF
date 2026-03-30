package jlf.web.session.interceptor;

import jlf.web.session.bean.UserSession;
import jlf.web.session.core.SessionCore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: SessionInterceptor
 * @Description: session拦截器
 * @author Lone Wolf
 * @date 2019年9月10日
 */
@Component
@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

	@Autowired
	private SessionCore core;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UserSession<?> session = core.validateSession(request);
		log.info("session信息:{}", session.toString());
		return true;
	}
}