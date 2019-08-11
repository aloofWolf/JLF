package org.jlf.soa.mvc.test.service;

import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.test.bean.QuartzJob;
import org.jlf.soa.mvc.test.dao.QuartzJobDao;

/**
 * 
 * @ClassName: QuartzJobService
 * @Description:QuartzJobService
 * @author Lone Wolf
 * @date 2019Äê8ÔÂ11ÈÕ
 */
@JLFMVCService
public class QuartzJobService {

	private QuartzJobDao quartzJobDao;

	public QuartzJob getQuartzJob(Long id) {
		return quartzJobDao.getById(id);
	}

}
