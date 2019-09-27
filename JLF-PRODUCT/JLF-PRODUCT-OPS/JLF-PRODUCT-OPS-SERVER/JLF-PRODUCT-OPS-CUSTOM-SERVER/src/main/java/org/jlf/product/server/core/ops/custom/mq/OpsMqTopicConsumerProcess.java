package org.jlf.product.server.core.ops.custom.mq;

import org.jlf.common.util.LogUtil;
import org.jlf.core.exception.JLFException;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;
import org.jlf.product.ops.web.api.enums.JLFOpsModule;
import org.jlf.product.ops.web.api.enums.JLFOpsResult;
import org.jlf.product.ops.web.api.enums.JLFOpsType;
import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.product.server.core.ops.custom.service.OpsDefineService;
import org.jlf.product.server.core.ops.custom.service.OpsExecuteService;
import org.jlf.soa.mvc.container.ann.JLFMVCBean;

/**
 * 
 * @ClassName: OpsMqTopicConsumerProcess
 * @Description: 消息队列消费者处理
 * @author Lone Wolf
 * @date 2019年9月25日
 */

@JLFMVCBean
public class OpsMqTopicConsumerProcess implements JLFThreadPoolSubmit<JLFOpsLog> {

	private OpsExecuteService dirverService;
	private OpsDefineService defineService;

	@Override
	public void execute(JLFOpsLog opsLog) throws Exception {
		try {
			LogUtil.get().debug("OpsMqTopicConsumer = {},", opsLog.toString());
			opsLog.setHostIp(OpsMqTopicManager.getHostIp());
			String currHostIp = OpsMqTopicManager.getHostIp();
			if(!currHostIp.equals(opsLog.getHostIp())){
				if (JLFOpsModule.PLUGIN.equals(opsLog.getModule()) && JLFOpsType.RESTART.equals(opsLog.getType())) {
					dirverService.reStartPluginServer(opsLog.getServerClsName(), false);
				} else if (JLFOpsModule.PRODUCT.equals(opsLog.getModule()) && JLFOpsType.RESTART.equals(opsLog.getType())) {
					dirverService.reStartProductServer(opsLog.getServerClsName(), false);
				} else if (JLFOpsModule.SOA.equals(opsLog.getModule()) && JLFOpsType.RESTART.equals(opsLog.getType())) {
					dirverService.reStartSoaServer(opsLog.getServerClsName(), false);
				} else {
					throw new JLFException("维护类型不支持");
				}
				opsLog.setOpsResult(JLFOpsResult.SUCCESS);
			}
			opsLog.setHostIp(currHostIp);
		} catch (Exception e) {
			e.printStackTrace();
			opsLog.setOpsResult(JLFOpsResult.FAIL);
			opsLog.setFailReason(e.getMessage());
		} finally {
			defineService.saveLog(opsLog);
		}

	}

}
