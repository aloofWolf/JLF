package org.jlf.product.ops.wolf.server.service;

import org.jlf.product.ops.web.api.metadata.request.JLFOpsLogPageRequest;
import org.jlf.product.ops.wolf.server.dao.OpsLogDao;
import org.jlf.product.ops.wolf.server.metadata.bean.OpsLog;
import org.jlf.soa.mvc.metadata.ann.JLFMVCService;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;

/**
 * 
 * @ClassName: OpsQueryService
 * @Description:OpsQueryService
 * @author Lone Wolf
 * @date 2019��7��6��
 */
@JLFMVCService
public class OpsQueryService {

	private OpsLogDao logDao;

	/**
	 * 
	 * @Title: getLogPage
	 * @Description:��ѯ��־��ҳ��Ϣ
	 * @param req
	 * @return
	 */
	public JLFMVCPage<OpsLog> getLogPage(JLFOpsLogPageRequest req) {
		return logDao.getPage(req);
	}

}
