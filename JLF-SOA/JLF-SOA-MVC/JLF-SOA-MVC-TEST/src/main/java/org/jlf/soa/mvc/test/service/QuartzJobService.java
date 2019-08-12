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
 * @date 2019��8��11��
 */
@JLFMVCService
public class QuartzJobService {

	private QuartzJobDao quartzJobDao;
	private QuartzTemplateService quartzTemplateService;

	/**
	 * 
	 * @Title: getQuartzJob
	 * @Description:getById��������
	 * @param id
	 * @return
	 */
	public QuartzJob getQuartzJob(Long id) {
		return quartzJobDao.getById(id);
	}

	/**
	 * 
	 * @Title: getQuartzJobRelate
	 * @Description:����������
	 * @param id
	 * @return
	 */
	public QuartzJob getQuartzJobRelate(Long id) {
		return quartzJobDao.getQuartzJobRelate(id);
	}

	/**
	 * 
	 * @Title: save
	 * @Description:save��������
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
	 * @Description:update��������
	 * @param job
	 */
	@JLFMVCTrans
	public void update(QuartzJob job) {
		quartzJobDao.update(job);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:delete��������
	 * @param job
	 */
	@JLFMVCTrans
	public void delete(QuartzJob job) {
		quartzJobDao.delete(job.getId(), job.getVersion());
	}

	/**
	 * 
	 * @Title: trans
	 * @Description:�����ݿ���������
	 * @param job
	 * @param template
	 */
	@JLFMVCTrans
	public void trans(QuartzJob job, QuartzTemplate template) {

		quartzTemplateService.save(template);
		quartzJobDao.save(job);
	}
}
