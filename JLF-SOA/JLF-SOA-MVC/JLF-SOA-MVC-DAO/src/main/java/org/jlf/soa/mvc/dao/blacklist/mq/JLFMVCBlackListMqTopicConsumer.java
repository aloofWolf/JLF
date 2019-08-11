package org.jlf.soa.mvc.dao.blacklist.mq;

import org.jlf.plugin.mq.user.api.JLFMqCousumerTopicProcess;
import org.jlf.plugin.threadPool.user.api.JLFThreadPoolSubmit;
import org.jlf.soa.mvc.dao.blacklist.JLFMVCDaoBlackList;

public class JLFMVCBlackListMqTopicConsumer implements JLFMqCousumerTopicProcess<JLFMVCBlackListBean> {

	@Override
	public String getTopicName() {
		return JLFMVCBlackListMqTopicManager.getTopic();
	}

	@Override
	public JLFThreadPoolSubmit<JLFMVCBlackListBean> getThreadPoolSubmit() {
		return new BlackListProcess();
	}
	
	class BlackListProcess implements JLFThreadPoolSubmit<JLFMVCBlackListBean>{


		@Override
		public void execute(JLFMVCBlackListBean bean) throws Exception {
			if(JLFMVCBlackListOperatorType.ADD.equals(bean.getType())){
				JLFMVCDaoBlackList.addBlack(bean.getDbName(), bean.getTableName(), bean.getId(), bean.getExpireTime());
			}else if(JLFMVCBlackListOperatorType.REMOVE.equals(bean.getType())){
				JLFMVCDaoBlackList.removeBlack(bean.getDbName(), bean.getTableName(), bean.getId());
			}
			 
		}
		
	}

}


