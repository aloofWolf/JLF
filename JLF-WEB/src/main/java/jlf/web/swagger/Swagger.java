package jlf.web.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.Api;
import jlf.web.config.SwaggerConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@EnableConfigurationProperties(SwaggerConfig.class)
@ConditionalOnClass({Docket.class, ApiInfo.class})
@ConditionalOnProperty(prefix = "swagger", value = "enable", matchIfMissing = false)
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Slf4j
public class Swagger {

    @Autowired
    private SwaggerConfig swaggerConfig;

    @Bean
    public ApplicationListener createPrintConfig() {
        return (ApplicationListener<WebServerInitializedEvent>) event -> {
            try {
                // 获取IP
                String hostAddress = Inet4Address.getLocalHost().getHostAddress();
                // 获取端口号
                int port = event.getWebServer().getPort();
                // 获取应用名
                String applicationName = event.getApplicationContext().getApplicationName();
                // 打印 swagger 文档地址
                log.info("项目启动启动成功！swagger 接口文档地址: http://" + hostAddress + ":" + port + applicationName + "/doc.html");
            } catch (UnknownHostException e) {
                log.error(e.getMessage(), e);
            }
        };
    }

    // 配置静态资源
    @Bean
    public WebMvcConfigurer configResource() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
                registry.addResourceHandler("swagger-ui.html")
                        .addResourceLocations("classpath:/META-INF/resources/");
                registry.addResourceHandler("/webjars/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/");
                registry.addResourceHandler("doc.html")
                        .addResourceLocations("classpath:/META-INF/resources/");
            }
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerConfig.getGroupName())
                .apiInfo(apiInfo())
                .select()
                //  加了api注解Controller
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .enable(swaggerConfig.isEnable())
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 接口文档头
                .title(swaggerConfig.getTitle())
                // 接口文档描述
                .description(swaggerConfig.getDescription())
                // 服务器地址
                .termsOfServiceUrl(swaggerConfig.getAuthorUrl())
                .contact(new Contact(swaggerConfig.getAuthor(), swaggerConfig.getAuthorUrl(), swaggerConfig.getAuthorEmail()))
                // 项目版本号
                .version(swaggerConfig.getVersion())
                .build();
    }

    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeyList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(swaggerConfig.getAuthHeaders())) {
            swaggerConfig.getAuthHeaders().forEach(authHeader -> {
                apiKeyList.add(new ApiKey(authHeader, authHeader, "header"));
            });
        }
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        if (!CollectionUtils.isEmpty(swaggerConfig.getAuthHeaders())) {
            swaggerConfig.getAuthHeaders().forEach(authHeader ->
                    securityReferences.add(new SecurityReference(authHeader, authorizationScopes)));
        }
        return securityReferences;
    }
}
