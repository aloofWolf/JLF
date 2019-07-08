package org.jlf.product.ops.wolf.server.service;

import org.jlf.product.ops.wolf.server.dao.OpsLogDao;
import org.jlf.product.ops.wolf.server.metadata.bean.OpsLog;
import org.jlf.soa.mvc.metadata.ann.JLFMVCService;
import org.jlf.soa.mvc.metadata.ann.JLFMVCTrans;

/**
 * 
 * @ClassName: OpsDefineService
 * @Description:OpsDefineService
 * @author Lone Wolf
 * @date 2019年7月6日
 */
@JLFMVCService
public class OpsDefineService {

	private OpsLogDao logDao;

	/**
	 * 
	 * @Title: saveLog
	 * @Description:保存维护日志
	 * @param opsLog
	 */
	@JLFMVCTrans
	public void saveLog(OpsLog opsLog) {
		logDao.save(opsLog);
	}

}
