package jlf.web.config;


import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import springfox.documentation.service.*;
import java.util.List;

@Component
@Getter
@ConfigurationProperties(prefix = "jlf.swagger")
public class SwaggerConfig {

    private String groupName;
    private String title;
    private String description;
    private String version;
    private String author;
    private String authorUrl;
    private String authorEmail;
    private boolean enable;
    private List<String> authHeaders;


}
