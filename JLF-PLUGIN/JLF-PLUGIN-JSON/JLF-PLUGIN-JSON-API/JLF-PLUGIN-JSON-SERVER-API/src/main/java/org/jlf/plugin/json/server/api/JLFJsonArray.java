package org.jlf.plugin.json.server.api;

/**
 * 
 * @ClassName: JLFJsonArray
 * @Description:json数组api
 * @author Lone Wolf
 * @date 2019年6月5日
 */
public interface JLFJsonArray {

	/**
	 * 
	 * @Title: size
	 * @Description:获取数组大小
	 * @return
	 */
	public int size();

	/**
	 * 向数组中添加值
	 * 
	 * @Title: add
	 * @Description:
	 * @param json
	 */
	public void add(JLFJson json);

	/**
	 * 
	 * @Title: remove
	 * @Description:从数组中移除值
	 * @param json
	 */
	public void remove(JLFJson json);

	/**
	 * 
	 * @Title: get
	 * @Description:根据index获取json对象
	 * @param index
	 * @return
	 */
	public JLFJson get(int index);

	/**
	 * 
	 * @Title: getJsonArray
	 * @Description:根据index获取json数组
	 * @param index
	 * @return
	 */
	public JLFJsonArray getJsonArray(int index);

}
