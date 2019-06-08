package org.jlf.plugin.json.server.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * 
 * @ClassName: JLFJson
 * @Description:json API
 * @author Lone Wolf
 * @date 2019年6月5日
 */
public interface JLFJson {

	/**
	 * 
	 * @Title: toStr
	 * @Description:json转字符串
	 * @return
	 * @throws Exception
	 */
	public String toStr();

	/**
	 * 
	 * @Title: toMap
	 * @Description:json转map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> toMap() throws Exception;

	/**
	 * 
	 * @Title: toBean
	 * @Description:json转bean
	 * @param beanCls
	 * @return
	 * @throws Exception
	 */
	public <T> T toBean(Class<T> beanCls) throws Exception;

	/**
	 * 
	 * @Title: put
	 * @Description:向json中赋值
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void put(String key, Object value) throws Exception;
	
	/**
	 * 
	 * @Title: put
	 * @Description:向json中添加json
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void put(String key, JLFJson value) throws Exception;
	
	/**
	 * 
	 * @Title: put
	 * @Description:向json中添加value
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void put(String key, JLFJsonArray value) throws Exception;

	/**
	 * 
	 * @Title: remove
	 * @Description:从json中移除指定key
	 * @param key
	 * @throws Exception
	 */
	public void remove(String key) throws Exception;

	/**
	 * 
	 * @Title: get
	 * @Description:根据key取对象
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public <T> T get(String key) throws Exception;

	/**
	 * 
	 * @Title: getStr
	 * @Description:根据key取字符串value
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getStr(String key) throws Exception;

	/**
	 * 
	 * @Title: getByte
	 * @Description:取byye值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Byte getByte(String key) throws Exception;

	/**
	 * 
	 * @Title: getShort
	 * @Description:取short值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Short getShort(String key) throws Exception;

	/**
	 * 
	 * @Title: getInt
	 * @Description:取int值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Integer getInt(String key) throws Exception;

	/**
	 * 
	 * @Title: getLong
	 * @Description:取long值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long getLong(String key) throws Exception;

	/**
	 * 
	 * @Title: getDouble
	 * @Description:取double值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Double getDouble(String key) throws Exception;

	/**
	 * 
	 * @Title: getFloat
	 * @Description:取float值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Float getFloat(String key) throws Exception;

	/**
	 * 
	 * @Title: getBigDecimal
	 * @Description:取BigDecimal值
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public BigDecimal getBigDecimal(String key) throws Exception;

	/**
	 * 
	 * @Title: getBoolean
	 * @Description:取Boolean值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Boolean getBoolean(String key) throws Exception;

	/**
	 * 
	 * @Title: getDate
	 * @Description:取日期
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Date getDate(String key) throws Exception;

	/**
	 * 
	 * @Title: getJsonArray
	 * @Description:取json数组
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public JLFJsonArray getJsonArray(String key) throws Exception;

	/**
	 * 
	 * @Title: getJson
	 * @Description:取json对象
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public JLFJson getJson(String key) throws Exception;

	/**
	 * 
	 * @Title: size
	 * @Description:获取json的大小
	 * @return
	 * @throws Exception
	 */
	public int size() throws Exception;

}
