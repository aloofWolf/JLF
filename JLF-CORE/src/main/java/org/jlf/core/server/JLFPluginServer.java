package org.jlf.core.server;

import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.LogUtil;
import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: JLFPluginServer
 * @Description:JLF��������
 * @author Lone Wolf
 * @date 2019��5��28��
 * @param <SERVER_API>
 */
public abstract class JLFPluginServer<SERVER_API extends JLFPluginServerApi> {

	/**
	 * 
	 * @Title: getServerApi
	 * @Description:��ȡapiʵ��
	 * @return
	 */
	public abstract SERVER_API getServerApi();
	
	/**
	 * 
	    * @Title: getDepends
	    * @Description:��ȡ�������������������Ŀͻ���
	    * @return
	 */
	public <CLIENT extends JLFPluginClient<?>> Set<Class<CLIENT>> getDepends(){
		return null;
	}

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

	/**
	 * 
	 * @Title: start
	 * @Description:�����������
	 * @throws JLFClientNoInitExecption
	 */
	public void start() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s������ʼ������", serverName));
		try {
			initConfig();
			doOther();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug(String.format("%s����ʧ�ܡ�����", serverName));
			throw e;
		}

		LogUtil.get().debug(String.format("%s�����ɹ�������", serverName));
	}

	/**
	 * 
	 * @Title: getConfig
	 * @Description:��ȡ���������
	 * @return
	 */
	public Properties getConfig() {
		Class<SERVER_API> serverApiCls = GenericityUtil.getObjSuperClsGenerCls(this.getClass());
		Field pluginField;
		try {
			pluginField = serverApiCls.getField("PLUGIN_NAME");
			String pluginName = (String) pluginField.get(serverApiCls);
			return JLFConfig.getPluginConfig(pluginName);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}

}
