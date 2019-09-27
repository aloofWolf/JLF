package org.jlf.product.server.quartz.custom;

import org.jlf.product.quartz.server.api.JLFQuartz;
import org.jlf.product.quartz.server.api.JLFQuartzDefine;
import org.jlf.product.quartz.server.api.JLFQuartzQuery;
import org.jlf.product.server.core.quartz.custom.service.QuartzDefineService;
import org.jlf.product.server.core.quartz.custom.service.QuartzQueryService;
import org.jlf.soa.mvc.container.JLFMVCBeanContainer;

/**
 * 
 * @ClassName: QuartzCustomCore
 * @Description: QuartzCustomCore
 * @author Lone Wolf
 * @date 2019Äê9ÔÂ24ÈÕ
 */
public class QuartzCustomCore implements JLFQuartz {

	@Override
	public JLFQuartzDefine getQuartzDefine() {
		return JLFMVCBeanContainer.get(QuartzDefineService.class);
	}

	@Override
	public JLFQuartzQuery getQuartzQuery() {
		return JLFMVCBeanContainer.get(QuartzQueryService.class);
	}

}
