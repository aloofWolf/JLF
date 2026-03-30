package jlf.plus.async.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 *
 * @ClassName: AsyncItemConfig
 * @Description: 异步配置
 * @author Lone Wolf
 * @date 2023年10月29日
 */
@Component
@Data
@ToString
public class AsyncItemConfig {
	
	private String name; 
	
	private Integer corePoolSize; 
	
	private Integer maxPoolSize; 
	
	private Integer queueCapacity; 

	private Integer keepAliveSeconds; 
	
	private String threadNamePrefix; 
	
	private Integer waitForTasksToCompleteOnShutdown;
	
	private Integer rejectedExecutionHandler; 

}
