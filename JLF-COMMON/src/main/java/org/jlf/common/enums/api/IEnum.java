package org.jlf.common.enums.api;

public interface IEnum {

	/**
	 * ö�ٲ������쳣��Ϣ
	 */
	public String idNoExistExceptionMessage = "ö��%s�����ڴ�id:%d";

	/**
	 * @Title: getId
	 * @Description:��ȡö��id
	 * @return
	 */
	public Integer getId();

	/**
	 * 
	 * @Title: getDesc
	 * @Description:��ȡö��������Ϣ
	 * @return
	 */
	public String getDesc();

}
