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
 * @date 2019��5��31��
 */
@JLFMVCRouteCls(name = "quartzTemlate" ,type=1)
public interface JLFQuartzTemplateAction {

	/**
	 * 
	 * @Title: save
	 * @Description:����ģ��
	 * @param req
	 * @throws Exception
	 */
	public void save(QuartzTemplateSaveReq req) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:����ģ��
	 * @param req
	 * @throws Exception
	 */
	public void update(QuartzTemplateUpdateReq req) throws Exception;

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ��ģ��
	 * @param req
	 * @throws Exception
	 */
	public void delete(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: enabled
	 * @Description:����ģ��
	 * @param req
	 * @throws Exception
	 */
	public void enabled(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: disabled
	 * @Description:����ģ��
	 * @param req
	 * @throws Exception
	 */
	public void disabled(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: getDetail
	 * @Description:��ȡģ����ϸ��Ϣ
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public QuartzTemplateResp getDetail(JLFMVCIdRequest req) throws Exception;

	/**
	 * 
	 * @Title: getPage
	 * @Description:��ҳ��ѯģ����Ϣ
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse getPage(QuartzTemplatePageReq req) throws Exception;

	/**
	 * 
	 * @Title: getList
	 * @Description:��ѯģ����Ϣ�б�
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public List<QuartzTemplateResp> getList(QuartzTemplateListReq req) throws Exception;

}
