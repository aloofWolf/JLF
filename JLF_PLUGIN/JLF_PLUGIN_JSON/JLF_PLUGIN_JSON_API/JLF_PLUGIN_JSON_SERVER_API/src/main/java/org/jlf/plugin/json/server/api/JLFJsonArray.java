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
	 * @throws Exception 
	 */
	public void add(JLFJson json) throws Exception;

	/**
	 * 
	 * @Title: remove
	 * @Description:从数组中移除值
	 * @param json
	 */
	public void remove(JLFJson json) throws Exception;

	/**
	 * 
	 * @Title: get
	 * @Description:根据index获取json对象
	 * @param index
	 * @return
	 */
	public JLFJson get(int index) throws Exception;

	/**
	 * 
	 * @Title: getJsonArray
	 * @Description:根据index获取json数组
	 * @param index
	 * @return
	 */
	public JLFJsonArray getJsonArray(int index) throws Exception;
	

}
