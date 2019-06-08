package org.jlf.core.client;

import org.jlf.core.api.JLFIProduct;
import org.jlf.core.server.JLFProductServer;

/**
 * 
 * @ClassName: JLFProductClient
 * @Description:JLF��Ʒ�ͻ���
 * @author Lone Wolf
 * @date 2019��6��3��
 * @param <API>
 */
public interface JLFProductClient<API extends JLFIProduct> {

	/**
	 * 
	 * @Title: getServer
	 * @Description:��ȡ��Ʒ�İ󶨵�server��
	 * @return
	 */
	public <SERVER extends JLFProductServer<API>> SERVER getServer();

}
