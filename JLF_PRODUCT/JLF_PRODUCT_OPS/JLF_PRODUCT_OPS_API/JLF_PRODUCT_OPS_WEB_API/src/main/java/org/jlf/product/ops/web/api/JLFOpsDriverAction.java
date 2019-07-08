package org.jlf.product.ops.web.api;

import org.jlf.product.ops.web.api.metadata.request.JLFOpsDriverRequest;
import org.jlf.soa.mvc.metadata.ann.JLFMVCRouteCls;

/**
 * 
 * @ClassName: JLFOpsDriverAction
 * @Description:JLFOpsDriverActionApi
 * @author Lone Wolf
 * @date 2019��7��6��
 */
@JLFMVCRouteCls(name = "opsDriver")
public interface JLFOpsDriverAction {

	/**
	 * 
	 * @Title: reLoadPluginConfigFile
	 * @Description:�����������¼��������ļ�
	 * @param serverCode
	 */
	public void reLoadPluginConfigFile(JLFOpsDriverRequest req);

	/**
	 * 
	 * @Title: reLoadProductConfigFile
	 * @Description:�����������¼��������ļ�
	 * @param serverCode
	 */
	public void reLoadProductConfigFile(JLFOpsDriverRequest req);

	/**
	 * 
	 * @Title: reLoadSoaConfigFile
	 * @Description:�ܹ���������¼��������ļ�
	 * @param serverCode
	 */
	public void reLoadSoaConfigFile(JLFOpsDriverRequest req);

}
