package org.jlf.core.server;

import java.lang.reflect.Field;

import org.jlf.common.util.GenericityUtil;
import org.jlf.common.util.IniContent;
import org.jlf.common.util.LogUtil;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.core.config.JLFConfig;
import org.jlf.core.exception.JLFException;

/**
 * 
 * @ClassName: JLFProductServer
 * @Description:JLF��Ʒ�����
 * @author Lone Wolf
 * @date 2019��6��2��
 * @param <SERVER_API>
 */
public abstract class JLFProductServer<SERVER_API extends JLFProductServerApi> {

	/**
	 * 
	 * @Title: getServerApi
	 * @Description:��ȡserverApiʵ��
	 * @return
	 */
	public abstract SERVER_API getServerApi();
	
	/**
	 * 
	 * @Title: start
	 * @Description:�����������
	 */
	public void start() {

	}

	/**
	 * 
	 * @Title: reStart
	 * @Description:�����������
	 */
	public void reStart() {

	}

	/**
	 * 
	 * @Title: start
	 * @Description:�����������
	 * @throws JLFClientNoInitExecption
	 */
	public void startServer() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s������ʼ������", serverName));
		try {
			start();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.get().debug(String.format("%s����ʧ�ܡ�����", serverName));
			throw e;
		}

		LogUtil.get().debug(String.format("%s�����ɹ�������", serverName));
	}

	/**
	 * 
	 * @Title: reStartServer
	 * @Description:�����������
	 * @throws JLFClientNoInitExecption
	 */
	public void reStartServer() {
		String serverName = this.getClass().getName();
		LogUtil.get().debug(String.format("%s������ʼ������", serverName));
		try {
			reStart();
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
	 * @Description:��ȡ���������,�������¼��������ļ�
	 * @return
	 */
	public IniContent getConfig() {
		return getConfig(false);

	}

	/**
	 * 
	 * @Title: getConfig
	 * @Description: ��ȡ���������
	 * @param reLoadConfig
	 *            �Ƿ���Ҫ���¼��������ļ�
	 * @return
	 */
	public IniContent getConfig(boolean reLoadConfig) {
		Class<SERVER_API> serverApiCls = GenericityUtil.getObjSuperClsGenerCls(this.getClass());
		Field productField;
		try {
			productField = serverApiCls.getField("PRODUCT_NAME");
			String productName = (String) productField.get(serverApiCls);
			IniContent config = JLFConfig.getPluginConfig(productName, reLoadConfig);

			if (config == null) {
				config = new IniContent();
			}
			return config;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new JLFException(e);
		}

	}
}
