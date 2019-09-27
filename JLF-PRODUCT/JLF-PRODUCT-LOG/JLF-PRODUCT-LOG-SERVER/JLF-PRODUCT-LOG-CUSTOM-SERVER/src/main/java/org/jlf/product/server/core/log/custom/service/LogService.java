package org.jlf.product.server.core.log.custom.service;

import org.jlf.product.log.server.api.JLFLog;
import org.jlf.product.log.web.metadata.entity.JLFLogEntity;
import org.jlf.product.log.web.metadata.request.JLFLogPageReq;
import org.jlf.product.server.core.log.custom.dao.LogDao;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.service.ann.JLFMVCTrans;

/**
 * 
 * @ClassName: LogService
 * @Description:LogService
 * @author Lone Wolf
 * @date 2019Äê9ÔÂ24ÈÕ
 */

@JLFMVCService
public class LogService implements JLFLog {

	private LogDao dao;

	@JLFMVCTrans
	@Override
	public void saveLog(JLFLogEntity log) {
		dao.save(log);

	}

	@Override
	public JLFMVCPagingResponse<JLFLogEntity> getPage(JLFLogPageReq req) {
		return dao.getPage(req);
	}

	@Override
	public JLFLogEntity getDetail(Long id, Integer queryMonth) {
		return dao.getById(id, queryMonth);
	}

}
