package org.jlf.plugin.server.core.rpc.dubbo.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jlf.common.util.IniContent;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.plugin.rpc.user.api.JLFRpcBeanFactory;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboApplicationConfig;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboBeanFactoryConfig;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboMethodArgumentConfig;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboMethodConfig;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboMonitorConfig;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboProtocolConfig;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboReferenceConfig;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboRegistryConfig;
import org.jlf.plugin.server.core.rpc.dubbo.config.DubboServiceConfig;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ArgumentConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

/**
 * 
 * @ClassName: DubboManager
 * @Description: DubboManager
 * @author Lone Wolf
 * @date 2019年10月27日
 */
public class DubboManager {

	private DubboManager() {
	}

	private static DubboManager INSTANCE = new DubboManager();

	public static DubboManager getInstance() {
		return INSTANCE;
	}

	private static final String applicationKey = "application";
	private static final String registryKey = "registry";
	private static final String protocolKey = "protocol";
	private static final String monitorKey = "monitor";
	private static final String serviceKey = "service";
	private static final String referenceKey = "reference";
	private static final String methodKey = "method";
	private static final String argumentKey = "argument";
	private static final String parametersKey = "parameters";
	private static final String beanFactoryKey = "beanFactory";

	private ApplicationConfig application;
	private RegistryConfig defaultRegistryConfig;
	private ProtocolConfig defaultProtocolConfig;
	private Map<String, RegistryConfig> registryConfigs = new HashMap<String, RegistryConfig>();
	private Map<String, ProtocolConfig> protocolConfigs = new HashMap<String, ProtocolConfig>();
	private MonitorConfig monitor;
	private List<ServiceConfig<?>> serviceConfigs = new ArrayList<ServiceConfig<?>>();
	private JLFRpcBeanFactory beanFactory;

	private Map<Class<?>, Object> references = new HashMap<Class<?>, Object>();

	/**
	 * 
	 * @Title: init
	 * @Description: 初始化
	 * @param content
	 */
	public void init(IniContent content) {
		publish(content);
		subscribe(content);
	}

	/**
	 * 
	 * @Title: publish
	 * @Description: 向注册中心发布
	 * @param content
	 */
	private void publish(IniContent content) {
		initApplication(content);
		initRegistry(content);
		initProtocol(content);
		initMonitor(content);
		initBeanFactory(content);
		initService(content);
		
		for(ServiceConfig<?> serviceConfig : serviceConfigs){
			serviceConfig.export();
		}

	}

	/**
	 * 
	 * @Title: subscribe
	 * @Description: 从注册中心订阅
	 * @param content
	 */
	private void subscribe(IniContent content) {
		initReference(content);
	}

	/**
	 * 
	 * @Title: initApplication
	 * @Description: 初始化pplication
	 * @param content
	 */
	private void initApplication(IniContent content) {
		IniContent applicationContent = content.getSection(applicationKey);
		if (applicationContent == null) {
			List<IniContent> applicationContents = content.getSectionArr(applicationKey);
			if (applicationContents != null) {
				throw new JLFException("dubbo 不能配置多个application");
			}
			throw new JLFException("dubbo 未配置application");
		}

		IniContent applicationParametersContent = applicationContent.getSection(parametersKey);
		if (applicationParametersContent != null) {
			applicationContent.getPros().put(parametersKey, applicationParametersContent.getPros());
		}
		DubboApplicationConfig dubboApplicationConfig = JLFCheckClient.get().check(applicationContent.getPros(),
				DubboApplicationConfig.class);
		this.application = dubboApplicationConfig.getApplication();
	}

	/**
	 * 
	 * @Title: initRegistry
	 * @Description: 初始化注册中心
	 * @param content
	 */
	private void initRegistry(IniContent content) {
		List<IniContent> registryContents = content.getSectionArr(registryKey);
		if (registryContents == null) {
			throw new JLFException("dubbo 未配置registry");
		}

		IniContent registryParametersContent = null;
		DubboRegistryConfig dubboRegistryConfig = null;
		String registryId = null;
		for (IniContent registryContent : registryContents) {
			registryParametersContent = registryContent.getSection(parametersKey);
			if (registryParametersContent != null) {
				registryContent.getPros().put(parametersKey, registryParametersContent.getPros());
			}
			dubboRegistryConfig = JLFCheckClient.get().check(registryContent.getPros(), DubboRegistryConfig.class);
			registryId = dubboRegistryConfig.getRegistryId();
			if (registryConfigs.containsKey(registryId)) {
				throw new JLFException("dubbo registryId重复:" + registryId);
			}
			if (defaultRegistryConfig == null) {
				defaultRegistryConfig = dubboRegistryConfig.getRegistry();
			}
			registryConfigs.put(registryId, dubboRegistryConfig.getRegistry());
		}
	}

