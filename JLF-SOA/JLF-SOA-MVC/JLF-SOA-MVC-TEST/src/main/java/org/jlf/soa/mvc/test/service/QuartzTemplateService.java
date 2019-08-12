package org.jlf.soa.mvc.test.service;

import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.service.ann.JLFMVCTrans;
import org.jlf.soa.mvc.test.bean.QuartzTemplate;
import org.jlf.soa.mvc.test.dao.QuartzTemplateDao;

/**
 * 
 * @ClassName: QuartzTemplateService
 * @Description:QuartzTemplateService
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ12ÈÕ
 */
@JLFMVCService
public class QuartzTemplateService {

	private QuartzTemplateDao quartzTemplateDao;

	@JLFMVCTrans(dbName = "wolf2")
	public QuartzTemplate save(QuartzTemplate quartzTemplate) {
		return quartzTemplateDao.save(quartzTemplate);
	}

}
