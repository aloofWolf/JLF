package org.jlf.product.quartz.web.api;

import java.util.List;

import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateListReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplatePageReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateSaveReq;
import org.jlf.product.quartz.web.api.metadata.request.template.QuartzTemplateUpdateReq;
import org.jlf.product.quartz.web.api.metadata.response.QuartzTemplateResp;
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
@JLFMVCRouteCls(name = "quartzTemlate" ,type=1)
public interface JLFQuartzTemplateAction {

	/**
	 * 
	 * @Title: save
	 * @Description:保存模板
	 * @param req
	 * @throws Exception
	 */
	public void save(QuartzTemplateSaveReq req) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:更新模板
	 * @param req
	 * @throws Exception
	 */
	public void update(QuartzTemplateUpdateReq req) throws Exception;

	/**
	 * 
	 * @Title: delete
	 * @Description:删除模板
	 * @param req
	 * @throws Exception
	 */
	public void delete(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: enabled
	 * @Description:启用模板
	 * @param req
	 * @throws Exception
	 */
	public void enabled(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: disabled
	 * @Description:禁用模板
	 * @param req
	 * @throws Exception
	 */
	public void disabled(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: getDetail
	 * @Description:获取模板详细信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public QuartzTemplateResp getDetail(JLFMVCIdRequest req) throws Exception;

	/**
	 * 
	 * @Title: getPage
	 * @Description:分页查询模板信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse getPage(QuartzTemplatePageReq req) throws Exception;

	/**
	 * 
	 * @Title: getList
	 * @Description:查询模板信息列表
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public List<QuartzTemplateResp> getList(QuartzTemplateListReq req) throws Exception;

}
