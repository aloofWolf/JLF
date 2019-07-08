package org.jlf.product.quartz.server.api;

import org.jlf.common.enums.BooleanType;
import org.jlf.core.api.JLFProductServerApi;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFQuartz
 * @Description:JLFQuartz api
 * @author Lone Wolf
 * @date 2019年6月3日
 */
public interface JLFQuartz extends JLFProductServerApi {

	/**
	 * 
	 * @Title: saveJob
	 * @Description:保存job
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
	 * @Description:更新job
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
	 * @Description:删除job
	 * @param id
	 * @param version
	 */
	public void deleteJob(Long id, Long version);

	/**
	 * 
	 * @Title: enabledJob
	 * @Description:启用job
	 * @param id
	 * @param version
	 */
	public void enabledJob(Long id, Long version);

	/**
	 * 
	 * @Title: disabledJob
	 * @Description:禁用job
	 * @param id
	 * @param version
	 */
	public void disabledJob(Long id, Long version);

}
