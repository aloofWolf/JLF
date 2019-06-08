package org.jlf.product.quartz.web.api.metadata.request.executeJob;

import org.jlf.soa.mvc.metadata.request.JLFMVCPagingRequest;

/**
 * 
 * @ClassName: QuartzExecutePageReq
 * @Description:��ѯ��ʱ�����ҳ����Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzJobPageReq extends QuartzJobListReq{

	private JLFMVCPagingRequest pages; // ��ҳ��Ϣ

	
	public JLFMVCPagingRequest getPages() {
		return pages;
	}

	public void setPages(JLFMVCPagingRequest pages) {
		this.pages = pages;
	}
}
