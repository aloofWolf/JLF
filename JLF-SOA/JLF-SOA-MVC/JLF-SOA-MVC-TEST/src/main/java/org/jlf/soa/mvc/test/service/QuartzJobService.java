package org.jlf.soa.mvc.test.service;

import org.jlf.soa.mvc.service.ann.JLFMVCService;
import org.jlf.soa.mvc.service.ann.JLFMVCTrans;
import org.jlf.soa.mvc.test.bean.QuartzJob;
import org.jlf.soa.mvc.test.bean.QuartzTemplate;
import org.jlf.soa.mvc.test.dao.QuartzJobDao;

/**
 * 
 * @ClassName: QuartzJobService
 * @Description:QuartzJobService
 * @author Lone Wolf
 * @date 2019年8月11日
 */
@JLFMVCService
public class QuartzJobService {

	private QuartzJobDao quartzJobDao;
	private QuartzTemplateService quartzTemplateService;

	/**
	 * 
	 * @Title: getQuartzJob
	 * @Description:getById方法测试
	 * @param id
	 * @return
	 */
	public QuartzJob getQuartzJob(Long id) {
		return quartzJobDao.getById(id);
	}

	/**
	 * 
	 * @Title: getQuartzJobRelate
	 * @Description:多表联查测试
	 * @param id
	 * @return
	 */
	public QuartzJob getQuartzJobRelate(Long id) {
		return quartzJobDao.getQuartzJobRelate(id);
	}

	/**
	 * 
	 * @Title: save
	 * @Description:save方法测试
	 * @param job
	 * @return
	 */
	@JLFMVCTrans
	public QuartzJob save(QuartzJob job) {
		return quartzJobDao.save(job);
	}

	/**
	 * 
	 * @Title: update
	 * @Description:update方法测试
	 * @param job
	 */
	@JLFMVCTrans
	public void update(QuartzJob job) {
		quartzJobDao.update(job);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:delete方法测试
	 * @param job
	 */
	@JLFMVCTrans
	public void delete(QuartzJob job) {
		quartzJobDao.delete(job.getId(), job.getVersion());
	}

	/**
	 * 
	 * @Title: trans
	 * @Description:多数据库间事务测试
	 * @param job
	 * @param template
	 */
	@JLFMVCTrans
	public void trans(QuartzJob job, QuartzTemplate template) {

		quartzTemplateService.save(template);
		quartzJobDao.save(job);
	}
}
