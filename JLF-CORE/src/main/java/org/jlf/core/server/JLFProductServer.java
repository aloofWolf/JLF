package org.jlf.core.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.jlf.common.util.LogUtil;
import org.jlf.common.util.SingletonUtil;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.api.JLFProductWebApi;
import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: JLFProductServer
 * @Description:JLF��Ʒ�����
 * @author Lone Wolf
 * @date 2019��6��2��
 * @param <SERVER_API>
 * @param <WEB_API>
 */
public abstract class JLFProductServer<SERVER_API extends JLFProductServerApi, WEB_API extends JLFProductWebApi> {

	/**
	 * 
	 * @Title: getServerApi
	 * @Description:��ȡserverApiʵ��
	 * @return
	 */
	public abstract SERVER_API getServerApi();

	/**
	 * 
	 * @Title: getWebApi
	 * @Description:��ȡwebApiʵ��
	 * @return
	 */
	public abstract WEB_API getWebApi();

	/**
	 * 
	 * @Title: initConfig
	 * @Description:��ʼ������
	 */
	public void initConfig() {
	}

	/**
	 * 
	 * @Title: doOther
	 * @Description:�������ʱ,����ʼ�������������������
	 */
	public void doOther() {
	}

	@SuppressWarnings("unchecked")
	private <T> void initRoute() {
		WEB_API webApi = getWebApi();
		if (webApi == null) {
			throw new JLFException("webApi����Ϊ��");
		}
		Method[] methods = webApi.getClass().getDeclaredMethods();
		for (Method method : methods) {
			Class<T> returnType = (Class<T>) method.getReturnType();
			T obj;
			try {
				obj = (T) method.invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new JLFException(e);
			}
			SingletonUtil.put(returnType, obj);
		}
	}

	/**
	 * 
	 * @param <T>
	 * @Title: start
	 * @Description:�����������
	 */
	public <T> void start() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s������ʼ������", serverName));
		try {
			initConfig();
			initRoute();
			doOther();
		} catch (Exception e) {
			LogUtil.get().debug(String.format("%s����ʧ�ܡ�����", serverName));
			throw new JLFException(e);
		}

		LogUtil.get().debug(String.format("%s�����ɹ�������", serverName));
	}

}
