package org.jlf.product.quartz.wolf.server.service;

import java.util.List;

import org.jlf.common.enums.BooleanType;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobListReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobPageReq;
import org.jlf.product.quartz.wolf.server.dao.QuartzJobDao;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzJob;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzTemplate;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.service.JLFMAVCConnection;
import org.jlf.soa.mvc.service.JLFMVCService;
import org.jlf.soa.mvc.service.JLFMVCTrans;

/**
 * 
 * @ClassName: QuartzExecuteService
 * @Description:QuartzExecuteService
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzJobService extends JLFMVCService<QuartzJob, QuartzJobDao> {

	private QuartzTemplateService templateService;

	/**
	 * 
	 * @Title: save
	 * @Description:����һ�鶨ʱ����
	 * @param list
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public QuartzJob save(QuartzJob job) throws Exception {
		QuartzTemplate template = templateService.getById(job.getTemplateId());
		if (template == null) {
			throw new Exception("ģ�岻����");
		}
		if (template.getEnabled().equals(BooleanType.FALSE)) {
			throw new Exception("ģ���ѱ�����");
		}
		if (job.getEnabled().equals(BooleanType.TRUE)) {
			job.setReady(BooleanType.TRUE);
		}
		return dao.save(job);
	}

	/**
	 * 
	 * @Title: update
	 * @Description:���¶�ʱ����
	 * @param job
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void update(QuartzJob job) throws Exception {
		Long templateId = job.getTemplateId();
		if(templateId != null){
			QuartzTemplate template = templateService.getById(templateId);
			if (template == null) {
				throw new Exception("ģ�岻����");
			}
			if (template.getEnabled().equals(BooleanType.TRUE)) {
				throw new Exception("ģ���ѱ�����");
			}
		}
		if (job.getEnabled() != null && job.getEnabled().equals(BooleanType.TRUE)) {
			job.setReady(BooleanType.TRUE);
		}
		dao.update(job);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ����ʱ����
	 * @param id
	 * @param version
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void delete(Long id, Long version) throws Exception {
		QuartzJob oldJob = getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new Exception("��ʱ���񲻴���");
		}
		QuartzJob newJob = new QuartzJob();
		newJob.setIsDelete(BooleanType.TRUE);
		newJob.setDeleteNum(id);
		if (oldJob.getEnabled().equals(BooleanType.TRUE)) {
			newJob.setEnabled(BooleanType.FALSE);
			newJob.setReady(BooleanType.TRUE);
		}
		dao.update(newJob);
	}

	/**
	 * 
	 * @Title: enabled
	 * @Description:���ö�ʱ����
	 * @param id
	 * @param version
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void enabled(Long id, Long version) throws Exception {
		QuartzJob oldJob = getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new Exception("��ʱ���񲻴���");
		}
		if (oldJob.getEnabled().equals(BooleanType.TRUE)) {
			return;
		}
		QuartzJob newJob = new QuartzJob();
		newJob.setEnabled(BooleanType.TRUE);
		newJob.setReady(BooleanType.TRUE);
		dao.update(newJob);
	}

	/**
	 * 
	 * @Title: disabled
	 * @Description:���ö�ʱ����
	 * @param id
	 * @param version
	 * @throws Exception
	 */
	@JLFMAVCConnection
	@JLFMVCTrans
	public void disabled(Long id, Long version) throws Exception {
		QuartzJob oldJob = getByIdAndVersion(id, version);
		if (oldJob == null) {
			throw new Exception("��ʱ���񲻴���");
		}
		if (oldJob.getEnabled().equals(BooleanType.FALSE)) {
			return;
		}
		QuartzJob newJob = new QuartzJob();
		newJob.setEnabled(BooleanType.FALSE);
		newJob.setReady(BooleanType.TRUE);
		dao.update(newJob);
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ѯ��ҳ
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public JLFMVCPage<QuartzJob> getPage(QuartzJobPageReq req) throws Exception {
		return dao.getPage(req);
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ѯ��ҳ
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public List<QuartzJob> getList(QuartzJobListReq req) throws Exception {
		return dao.getList(req);
	}

	/**
	 * 
	 * @Title: reStartByTemplateId
	 * @Description:����һ��ģ��������������������
	 * @param templateId
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public void reStartByTemplateId(Long templateId) throws Exception {
		dao.reStartByTemplateId(templateId);
	}

	/**
	 * 
	 * @Title: disabledByTemplateId
	 * @Description:����һ��ģ��������������������
	 * @param templateId
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public void disabledByTemplateId(Long templateId) throws Exception {
		dao.disabledByTemplateId(templateId);
	}

	/**
	 * 
	 * @Title: getReadyList
	 * @Description:���ݾ���״̬��ѯ��ʱ�����б�
	 * @return
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public List<QuartzJob> getReadyList(BooleanType ready) throws Exception {
		return dao.getReadyList(ready);
	}

	/**
	 * 
	 * @Title: updateAllReady
	 * @Description:�����е�job��Ϊ����״̬
	 * @throws Exception
	 */
	@JLFMAVCConnection
	public void updateAllReady() throws Exception {
		dao.updateAllReady();
	}
}
