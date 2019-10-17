package org.jlf.soa.server.mvc;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.PackageUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.plugin.client.check.JLFCheckClient;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;
import org.jlf.soa.mvc.container.ann.JLFMVCBean;
import org.jlf.soa.mvc.container.ann.JLFMVCBeanManager;
import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;
import org.jlf.soa.mvc.web.route.JLFMVCRouteManager;

/**
 * 
 * @ClassName: JLFMVCServer
 * @Description:JLFMVCServer
 * @author Lone Wolf
 * @date 2019年5月27日
 */
public class JLFMvcServer extends JLFSoaServer {

	/**
	 * 需要扫描JLFMVC框架的包
	 */
	private static final String JLF_BAEN_SCAN_PACKAGE = "org.jlf";

	/**
	 * beanManager的class
	 */
	private Class<?> beanManager = JLFMVCBeanManager.class;

	/**
	 * bean容器的class
	 */
	private Class<?> beanContainer = JLFMVCBeanContainer.class;

	/**
	 * 路由管理的class
	 */
	private Class<?> routeManager = JLFMVCRouteManager.class;

	/**
	 * 添加bean注解方法
	 */
	private Method addAnnMethod;

	/**
	 * 将bean放入容器方法
	 */
	private Method putBeanMethod;

	/**
	 * 解析路由类方法
	 */
	private Method parseRouteMethod;

	/**
	 * 需要被扫描的bean的注解
	 */
	Set<Class<? extends Annotation>> beanAnns;

	@Override
	public String getSoaName() {
		return "mvc";
	}

	@Override
	public void start() {
		try {
			Properties prop = getConfig().getPros();
			start(prop);
		} catch (Exception e) {
			throw new JLFException(e);
		}
	}

	@Override
	public void reStart() {
		try {
			Properties prop = getConfig(true).getPros();
			start(prop);
		} catch (Exception e) {
			throw new JLFException(e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void start(Properties prop) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Map<String, Object> map = new HashMap<String, Object>((Map) prop);
		JLFMVCConfig config = JLFCheckClient.get().check(map, JLFMVCConfig.class);
		initAllBeans(config.getBeanPackages());
	}

	/**
	 * 
	 * @Title: initAllBeans
	 * @Description:初始化所有已配置的package下的bean
	 * @param beanPackages
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private void initAllBeans(String beanPackages) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		/**
		 * 初始化需要的所有method
		 */
		addAnnMethod = beanManager.getDeclaredMethod("addAnn", Class.class);
		putBeanMethod = beanContainer.getDeclaredMethod("putBean", Class.class, JLFMVCBean.class);
		parseRouteMethod = routeManager.getDeclaredMethod("parseRoute", Class.class);

		/**
		 * 修改method的访问权限
		 */
		addAnnMethod.setAccessible(true);
		putBeanMethod.setAccessible(true);
		parseRouteMethod.setAccessible(true);

		/**
		 * 添加需要被扫描的bean的注解
		 */
		addAnnMethod.invoke(beanManager, JLFMVCRoute.class);
		addAnnMethod.invoke(beanManager, JLFMVCService.class);

		/**
		 * 获取需要被扫描的bean的注解
		 */
		beanAnns = JLFMVCBeanManager.getAnns();

		/**
		 * 遍历配置的package,初始化bean
		 */
		String[] beanPackageArr = beanPackages.split(",");
		for (String beanPackage : beanPackageArr) {
			initBeans(beanPackage);
		}

		/**
		 * 初始化JLFMVC包下的bean
		 */
		initBeans(JLF_BAEN_SCAN_PACKAGE);

		/**
		 * 将method的访问权限变为不可访问
		 */
		putBeanMethod.setAccessible(false);
		parseRouteMethod.setAccessible(false);
		addAnnMethod.setAccessible(false);
	}

	/**
	 * 
	 * @Title: initBeans
	 * @Description:初始化指定package下的bean
	 * @param beanPackage
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private void initBeans(String beanPackage)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<Class<?>> clss = PackageUtil.getPackageClss(beanPackage);
		for (Class<?> cls : clss) {

			/**
			 * cls为注解、抽象类、接口、注解不扫描
			 */
			if (cls.isAnnotation() || Modifier.isAbstract(cls.getModifiers())|| cls.isInterface() || cls.isEnum()) {
				continue;
			}

			/**
			 * 被JLFMVCBean注解标注饿cls进行初始化
			 */
			JLFMVCBean jJLFMVCBean = (JLFMVCBean) cls.getAnnotation(JLFMVCBean.class);
			if (jJLFMVCBean != null) {
				putBeanMethod.invoke(beanContainer, cls, jJLFMVCBean);
				continue;
			}

			/**
			 * 遍历需要被扫描的bean的注解,如果cls被其中一个注解标注,进行初始化
			 */
			Annotation beanAnnPer;
			for (Class<? extends Annotation> beanAnnCls : beanAnns) {
				beanAnnPer = cls.getAnnotation(beanAnnCls);
				if (beanAnnPer != null) {
					jJLFMVCBean = beanAnnCls.getAnnotation(JLFMVCBean.class);
					putBeanMethod.invoke(beanContainer, cls, jJLFMVCBean);
					break;
				}
			}

			/**
			 * 如果bean被JLFMVCRoute注解标注,需要解析此路由类
			 */
			JLFMVCRoute routeAnn = (JLFMVCRoute) cls.getAnnotation(JLFMVCRoute.class);
			if (routeAnn == null) {
				continue;
			}
			parseRouteMethod.invoke(routeManager, cls);
		}

	}

}
