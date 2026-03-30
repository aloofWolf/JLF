package jlf.plus.async.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: AsyncConfig
 * @Description: 异步配置
 * @author Lone Wolf
 * @date 2023年10月29日
 */
@Component
@Data
@ConfigurationProperties(prefix = "jlf.asyncs")
public class AsyncConfig {
	
	private List<AsyncItemConfig> items = new ArrayList<>();

}
