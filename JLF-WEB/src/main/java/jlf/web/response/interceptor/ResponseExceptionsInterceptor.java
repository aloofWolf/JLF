package jlf.web.response.interceptor;

import jlf.web.exception.*;
import jlf.web.response.bean.ResponseBean;
import jlf.web.response.enums.ErrorCodeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName: ResponseExceptionsInterceptor
 * @Description: Response异常拦截器
 * @author Lone Wolf
 * @date 2019年9月10日
 */
@Slf4j
@RestControllerAdvice
public class ResponseExceptionsInterceptor {

	/**
	 * 
	 * @Title: bindException
	 * @Description: SESSION过期异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(SessionTimeOutException.class)
	public ResponseBean bindException(HttpServletRequest request, SessionTimeOutException ex) {
		print(request, ex);
		return ResponseBean.error(ErrorCodeType.SESSION_TIMEOUT_EXCEPTION, ex.getMessage());
	}

	/**
	 * 
	 * @Title: bindException
	 * @Description: 参数校验异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	public ResponseBean bindException(HttpServletRequest request, BindException ex) {
		print(request, ex);
		String fullMmessage = ex.getMessage();
		int begin = fullMmessage.lastIndexOf("[") + 1;
		int end = fullMmessage.length() - 1;
		String responseMessahe = ex.getMessage().substring(begin, end);
		return ResponseBean.error(ErrorCodeType.PARAM_VALIDATION_EXCEPTION, responseMessahe);
	}
	
	/**
	 * 
	 * @Title: paramValidationException
	 * @Description: 参数校验异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ParamValidationException.class)
	public ResponseBean paramValidationException(HttpServletRequest request, ParamValidationException ex) {
		print(request, ex);
		return ResponseBean.error(ErrorCodeType.PARAM_VALIDATION_EXCEPTION, ex.getMessage());
	}

	/**
	 * 
	 * @Title: PermissionValidationException
	 * @Description: 权限校验异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(PermissionValidationException.class)
	public ResponseBean PermissionValidationException(HttpServletRequest request, PermissionValidationException ex) {
		print(request, ex);
		return ResponseBean.error(ErrorCodeType.PARAM_VALIDATION_EXCEPTION, ex.getMessage());
	}

	/**
	 * 
	 * @Title: sqlExceptionnHandler
	 * @Description: 数据库异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(SqlException.class)
	public ResponseBean sqlExceptionnHandler(HttpServletRequest request, SqlException ex) {
		print(request, ex);
		return ResponseBean.error(ErrorCodeType.SYSTEM_EXCEPTION, "系统异常,请稍后重试");
	}

	/**
	 * 
	 * @Title: businessExceptionnHandler
	 * @Description: 业务异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	public ResponseBean businessExceptionnHandler(HttpServletRequest request, BusinessException ex) {
		print(request, ex);
		return ResponseBean.error(ErrorCodeType.BUSINESS_EXCEPTION, ex.getMessage());
	}

	/**
	 * 
	 * @Title: throwableExceptionHandler
	 * @Description: 系统异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	public ResponseBean throwableExceptionHandler(HttpServletRequest request, Exception ex) {
		print(request, ex);
		return ResponseBean.error(ErrorCodeType.SYSTEM_EXCEPTION, "系统异常,请稍后重试");
	}

	/**
	 * 
	 * @Title: print
	 * @Description: 打印堆栈信息
	 * @param request
	 * @param exception
	 */
	private void print(HttpServletRequest request, Exception exception) {
		// 换行符
		String lineSeparatorStr = System.getProperty("line.separator");
		StringBuilder exStr = new StringBuilder();
		StackTraceElement[] trace = exception.getStackTrace();
		// 获取堆栈信息并输出为打印的形式
		for (StackTraceElement s : trace) {
			exStr.append("\tat " + s + "\r\n");
		}
		// 打印error级别的堆栈日志
		log.error(
				"访问地址：" + request.getRequestURL() + ",请求方法：" + request.getMethod() + ",远程地址：" + request.getRemoteAddr()
						+ lineSeparatorStr + "错误堆栈信息如下:" + exception.toString() + lineSeparatorStr + exStr);
	}
}
