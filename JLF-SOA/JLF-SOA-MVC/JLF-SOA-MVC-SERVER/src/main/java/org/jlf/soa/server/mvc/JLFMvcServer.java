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
 * @date 2019��5��27��
 */
public class JLFMvcServer extends JLFSoaServer {

	/**
	 * ��Ҫɨ��JLFMVC��ܵİ�
	 */
	private static final String JLF_BAEN_SCAN_PACKAGE = "org.jlf";

	/**
	 * beanManager��class
	 */
	private Class<?> beanManager = JLFMVCBeanManager.class;

	/**
	 * bean������class
	 */
	private Class<?> beanContainer = JLFMVCBeanContainer.class;

	/**
	 * ·�ɹ����class
	 */
	private Class<?> routeManager = JLFMVCRouteManager.class;

	/**
	 * ���beanע�ⷽ��
	 */
	private Method addAnnMethod;

	/**
	 * ��bean������������
	 */
	private Method putBeanMethod;

	/**
	 * ����·���෽��
	 */
	private Method parseRouteMethod;

	/**
	 * ��Ҫ��ɨ���bean��ע��
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
	 * @Description:��ʼ�����������õ�package�µ�bean
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
		 * ��ʼ����Ҫ������method
		 */
		addAnnMethod = beanManager.getDeclaredMethod("addAnn", Class.class);
		putBeanMethod = beanContainer.getDeclaredMethod("putBean", Class.class, JLFMVCBean.class);
		parseRouteMethod = routeManager.getDeclaredMethod("parseRoute", Class.class);

		/**
		 * �޸�method�ķ���Ȩ��
		 */
		addAnnMethod.setAccessible(true);
		putBeanMethod.setAccessible(true);
		parseRouteMethod.setAccessible(true);

		/**
		 * �����Ҫ��ɨ���bean��ע��
		 */
		addAnnMethod.invoke(beanManager, JLFMVCRoute.class);
		addAnnMethod.invoke(beanManager, JLFMVCService.class);

		/**
		 * ��ȡ��Ҫ��ɨ���bean��ע��
		 */
		beanAnns = JLFMVCBeanManager.getAnns();

		/**
		 * �������õ�package,��ʼ��bean
		 */
		String[] beanPackageArr = beanPackages.split(",");
		for (String beanPackage : beanPackageArr) {
			initBeans(beanPackage);
		}

		/**
		 * ��ʼ��JLFMVC���µ�bean
		 */
		initBeans(JLF_BAEN_SCAN_PACKAGE);

		/**
		 * ��method�ķ���Ȩ�ޱ�Ϊ���ɷ���
		 */
		putBeanMethod.setAccessible(false);
		parseRouteMethod.setAccessible(false);
		addAnnMethod.setAccessible(false);
	}

	/**
	 * 
	 * @Title: initBeans
	 * @Description:��ʼ��ָ��package�µ�bean
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
			 * clsΪע�⡢�����ࡢ�ӿڡ�ע�ⲻɨ��
			 */
			if (cls.isAnnotation() || Modifier.isAbstract(cls.getModifiers())|| cls.isInterface() || cls.isEnum()) {
				continue;
			}

			/**
			 * ��JLFMVCBeanע���ע��cls���г�ʼ��
			 */
			JLFMVCBean jJLFMVCBean = (JLFMVCBean) cls.getAnnotation(JLFMVCBean.class);
			if (jJLFMVCBean != null) {
				putBeanMethod.invoke(beanContainer, cls, jJLFMVCBean);
				continue;
			}

			/**
			 * ������Ҫ��ɨ���bean��ע��,���cls������һ��ע���ע,���г�ʼ��
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
			 * ���bean��JLFMVCRouteע���ע,��Ҫ������·����
			 */
			JLFMVCRoute routeAnn = (JLFMVCRoute) cls.getAnnotation(JLFMVCRoute.class);
			if (routeAnn == null) {
				continue;
			}
			parseRouteMethod.invoke(routeManager, cls);
		}

	}

}
