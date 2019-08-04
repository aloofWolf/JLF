package org.jlf.core.exception;

import org.jlf.core.client.JLFPluginClient;

/**
 * 
 * @ClassName: JLFClientNoInitExecption
 * @Description:�ͻ���δ��ʼ���쳣
 * @author Lone Wolf
 * @date 2019��7��6��
 */
public class JLFClientNoInitExecption extends JLFException {

	private static final long serialVersionUID = 4638437926323609346L;

	public JLFClientNoInitExecption(String message) {
		super(message);
	}

	public JLFClientNoInitExecption(Exception e) {
		super(e);
	}

	public <CLIENT extends JLFPluginClient<?>> JLFClientNoInitExecption(Class<CLIENT> cls) {
		super(cls.getSimpleName() + "δ�󶨷����");
	}

}
