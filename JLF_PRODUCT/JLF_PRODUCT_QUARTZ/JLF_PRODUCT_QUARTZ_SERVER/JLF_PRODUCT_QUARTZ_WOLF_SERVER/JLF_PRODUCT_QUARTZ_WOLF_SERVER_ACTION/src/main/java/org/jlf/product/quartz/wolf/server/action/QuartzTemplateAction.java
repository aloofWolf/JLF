package org.jlf.product.quartz.wolf.server.action;

import java.util.ArrayList;
import java.util.List;

import org.jlf.product.quartz.web.api.JLFQuartzTemplateAction;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateListReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplatePageReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateSaveReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateUpdateReq;
import org.jlf.product.quartz.web.api.metadata.response.QuartzTemplateResp;
import org.jlf.product.quartz.wolf.server.metadata.bean.QuartzTemplate;
import org.jlf.product.quartz.wolf.server.service.QuartzTemplateService;
import org.jlf.soa.mvc.metadata.page.JLFMVCPage;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.route.JLFMVCRouteCls;

/**
 * 
 * @ClassName: QuartzTemplateWeb
 * @Description:QuartzTemplateWeb
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCRouteCls(type = 2)
public class QuartzTemplateAction implements JLFQuartzTemplateAction{

	private QuartzTemplateService service;

	/**
	 * 
	 * @Title: save
	 * @Description:保存模板
	 * @param req
	 * @throws Exception
	 */
	public void save(QuartzTemplateSaveReq req) throws Exception {
		QuartzTemplate template = new QuartzTemplate();
		template.setTemplateName(req.getTemplateName());
		template.setClsName(req.getClsName());
		template.setEnabled(req.getEnabled());
		service.save(template);
		
	}

	/**
	 * 
	 * @Title: update
	 * @Description:更新模板
	 * @param req
	 * @throws Exception
	 */
	public void update(QuartzTemplateUpdateReq req) throws Exception {
		QuartzTemplate template = new QuartzTemplate();
		template.setId(req.getHeader().getId());
		template.setVersion(req.getHeader().getVersion());
		template.setTemplateName(req.getTemplateName());
		template.setClsName(req.getClsName());
		template.setEnabled(req.getEnabled());
		service.save(template);
		
		service.update(template);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:删除模板
	 * @param req
	 * @throws Exception
	 */
	public void delete(JLFMVCIdAndVersionRequest req) throws Exception {
		service.delete(req.getId(), req.getVersion());
	}

	/**
	 * 
	 * @Title: enabled
	 * @Description:启用模板
	 * @param req
	 * @throws Exception
	 */
	public void enabled(JLFMVCIdAndVersionRequest req) throws Exception {
		service.enabled(req.getId(), req.getVersion());
	}

	/**
	 * 
	 * @Title: disabled
	 * @Description:禁用模板
	 * @param req
	 * @throws Exception
	 */
	public void disabled(JLFMVCIdAndVersionRequest req) throws Exception {
		service.disabled(req.getId(), req.getVersion());
	}

	/**
	 * 
	 * @Title: getDetail
	 * @Description:获取模板详细信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public QuartzTemplateResp getDetail(JLFMVCIdRequest req) throws Exception {
		QuartzTemplate template = service.getById(req.getId());
		if (template == null) {
			throw new Exception("未获取到定时任务模板");
		}
		QuartzTemplateResp resp = new QuartzTemplateResp();
		resp.setId(template.getId());
		resp.setVersion(template.getVersion());
		resp.setTemplateName(template.getTemplateName());
		resp.setClsName(template.getClsName());
		resp.setEnabled(template.getEnabled().getId());
		return resp;
	}

	/**
	 * 
	 * @Title: getPage
	 * @Description:分页查询模板信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse getPage(QuartzTemplatePageReq req) throws Exception {
		JLFMVCPage<QuartzTemplate> page = service.getPage(req);
		List<QuartzTemplate> list = page.getDetails();
		List<QuartzTemplateResp> respList = new ArrayList<QuartzTemplateResp>();
		if (list != null) {
			for (QuartzTemplate template : list) {
				QuartzTemplateResp resp = new QuartzTemplateResp();
				resp.setId(template.getId());
				resp.setVersion(template.getVersion());
				resp.setTemplateName(template.getTemplateName());
				resp.setClsName(template.getClsName());
				resp.setEnabled(template.getEnabled().getId());
				respList.add(resp);
			}
		}
		return new JLFMVCPagingResponse(page.getTotalNum(), page.getTotalPage(), respList);
	}

	/**
	 * 
	 * @Title: getList
	 * @Description:查询模板信息列表
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public List<QuartzTemplateResp> getList(QuartzTemplateListReq req) throws Exception {
		List<QuartzTemplate> list = service.getList(req);
		List<QuartzTemplateResp> respList = new ArrayList<QuartzTemplateResp>();
		if (list != null) {
			for (QuartzTemplate template : list) {
				QuartzTemplateResp resp = new QuartzTemplateResp();
				resp.setId(template.getId());
				resp.setVersion(template.getVersion());
				resp.setTemplateName(template.getTemplateName());
				resp.setClsName(template.getClsName());
				resp.setEnabled(template.getEnabled().getId());
				respList.add(resp);
			}
		}
		return respList;
	}

}