	/**
	 * 
	 * @Title: initProtocol
	 * @Description: 初始化协议
	 * @param content
	 */
	private void initProtocol(IniContent content) {
		List<IniContent> protocolContents = content.getSectionArr(protocolKey);
		if (protocolContents == null) {
			throw new JLFException("dubbo 未配置protocol");
		}

		IniContent protocolParametersContent = null;
		DubboProtocolConfig dubboProtocolConfig = null;
		String protocolId = null;
		for (IniContent protocolContent : protocolContents) {
			protocolParametersContent = protocolContent.getSection(parametersKey);
			if (protocolParametersContent != null) {
				protocolContent.getPros().put(parametersKey, protocolParametersContent.getPros());
			}
			dubboProtocolConfig = JLFCheckClient.get().check(protocolContent.getPros(), DubboProtocolConfig.class);
			protocolId = dubboProtocolConfig.getProtocolId();
			if (registryConfigs.containsKey(protocolId)) {
				throw new JLFException("dubbo protocolId重复:" + protocolId);
			}
			if (defaultProtocolConfig == null) {
				defaultProtocolConfig = dubboProtocolConfig.getProtocol();
			}
			protocolConfigs.put(protocolId, dubboProtocolConfig.getProtocol());
		}
	}

	/**
	 * 
	 * @Title: initMonitor
	 * @Description: 初始化monitor
	 * @param content
	 */
	private void initMonitor(IniContent content) {
		IniContent monitorContent = content.getSection(monitorKey);
		if (monitorContent == null) {
			List<IniContent> monitorContents = content.getSectionArr(monitorKey);
			if (monitorContents != null) {
				throw new JLFException("dubbo 不能配置多个monitor");
			}
			return;
		}

		IniContent monitorParametersContent = monitorContent.getSection(parametersKey);
		if (monitorParametersContent != null) {
			monitorContent.getPros().put(parametersKey, monitorParametersContent.getPros());
		}
		DubboMonitorConfig dubboMonitorConfig = JLFCheckClient.get().check(monitorContent.getPros(),
				DubboMonitorConfig.class);
		monitor = dubboMonitorConfig.getMonitor();
	}

