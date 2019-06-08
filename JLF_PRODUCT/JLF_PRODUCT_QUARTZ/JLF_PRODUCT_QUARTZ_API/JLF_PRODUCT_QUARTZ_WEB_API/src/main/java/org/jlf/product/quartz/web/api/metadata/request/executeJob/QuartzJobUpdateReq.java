package org.jlf.product.quartz.web.api.metadata.request.executeJob;

import org.jlf.soa.mvc.metadata.request.JLFMVCIdAndVersionRequest;

/**
 * 
 * @ClassName: QuartzExecuteUpdateReq
 * @Description:���¶�ʱ��������Ĳ�����Ϣ
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public class QuartzJobUpdateReq extends QuartzJobSaveReq{

	private JLFMVCIdAndVersionRequest header; // header��Ϣ

	public JLFMVCIdAndVersionRequest getHeader() {
		return header;
	}

	public void setHeader(JLFMVCIdAndVersionRequest header) {
		this.header = header;
	}

	

}
