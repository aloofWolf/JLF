package org.jlf.common.enums.api;

public interface IEnum {

	/**
	 * 枚举操作的异常信息
	 */
	public String idNoExistExceptionMessage = "枚举%s不存在此id:%d";

	/**
	 * @Title: getId
	 * @Description:获取枚举id
	 * @return
	 */
	public Integer getId();

	/**
	 * 
	 * @Title: getDesc
	 * @Description:获取枚举描述信息
	 * @return
	 */
	public String getDesc();

}
