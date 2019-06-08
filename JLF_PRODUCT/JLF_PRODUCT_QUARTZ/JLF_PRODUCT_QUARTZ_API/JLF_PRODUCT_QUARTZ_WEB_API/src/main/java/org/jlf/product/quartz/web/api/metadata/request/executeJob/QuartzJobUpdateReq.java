package org.jlf.product.quartz.web.api.metadata.request.executeJob;

import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
 * @ClassName: QuartzExecuteUpdateReq
 * @Description:更新定时任务请求的参数信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class QuartzJobUpdateReq extends QuartzJobSaveReq{

	private JLFMVCIdAndVersionRequest header; // header信息

	public JLFMVCIdAndVersionRequest getHeader() {
		return header;
	}

	public void setHeader(JLFMVCIdAndVersionRequest header) {
		this.header = header;
	}

	

}
