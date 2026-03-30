package jlf.web.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@ConfigurationProperties(prefix = "jlf.web")
public class WebConfig {

	private Long projectId = 1l; // 项目id

	private Integer sessionPeriod = 30; // session有效期
}
