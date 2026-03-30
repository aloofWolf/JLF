package jlf.web.interceptor;

import jlf.plus.threadLocal.ThreadLocalInterceptor;
import jlf.web.log.interceptor.RequestLogInterceptor;
import jlf.web.multipart.MultipartInterceptor;
import jlf.web.session.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: Interceptors
 * @Description: 拦截器
 * @author Lone Wolf
 * @date 2019年9月10日
 */
@Configuration
public class Interceptors extends WebMvcConfigurationSupport {

	@Autowired
	private SessionInterceptor sessionInterceptor;

	@Autowired
	private ThreadLocalInterceptor threadLocalInterceptor;

	@Autowired
	private RequestLogInterceptor requestLogInterceptor;
	
	@Autowired
	private MultipartInterceptor multipartInterceptor;


	/**
	 * 自定义转换器
	 */
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(multipartInterceptor);
	}

	/**
	 * 自定义拦截器
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		List<String> sessionInterceptorPatterns = new ArrayList<>();
		sessionInterceptorPatterns.add("/user/login");
		sessionInterceptorPatterns.add("/webjars/**");
		sessionInterceptorPatterns.add("/doc.html");
		sessionInterceptorPatterns.add("/swagger-resources/**");
		sessionInterceptorPatterns.add("/v2/api-docs-ext");
		registry.addInterceptor(threadLocalInterceptor).addPathPatterns("/**");
		registry.addInterceptor(requestLogInterceptor).addPathPatterns("/**");
		registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns(sessionInterceptorPatterns);
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/swagger-ui.html/swagger-resources/configuration/ui").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html/swagger-resources/configuration/ui");
		registry.addResourceHandler("/swagger-resources/configuration/security").addResourceLocations("classpath:/META-INF/resources/swagger-resources/configuration/security");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/swagger-resources").addResourceLocations("classpath:/META-INF/resources/swagger-resources");
		super.addResourceHandlers(registry);
    }


}
