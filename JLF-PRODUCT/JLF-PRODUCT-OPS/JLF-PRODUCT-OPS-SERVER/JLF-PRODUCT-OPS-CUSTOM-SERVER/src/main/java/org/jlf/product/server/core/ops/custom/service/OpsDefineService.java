package org.jlf.product.server.core.ops.custom.service;

import org.jlf.product.ops.web.api.metadata.entity.JLFOpsLog;
import org.jlf.product.server.core.ops.custom.dao.OpsLogDao;
import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.service.ann.JLFMVCTrans;

/**
 * 
 * @ClassName: OpsDefineService
 * @Description:OpsDefineService
 * @author Lone Wolf
 * @date 2019��7��6��
 */
@JLFMVCService
public class OpsDefineService {

	private OpsLogDao logDao;

	/**
	 * 
	 * @Title: saveLog
	 * @Description:����ά����־
	 * @param opsLog
	 */
	@JLFMVCTrans
	public void saveLog(JLFOpsLog opsLog) {
		logDao.save(opsLog);
	}

}