	/**
	 * 
	 * @Title: initBeanFactory
	 * @Description: 初始化beanFactory
	 * @param content
	 */
	private void initBeanFactory(IniContent content) {
		IniContent beanFactoryContent = content.getSection(beanFactoryKey);
		if (beanFactoryContent == null) {
			List<IniContent> beanFactoryContents = content.getSectionArr(beanFactoryKey);
			if (beanFactoryContents != null) {
				throw new JLFException("dubbo 不能配置多个beanFactory");
			}
			throw new JLFException("dubbo 未配置beanFactory");
		}
		DubboBeanFactoryConfig beanFactoryConfig = JLFCheckClient.get().check(beanFactoryContent.getPros(),
				DubboBeanFactoryConfig.class);
		Class<?> beanFactoryCls;
		try {
			beanFactoryCls = Class.forName(beanFactoryConfig.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new JLFException("未找到beanFactory接口 :" + beanFactoryConfig.getName());
		}

		if (!JLFRpcBeanFactory.class.isAssignableFrom(beanFactoryCls)) {
			throw new JLFException("beanFactory对象未实现JLFRpcBeanFactory接口 :" + beanFactoryConfig.getName());
		}

		try {
			this.beanFactory = (JLFRpcBeanFactory) beanFactoryCls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}
	}

	/**
	 * 
	 * @Title: initService
	 * @Description: 初始化service
	 * @param content
	 */
	@SuppressWarnings("unchecked")
	private <T> void initService(IniContent content) {
		List<IniContent> serviceContents = content.getSectionArr(serviceKey);
		if (serviceContents == null) {
			return;
		}
		DubboServiceConfig<T> dubboServiceConfig = null;
		for (IniContent serviceContent : serviceContents) {
			IniContent serviceParametersContent = serviceContent.getSection(parametersKey);
			if (serviceParametersContent != null) {
				serviceContent.getPros().put(parametersKey, serviceParametersContent.getPros());
			}
			dubboServiceConfig = JLFCheckClient.get().check(serviceContent.getPros(), DubboServiceConfig.class);
			ServiceConfig<T> serviceConfig = dubboServiceConfig.getService();
			List<IniContent> methodContents = serviceContent.getSectionArr(methodKey);
			if (methodContents != null) {
				List<MethodConfig> methodConfigList = initmethod(methodContents);
				serviceConfig.setMethods(methodConfigList);
			}

			T implObj = beanFactory.getImpl(serviceConfig.getInterfaceClass());
			if (implObj == null) {
				throw new JLFException("未从beanFactory中获取到接口" + serviceConfig.getInterface() + "的实现类对象");
			}
			serviceConfig.setRef(implObj);
			serviceConfig.setApplication(application);

			if (monitor != null) {
				serviceConfig.setMonitor(monitor);
			}

			List<String> registryIds = dubboServiceConfig.getRegistryId();
			if (registryIds == null) {
				serviceConfig.setRegistry(defaultRegistryConfig);
			} else {
				for (String registryId : registryIds) {
					RegistryConfig registryConfig = registryConfigs.get(registryId);
					if (registryConfig == null) {
						throw new JLFException("dubbo registryId:" + registryId + "未找到配置");
					}
					serviceConfig.setRegistry(registryConfig);
				}
			}

			List<String> protocolIds = dubboServiceConfig.getProtocolId();
			if (protocolIds == null) {
				serviceConfig.setProtocol(defaultProtocolConfig);
			} else {
				for (String protocolId : protocolIds) {
					ProtocolConfig protocolConfig = protocolConfigs.get(protocolId);
					if (protocolConfig == null) {
						throw new JLFException("dubbo protocolId:" + protocolId + "未找到配置");
					}
					serviceConfig.setProtocol(protocolConfig);
				}
			}
			serviceConfigs.add(serviceConfig);
		}
	}

	/**
	 * 
	 * @Title: initmethod
	 * @Description: 初始化method
	 * @param methodContents
	 * @return
	 */
	private List<MethodConfig> initmethod(List<IniContent> methodContents) {
		List<MethodConfig> methodConfigList = new ArrayList<MethodConfig>();
		DubboMethodConfig dubboMethodConfig = null;
		for (IniContent methodContent : methodContents) {
			IniContent methodParametersContent = methodContent.getSection(parametersKey);
			if (methodParametersContent != null) {
				methodContent.getPros().put(parametersKey, methodParametersContent.getPros());
			}
			dubboMethodConfig = JLFCheckClient.get().check(methodContent.getPros(), DubboMethodConfig.class);
			MethodConfig methodConfig = dubboMethodConfig.getMethod();
			List<IniContent> methodArgumentContents = methodContent.getSectionArr(argumentKey);
			if (methodArgumentContents != null) {
				List<ArgumentConfig> argumentConfigList = initServiceMethodArgument(methodArgumentContents);
				methodConfig.setArguments(argumentConfigList);
			}
			methodConfigList.add(methodConfig);
		}
		return methodConfigList;
	}

	/**
	 * 
	 * @Title: initServiceMethodArgument
	 * @Description: 初始化methodArgument
	 * @param methodArgumentContents
	 * @return
	 */
	private List<ArgumentConfig> initServiceMethodArgument(List<IniContent> methodArgumentContents) {
		List<ArgumentConfig> argumentConfigList = new ArrayList<ArgumentConfig>();
		DubboMethodArgumentConfig dubboMethodArgumentConfig = null;
		for (IniContent methodArgumentContent : methodArgumentContents) {
			dubboMethodArgumentConfig = JLFCheckClient.get().check(methodArgumentContent.getPros(),
					DubboMethodArgumentConfig.class);
			argumentConfigList.add(dubboMethodArgumentConfig.getMethodArgument());
		}
		return argumentConfigList;
	}

	/**
	 * 
	 * @Title: initReference
	 * @Description: 初始化reference
	 * @param content
	 */
	private void initReference(IniContent content) {
		List<IniContent> referenceContents = content.getSectionArr(referenceKey);
		if (referenceContents == null) {
			return;
		}
		DubboReferenceConfig<?> dubboReferenceConfig = null;
		for (IniContent referenceContent : referenceContents) {
			IniContent referenceParametersContent = referenceContent.getSection(parametersKey);
			if (referenceParametersContent != null) {
				referenceContent.getPros().put(parametersKey, referenceParametersContent.getPros());
			}
			dubboReferenceConfig = JLFCheckClient.get().check(referenceContent.getPros(), DubboReferenceConfig.class);
			ReferenceConfig<?> referencConfig = dubboReferenceConfig.getReference();
			List<IniContent> methodContents = referenceContent.getSectionArr(methodKey);
			if (methodContents != null) {
				List<MethodConfig> methodConfigList = initmethod(methodContents);
				referencConfig.setMethods(methodConfigList);
			}
			referencConfig.setApplication(application);
			referencConfig.setMonitor(monitor);

			List<String> registryIds = dubboReferenceConfig.getRegistryId();
			if (registryIds == null) {
				referencConfig.setRegistry(defaultRegistryConfig);
			} else {
				for (String registryId : registryIds) {
					RegistryConfig registryConfig = registryConfigs.get(registryId);
					if (registryConfig == null) {
						throw new JLFException("dubbo registryId:" + registryId + "未找到配置");
					}
					referencConfig.setRegistry(registryConfig);
				}
			}

			Class<?> api = referencConfig.getInterfaceClass();
			Object impl = referencConfig.get();
			references.put(api, impl);
		}
	}

	/**
	 * 
	 * @Title: getImpl
	 * @Description: 根据apiCls获取配置的实现类对象
	 * @param apiCls
	 * @return
	 */
	public Object getImpl(Class<?> apiCls) {
		return references.get(apiCls);
	}

}
