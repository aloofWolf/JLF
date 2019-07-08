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
	 */
	public String toStr();

	/**
	 * 
	 * @Title: toMap
	 * @Description:json转map
	 * @return
	 */
	public Map<String, Object> toMap();

	/**
	 * 
	 * @Title: toBean
	 * @Description:json转bean
	 * @param beanCls
	 * @return
	 */
	public <T> T toBean(Class<T> beanCls);

	/**
	 * 
	 * @Title: put
	 * @Description:向json中赋值
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value);

	/**
	 * 
	 * @Title: put
	 * @Description:向json中添加json
	 * @param key
	 * @param value
	 */
	public void put(String key, JLFJson value);

	/**
	 * 
	 * @Title: put
	 * @Description:向json中添加value
	 * @param key
	 * @param value
	 */
	public void put(String key, JLFJsonArray value);

	/**
	 * 
	 * @Title: remove
	 * @Description:从json中移除指定key
	 * @param key
	 */
	public void remove(String key);

	/**
	 * 
	 * @Title: get
	 * @Description:根据key取对象
	 * @param key
	 * @return
	 */
	public <T> T get(String key);

	/**
	 * 
	 * @Title: getStr
	 * @Description:根据key取字符串value
	 * @param key
	 * @return
	 */
	public String getStr(String key);

	/**
	 * 
	 * @Title: getByte
	 * @Description:取byye值
	 * @param key
	 * @return
	 */
	public Byte getByte(String key);

	/**
	 * 
	 * @Title: getShort
	 * @Description:取short值
	 * @param key
	 * @return
	 */
	public Short getShort(String key);

	/**
	 * 
	 * @Title: getInt
	 * @Description:取int值
	 * @param key
	 * @return
	 */
	public Integer getInt(String key);

	/**
	 * 
	 * @Title: getLong
	 * @Description:取long值
	 * @param key
	 * @return
	 */
	public Long getLong(String key);

	/**
	 * 
	 * @Title: getDouble
	 * @Description:取double值
	 * @param key
	 * @return
	 */
	public Double getDouble(String key);

	/**
	 * 
	 * @Title: getFloat
	 * @Description:取float值
	 * @param key
	 * @return
	 */
	public Float getFloat(String key);

	/**
	 * 
	 * @Title: getBigDecimal
	 * @Description:取BigDecimal值
	 * 
	 * @param key
	 * @return
	 */
	public BigDecimal getBigDecimal(String key);

	/**
	 * 
	 * @Title: getBoolean
	 * @Description:取Boolean值
	 * @param key
	 * @return
	 */
	public Boolean getBoolean(String key);

	/**
	 * 
	 * @Title: getDate
	 * @Description:取日期
	 * @param key
	 * @return
	 */
	public Date getDate(String key);

	/**
	 * 
	 * @Title: getJsonArray
	 * @Description:取json数组
	 * @param key
	 * @return
	 */
	public JLFJsonArray getJsonArray(String key);

	/**
	 * 
	 * @Title: getJson
	 * @Description:取json对象
	 * @param key
	 * @return
	 */
	public JLFJson getJson(String key);

	/**
	 * 
	 * @Title: size
	 * @Description:获取json的大小
	 * @return
	 */
	public int size();

}
