package jlf.plus.async.threadPool;

import jlf.plus.async.config.AsyncConfig;
import jlf.plus.async.config.AsyncItemConfig;
import jlf.plus.async.enums.BooleanType;
import jlf.plus.async.enums.ThreadPoolRejectedExecutionHandlerEnum;
import jlf.plus.enums.EnumPlus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
@Slf4j
public class AsyncThreadPool {
	
	@Autowired
	private AsyncConfig config;

	@Autowired
	public ConfigurableListableBeanFactory beanFactory;

	@PostConstruct
	public void init(){
		for(AsyncItemConfig item : config.getItems()){
			ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
			t.setCorePoolSize(item.getCorePoolSize());
			t.setMaxPoolSize(item.getMaxPoolSize());
			t.setQueueCapacity(item.getQueueCapacity());
			t.setKeepAliveSeconds(item.getKeepAliveSeconds());
			t.setWaitForTasksToCompleteOnShutdown(EnumPlus.getByID(BooleanType.class, item.getWaitForTasksToCompleteOnShutdown()).isFlag());
			t.setThreadNamePrefix("baseThread-"+item.getThreadNamePrefix());
			t.setRejectedExecutionHandler(EnumPlus.getByID(ThreadPoolRejectedExecutionHandlerEnum.class, item.getRejectedExecutionHandler()).getHandler());
			t.initialize();
			beanFactory.registerSingleton(item.getName(), t);
		}
	}

}
