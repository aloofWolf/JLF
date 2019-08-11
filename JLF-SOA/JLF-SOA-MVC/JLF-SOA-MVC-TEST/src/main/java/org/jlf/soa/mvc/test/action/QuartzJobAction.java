package org.jlf.soa.mvc.test.action;

import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;
import org.jlf.soa.mvc.test.bean.QuartzJob;
import org.jlf.soa.mvc.test.service.QuartzJobService;
import org.jlf.soa.mvc.web.ann.JLFMVCRoute;
import org.jlf.soa.mvc.web.ann.JLFMVCRouteMethod;

/**
 * 
 * @ClassName: QuartzJobAction
 * @Description: QuartzJobAction
 * @author Lone Wolf
 * @date 2019��8��11��
 */
@JLFMVCRoute
public class QuartzJobAction {

	private QuartzJobService quartzJobService;

	/**
	 * 
	 * @Title: getQuartzJob
	 * @Description:��ȡQuartzJob��ϸ��Ϣ
	 * @param req
	 * @return
	 */
	@JLFMVCRouteMethod(name = "getQuartzJob")
	public QuartzJob getQuartzJob(JLFMVCIdRequest req) {
		return quartzJobService.getQuartzJob(req.getId());
	}

}
