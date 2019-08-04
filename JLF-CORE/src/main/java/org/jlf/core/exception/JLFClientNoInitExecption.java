package org.jlf.core.exception;

import org.jlf.core.client.JLFPluginClient;

/**
 * 
 * @ClassName: JLFClientNoInitExecption
 * @Description:客户端未初始化异常
 * @author Lone Wolf
 * @date 2019年7月6日
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
		super(cls.getSimpleName() + "未绑定服务端");
	}

}
