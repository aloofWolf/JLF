package org.jlf.product.server.core.ops.custom.service;

import org.jlf.core.exception.JLFException;
import org.jlf.core.server.JLFPluginServer;
import org.jlf.core.server.JLFProductServer;
import org.jlf.core.server.JLFSoaServer;
import org.jlf.product.ops.server.api.JLFOpsExecute;
import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.product.server.core.ops.custom.mq.OpsMqTopicProduct;
import org.jlf.soa.mvc.service.ann.JLFMVCService;

/**
 * 
 * @ClassName: OpsExecuteService
 * @Description:OpsExecuteService
 * @author Lone Wolf
 * @date 2019��7��6��
 */
@JLFMVCService
public class OpsExecuteService implements JLFOpsExecute {

	@Override
	public void reStartPluginServer(String pluginServerClsName) {
		reStartPluginServer(pluginServerClsName, true);
	}

	@Override
	public void reStartProductServer(String productServerClsName) {
		reStartProductServer(productServerClsName, true);
	}

	@Override
	public void reStartSoaServer(String soaServerClsName) {
		reStartSoaServer(soaServerClsName, true);
	}

	/**
	 * 
	 * @Title: reStartPluginServer
	 * @Description: �����������
	 * @param pluginServerClsName
	 * @param isSendMq
	 *            �Ƿ��Ͷ���
	 */
	public void reStartPluginServer(String pluginServerClsName, boolean isSendMq) {
		try {
			Class<?> pluginServerCls = Class.forName(pluginServerClsName);
			if (!JLFPluginServer.class.isAssignableFrom(pluginServerCls)) {
				throw new ClassNotFoundException();
			}
			JLFPluginServer<?> pluginServer = (JLFPluginServer<?>) pluginServerCls.newInstance();
			pluginServer.reStartServer();
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				throw new JLFException("pluginServerClsName����ȷ,δ�ҵ���Ӧ�ķ����");
			} else {
				throw new JLFException(e);
			}
		}

		if (isSendMq) {
			OpsMqTopicProduct.send(JLFOpsModule.PLUGIN, JLFOpsType.RESTART, null, pluginServerClsName);
		}

	}

	/**
	 * 
	 * @Title: reStartProductServer
	 * @Description: ������Ʒ����
	 * @param productServerClsName
	 * @param isSendMq
	 */
	public void reStartProductServer(String productServerClsName, boolean isSendMq) {
		try {
			Class<?> productServerCls = Class.forName(productServerClsName);
			if (!JLFProductServer.class.isAssignableFrom(productServerCls)) {
				throw new ClassNotFoundException();
			}
			JLFProductServer<?> productServer = (JLFProductServer<?>) productServerCls.newInstance();
			productServer.reStartServer();
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				throw new JLFException("productServerClsName����ȷ,δ�ҵ���Ӧ�ķ����");
			} else {
				throw new JLFException(e);
			}
		}

		if (isSendMq) {
			OpsMqTopicProduct.send(JLFOpsModule.PRODUCT, JLFOpsType.RESTART, null, productServerClsName);
		}

	}

	/**
	 * 
	 * @Title: reStartSoaServer
	 * @Description: �����ܹ�����
	 * @param soaServerClsName
	 * @param isSendMq
	 */
	public void reStartSoaServer(String soaServerClsName, boolean isSendMq) {
		try {
			Class<?> soaServerCls = Class.forName(soaServerClsName);
			if (!JLFSoaServer.class.isAssignableFrom(soaServerCls)) {
				throw new ClassNotFoundException();
			}
			JLFSoaServer soaServer = (JLFSoaServer) soaServerCls.newInstance();
			soaServer.reStartServer();
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof ClassNotFoundException) {
				throw new JLFException("soaServerClsName����ȷ,δ�ҵ���Ӧ�ķ����");
			} else {
				throw new JLFException(e);
			}
		}

		if (isSendMq) {
			OpsMqTopicProduct.send(JLFOpsModule.SOA, JLFOpsType.RESTART, null, soaServerClsName);
		}

	}

}
