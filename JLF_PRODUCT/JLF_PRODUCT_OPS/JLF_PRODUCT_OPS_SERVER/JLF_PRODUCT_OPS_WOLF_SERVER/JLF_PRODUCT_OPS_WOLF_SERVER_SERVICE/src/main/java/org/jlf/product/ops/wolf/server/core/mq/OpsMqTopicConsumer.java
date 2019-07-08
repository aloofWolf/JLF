package org.jlf.product.ops.wolf.server.core.mq;

import java.io.Serializable;

import org.jlf.common.exception.JLFException;
import org.jlf.common.util.LogUtil;
import org.jlf.plugin.mq.user.api.JLFCousumerTopicProcess;
import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsResult;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.product.ops.wolf.server.metadata.bean.OpsLog;
import org.jlf.product.ops.wolf.server.service.OpsDefineService;
import org.jlf.product.ops.wolf.server.service.OpsDriverService;

/**
 * 
 * @ClassName: OpsMqTopicConsumer
 * @Description:消息队列消费者
 * @author Lone Wolf
 * @date 2019年7月5日
 */
public class OpsMqTopicConsumer implements JLFCousumerTopicProcess {

	private OpsDriverService dirverService;
	private OpsDefineService defineService;

	@Override
	public String getTopicName() {
		return OpsMqTopicManager.getTopic();
	}

	@Override
	public void process(Serializable obj) throws Exception {
		OpsLog opsLog = (OpsLog) obj;
		try {
			LogUtil.get().debug("OpsMqTopicConsumer = {},", opsLog.toString());
			String productHostCode = opsLog.getHostCode();
			if (!OpsMqTopicManager.getHostCode().equals(productHostCode)) {
				if (JLFOpsModule.PLUGIN.equals(opsLog.getModule())
						&& JLFOpsType.RELOADCONFIG.equals(opsLog.getType())) {
					dirverService.reLoadPluginConfigFile(opsLog.getClientCode(), opsLog.getServerCode());
				} else if (JLFOpsModule.PRODUCT.equals(opsLog.getModule())
						&& JLFOpsType.RELOADCONFIG.equals(opsLog.getType())) {
					dirverService.reLoadProductConfigFile(opsLog.getClientCode(), opsLog.getServerCode());
				} else if (JLFOpsModule.SOA.equals(opsLog.getModule())
						&& JLFOpsType.RELOADCONFIG.equals(opsLog.getType())) {
					dirverService.reLoadSoaConfigFile(opsLog.getServerCode());
				} else {
					throw new JLFException("维护类型不支持");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			opsLog.setOpsResult(JLFOpsResult.FAIL);
			opsLog.setFailReason(e.getMessage());
		} finally {
			defineService.saveLog(opsLog);
		}

	}

	@Override
	public Class<? extends Serializable> getMessageCls() {
		return OpsLog.class;
	}

}
