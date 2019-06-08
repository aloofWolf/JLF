package org.jlf.plugin.json.server.api;

/**
 * 
 * @ClassName: JLFJsonArray
 * @Description:json����api
 * @author Lone Wolf
 * @date 2019��6��5��
 */
public interface JLFJsonArray {

	/**
	 * 
	 * @Title: size
	 * @Description:��ȡ�����С
	 * @return
	 */
	public int size();

	/**
	 * �����������ֵ
	 * 
	 * @Title: add
	 * @Description:
	 * @param json
	 * @throws Exception 
	 */
	public void add(JLFJson json) throws Exception;

	/**
	 * 
	 * @Title: remove
	 * @Description:���������Ƴ�ֵ
	 * @param json
	 */
	public void remove(JLFJson json) throws Exception;

	/**
	 * 
	 * @Title: get
	 * @Description:����index��ȡjson����
	 * @param index
	 * @return
	 */
	public JLFJson get(int index) throws Exception;

	/**
	 * 
	 * @Title: getJsonArray
	 * @Description:����index��ȡjson����
	 * @param index
	 * @return
	 */
	public JLFJsonArray getJsonArray(int index) throws Exception;
	

}
