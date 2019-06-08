package org.jlf.product.quartz.wolf.server.service;

import org.jlf.product.quartz.web.api.metadata.request.executeLog.QuartzExecuteLogPageReq;
import org.jlf.product.quartz.wolf.server.dao.QuartzExecuteLogDao;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzExecuteLog;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.service.JLFMAVCConnection;
import org.jlf.soa.mvc.service.JLFMVCService;

/**
 * 
 * @ClassName: QuartzExecuteLogService
 * @Description:QuartzExecuteLogService
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzExecuteLogService extends JLFMVCService<QuartzExecuteLog, QuartzExecuteLogDao> {

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ѯ��ҳ��Ϣ
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public JLFMVCPage<QuartzExecuteLog> getPage(QuartzExecuteLogPageReq req) throws Exception {
		return dao.getPage(req);
	}

}
