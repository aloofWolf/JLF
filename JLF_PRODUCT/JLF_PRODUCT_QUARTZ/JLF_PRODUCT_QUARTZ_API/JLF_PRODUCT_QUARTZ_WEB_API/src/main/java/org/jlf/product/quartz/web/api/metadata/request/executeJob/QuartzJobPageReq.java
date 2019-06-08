package org.jlf.product.quartz.web.api.metadata.request.executeJob;

import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;

/**
 * 
 * @ClassName: QuartzExecutePageReq
 * @Description:查询定时任务分页请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzJobPageReq extends QuartzJobListReq{

	private JLFMVCPagingRequest pages; // 分页信息

	
	public JLFMVCPagingRequest getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingRequest pages) {
		this.pages = pages;
	}
}
