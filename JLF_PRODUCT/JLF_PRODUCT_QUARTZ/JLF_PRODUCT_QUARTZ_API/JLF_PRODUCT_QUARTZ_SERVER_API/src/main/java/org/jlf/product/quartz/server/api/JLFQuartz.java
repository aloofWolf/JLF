package org.jlf.product.quartz.server.api;

import org.jlf.common.enums.BooleanType;
import org.jlf.core.api.JLFIProduct;
import org.jlf.plugin.json.server.api.JLFJson;

/**
 * 
 * @ClassName: JLFQuartz
 * @Description:JLFQuartz api
 * @author Lone Wolf
 * @date 2019��6��3��
 */
public interface JLFQuartz extends JLFIProduct {

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
	public void saveJob(Long templateId, Long billId, String core, BooleanType enabled, JLFJson params)
			throws Exception;

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
			JLFJson params) throws Exception;

	/**
	 * 
	 * @Title: deleteJob
	 * @Description:ɾ��job
	 * @param id
	 * @param version
	 */
	public void deleteJob(Long id, Long version) throws Exception;

	/**
	 * 
	 * @Title: enableJob
	 * @Description:����job
	 * @param id
	 * @param version
	 */
	public void enableJob(Long id, Long version) throws Exception;

	/**
	 * 
	 * @Title: disableJob
	 * @Description:����job
	 * @param id
	 * @param version
	 */
	public void disableJob(Long id, Long version) throws Exception;

}
