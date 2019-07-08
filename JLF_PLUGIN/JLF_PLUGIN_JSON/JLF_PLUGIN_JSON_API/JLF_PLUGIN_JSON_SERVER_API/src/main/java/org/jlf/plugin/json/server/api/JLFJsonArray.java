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
	 */
	public void add(JLFJson json);

	/**
	 * 
	 * @Title: remove
	 * @Description:���������Ƴ�ֵ
	 * @param json
	 */
	public void remove(JLFJson json);

	/**
	 * 
	 * @Title: get
	 * @Description:����index��ȡjson����
	 * @param index
	 * @return
	 */
	public JLFJson get(int index);

	/**
	 * 
	 * @Title: getJsonArray
	 * @Description:����index��ȡjson����
	 * @param index
	 * @return
	 */
	public JLFJsonArray getJsonArray(int index);

}
