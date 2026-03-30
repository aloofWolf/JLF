package jlf.web.log.filter;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 
 * @ClassName: RequestFilter
 * @Description: 记录请求日志的过滤器
 * @author Lone Wolf
 * @date 2019年9月110日
 */
@RestControllerAdvice
public class RequestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String contentType = servletRequest.getContentType();
		String method = "multipart/form-data";
		if("POST".equals(request.getMethod()) && !contentType.contains(method)){
			filterChain.doFilter(new RequestWrapper(request), servletResponse);
		}else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

}
