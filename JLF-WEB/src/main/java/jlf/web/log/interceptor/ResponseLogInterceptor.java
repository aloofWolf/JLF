package jlf.web.log.interceptor;

import jlf.plus.threadLocal.ThreadLocalPlus;
import jlf.web.log.bean.RequestLog;
import jlf.web.log.service.RequestLogService;
import jlf.web.response.bean.ResponseBean;
import jlf.web.session.bean.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Date;

/**
 * 
 * @ClassName: ResponseLogInterceptor
 * @Description: response拦截器
 * @author Lone Wolf
 * @date 2019年9月10日
 */
@Slf4j
@RestControllerAdvice
@Order(2)
public class ResponseLogInterceptor implements ResponseBodyAdvice<Object> {

	@Autowired
    private RequestLogService requestLogService;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	/**
	 * 打印并记录请求日志
	 */
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		RequestLog requestLog = ThreadLocalPlus.get("requestLog");
		UserSession<?> session = ThreadLocalPlus.get("userSession");
		Date endTime = new Date();
		ResponseBean responseData = (ResponseBean) body;
		log.info("响应报文:{}", body);
		requestLogService.saveRequestLog(responseData, endTime,requestLog,session);
		return body;
	}

}
