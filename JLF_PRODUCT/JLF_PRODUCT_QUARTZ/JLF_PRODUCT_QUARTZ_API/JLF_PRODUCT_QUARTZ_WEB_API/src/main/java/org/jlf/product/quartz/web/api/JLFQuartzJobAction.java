package org.jlf.product.quartz.web.api;

import java.util.List;

import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobListReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobPageReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobSaveReq;
import org.jlf.product.quartz.web.api.metadata.request.executeJob.QuartzJobUpdateReq;
import org.jlf.product.quartz.web.api.metadata.response.QuartzExecuteResp;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;
import org.jlf.soa.mvc.metadata.request.JLFMVCIdRequest;
import org.jlf.soa.mvc.metadata.response.JLFMVCPagingResponse;
import org.jlf.soa.mvc.web.route.JLFMVCRouteCls;

/**
 * 
 * @ClassName: QuartzExecuteWeb
 * @Description:QuartzExecuteWeb
 * @author Lone Wolf
 * @date 2019年5月31日
 */
@JLFMVCRouteCls(name = "quartzJob", type = 1)
public interface JLFQuartzJobAction {

	/**
	 * 
	 * @Title: save
	 * @Description:保存一组定时任务
	 * @param req
	 * @throws Exception
	 */
	public void save(QuartzJobSaveReq req) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:更新定时任务
	 * @param req
	 * @throws Exception
	 */
	public void update(QuartzJobUpdateReq req) throws Exception;

	/**
	 * 
	 * @Title: delete
	 * @Description:删除定时任务
	 * @param req
	 * @throws Exception
	 */
	public void delete(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: enabled
	 * @Description:启用定时任务
	 * @param req
	 * @throws Exception
	 */
	public void enabled(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: disabled
	 * @Description:禁用定时任务
	 * @param req
	 * @throws Exception
	 */
	public void disabled(JLFMVCIdAndVersionRequest req) throws Exception;

	/**
	 * 
	 * @Title: getDeatil
	 * @Description:获取定时任务明细
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public QuartzExecuteResp getDeatil(JLFMVCIdRequest req) throws Exception;

	/**
	 * 
	 * @Title: getPage
	 * @Description:分页查询定时任务
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public JLFMVCPagingResponse getPage(QuartzJobPageReq req) throws Exception;

	/**
	 * 
	 * @Title: getList
	 * @Description:查询定时任务列表
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public List<QuartzExecuteResp> getList(QuartzJobListReq req) throws Exception;

}
