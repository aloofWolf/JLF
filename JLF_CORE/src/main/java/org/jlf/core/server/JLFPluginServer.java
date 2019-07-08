package org.jlf.core.server;

import java.util.Set;

import org.jlf.core.api.JLFPluginServerApi;
import org.jlf.core.client.JLFPluginClient;
import org.jlf.core.exception.JLFClientNoInitExecption;

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
	 * @Description:��ȡ����������Ŀͻ��˲��
	 * @return
	 */
	public <CLIENT extends JLFPluginClient<SERVER_API>> Set<Class<CLIENT>> getDepends() {
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
	public void start() throws JLFClientNoInitExecption {
		String serverName = this.getClass().getName();
		System.out.println(String.format("%s������ʼ������", serverName));
		try {
			initConfig();
			doOther();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(String.format("%s����ʧ�ܡ�����", serverName));
			throw e;
		}

		System.out.println(String.format("%s�����ɹ�������", serverName));
	}

}
