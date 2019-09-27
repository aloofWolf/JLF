package org.jlf.product.server.core.log.custom.action;

import org.jlf.product.log.web.api.JLFLogAction;
import org.jlf.product.log.web.metadata.entity.JLFLogEntity;
import org.jlf.product.log.web.metadata.request.JLFLogPageReq;
import org.jlf.product.server.core.log.custom.service.LogService;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;

/**
 * 
 * @ClassName: LogAction
 * @Description: LogAction
 * @author Lone Wolf
 * @date 2019Äê9ÔÂ24ÈÕ
 */

@JLFMVCRoute(routeClsType=2)
public class LogAction implements JLFLogAction {

	private LogService service;

	@Override
	public void saveLog(JLFLogEntity log) {
		service.saveLog(log);
	}

	@Override
	public JLFMVCPagingResponse<JLFLogEntity> getPage(JLFLogPageReq req) {
		return service.getPage(req);
	}

	@Override
	public JLFLogEntity getDetail(Long id, Integer queryMonth) {
		return service.getDetail(id, queryMonth);
	}

}
