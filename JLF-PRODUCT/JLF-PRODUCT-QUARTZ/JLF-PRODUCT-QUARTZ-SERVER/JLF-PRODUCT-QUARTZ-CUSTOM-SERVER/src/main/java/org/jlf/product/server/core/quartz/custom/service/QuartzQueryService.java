package org.jlf.product.server.core.quartz.custom.service;

import java.util.Date;
import java.util.List;

import org.jlf.product.quartz.server.api.JLFQuartzQuery;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzExecuteLogEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzJobEntity;
import org.jlf.product.quartz.web.api.metadata.entity.JLFQuartzTemplateEntity;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzExecuteLogPageReq;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.JLFQuartzTemplatePageReq;
import org.jlf.product.server.core.quartz.custom.dao.QuartzExecuteLogDao;
import org.jlf.product.server.core.quartz.custom.dao.QuartzJobDao;
import org.jlf.product.server.core.quartz.custom.dao.QuartzTemplateDao;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.service.ann.JLFMVCService;

/**
 * 
 * @ClassName: QuartzQueryService
 * @Description:QuartzQueryService
 * @author Lone Wolf
 * @date 2019��7��5��
 */
@JLFMVCService
public class QuartzQueryService implements JLFQuartzQuery {

	private QuartzTemplateDao templateDao;
	private QuartzJobDao jobDao;
	private QuartzExecuteLogDao logDao;

	/**
	 * 
	 * @Title: getJobDetail
	 * @Description:��ȡjob��ϸ
	 * @param id
	 * @return
	 */
	public JLFQuartzJobEntity getJobDetail(Long id) {
		return jobDao.getJobDetail(id);
	}

	/**
	 * 
	 * @Title: getJobPage
	 * @Description:��ҳ��ѯjob
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzJobEntity> getJobPage(JLFQuartzJobPageReq req) {
		return jobDao.getPage(req);
	}

	/**
	 * 
	 * @Title: getTemplateDetail
	 * @Description:��ȡtemplate��ϸ
	 * @param id
	 * @return
	 */
	public JLFQuartzTemplateEntity getTemplateDetail(Long id) {
		return templateDao.getById(id);
	}

	/**
	 * 
	 * @Title: getTemplatePage
	 * @Description:��ҳ��ѯtemplate
	 * @param req
	 * @return
	 */
	public JLFMVCPagingResponse<JLFQuartzTemplateEntity> getTemplatePage(JLFQuartzTemplatePageReq req) {
		return templateDao.getPage(req);
	}

	/**
	 * 
	 * @Title: getLogDetail
	 * @Description:��ȡlog��ϸ
	 * @param id
	 * @return
	 */
	public JLFQuartzExecuteLogEntity getLogDetail(Long id) {
		return logDao.getById(id);
	}

	/**
	 * 
	 * @Title: getLogPage
	 * @Description:��ҳ��ѯ��־
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse<JLFQuartzExecuteLogEntity> getLogPage(JLFQuartzExecuteLogPageReq req) {
		return logDao.getPage(req);
	}

	/**
	 * 
	 * @Title: getReadyJobList
	 * @Description:��ѯ��ָ����updateTime��Ķ�ʱ�����б�
	 * @return
	 */
	public List<JLFQuartzJobEntity> getList(Date updateTime) {
		return jobDao.getListByupdateTime(updateTime);
	}

}
