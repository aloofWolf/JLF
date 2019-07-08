package org.jlf.product.quartz.server.api;

import org.jlf.common.enums.BooleanType;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFQuartz
 * @Description:JLFQuartz api
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public interface JLFQuartz extends JLFProductServerApi {

	/**
	 * 
	 * @Title: saveJob
	 * @Description:����job
	 * @param templateId
	 * @param billId
	 * @param core
	 * @param enabled
	 * @param params
	 */
	public void saveJob(Long templateId, Long billId, String core, BooleanType enabled, JLFJson params);

	/**
	 * 
	 * @Title: updateJob
	 * @Description:����job
	 * @param id
	 * @param version
	 * @param templateId
	 * @param billId
	 * @param core
	 * @param enabled
	 * @param params
	 */
	public void updateJob(Long id, Long version, Long templateId, Long billId, String core, BooleanType enabled,
			JLFJson params);

	/**
	 * 
	 * @Title: deleteJob
	 * @Description:ɾ��job
	 * @param id
	 * @param version
	 */
	public void deleteJob(Long id, Long version);

	/**
	 * 
	 * @Title: enabledJob
	 * @Description:����job
	 * @param id
	 * @param version
	 */
	public void enabledJob(Long id, Long version);

	/**
	 * 
	 * @Title: disabledJob
	 * @Description:����job
	 * @param id
	 * @param version
	 */
	public void disabledJob(Long id, Long version);

}
