package org.jlf.soa.mvc.web.filter;

import javax.servlet.Filter;

import org.jlf.plugin.dbPool.client.JLFDbPoolClient;

/**
 * 
 * @ClassName: JLFMVCFilter
 * @Description:����������
 * @author Lone Wolf
 * @date 2019��7��6��
 */
public abstract class JLFMVCFilter implements Filter {

	/**
	 * �رյ�ǰ�̵߳��������ݿ�����
	 */
	@Override
	public void destroy() {
		JLFDbPoolClient.get().closeAllConn();

	}

}
