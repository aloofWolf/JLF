package org.jlf.product.log.test.action;

import org.jlf.product.client.log.JLFLogClient;
import org.jlf.product.log.web.metadata.entity.JLFLogEntity;
import org.jlf.product.log.web.metadata.request.JLFLogPageReq;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: LogAction
 * @Description: LogAction
 * @author Lone Wolf
 * @date 2019Äê9ÔÂ24ÈÕ
 */

@JLFMVCRoute
public class LogAction {

	public void saveLog(JLFLogEntity log) {
		JLFLogClient.get().saveLog(log);
	}

	public JLFMVCPagingResponse<JLFLogEntity> getPage(JLFLogPageReq req) {
		return JLFLogClient.get().getPage(req);
	}

	public JLFLogEntity getDetail(Long id, Integer queryMonth) {
		return JLFLogClient.get().getDetail(id, queryMonth);
	}

}
