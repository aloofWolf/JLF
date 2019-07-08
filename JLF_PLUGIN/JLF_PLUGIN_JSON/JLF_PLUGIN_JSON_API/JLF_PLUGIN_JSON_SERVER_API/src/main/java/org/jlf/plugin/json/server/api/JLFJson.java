package org.jlf.plugin.json.server.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * 
 * @ClassName: JLFJson
 * @Description:json API
 * @author Lone Wolf
 * @date 2019��6��5��
 */
public interface JLFJson {

	/**
	 * 
	 * @Title: toStr
	 * @Description:jsonת�ַ���
	 * @return
	 */
	public String toStr();

	/**
	 * 
	 * @Title: toMap
	 * @Description:jsonתmap
	 * @return
	 */
	public Map<String, Object> toMap();

	/**
	 * 
	 * @Title: toBean
	 * @Description:jsonתbean
	 * @param beanCls
	 * @return
	 */
	public <T> T toBean(Class<T> beanCls);

	/**
	 * 
	 * @Title: put
	 * @Description:��json�и�ֵ
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value);

	/**
	 * 
	 * @Title: put
	 * @Description:��json�����json
	 * @param key
	 * @param value
	 */
	public void put(String key, JLFJson value);

	/**
	 * 
	 * @Title: put
	 * @Description:��json�����value
	 * @param key
	 * @param value
	 */
	public void put(String key, JLFJsonArray value);

	/**
	 * 
	 * @Title: remove
	 * @Description:��json���Ƴ�ָ��key
	 * @param key
	 */
	public void remove(String key);

	/**
	 * 
	 * @Title: get
	 * @Description:����keyȡ����
	 * @param key
	 * @return
	 */
	public <T> T get(String key);

	/**
	 * 
	 * @Title: getStr
	 * @Description:����keyȡ�ַ���value
	 * @param key
	 * @return
	 */
	public String getStr(String key);

	/**
	 * 
	 * @Title: getByte
	 * @Description:ȡbyyeֵ
	 * @param key
	 * @return
	 */
	public Byte getByte(String key);

	/**
	 * 
	 * @Title: getShort
	 * @Description:ȡshortֵ
	 * @param key
	 * @return
	 */
	public Short getShort(String key);

	/**
	 * 
	 * @Title: getInt
	 * @Description:ȡintֵ
	 * @param key
	 * @return
	 */
	public Integer getInt(String key);

	/**
	 * 
	 * @Title: getLong
	 * @Description:ȡlongֵ
	 * @param key
	 * @return
	 */
	public Long getLong(String key);

	/**
	 * 
	 * @Title: getDouble
	 * @Description:ȡdoubleֵ
	 * @param key
	 * @return
	 */
	public Double getDouble(String key);

	/**
	 * 
	 * @Title: getFloat
	 * @Description:ȡfloatֵ
	 * @param key
	 * @return
	 */
	public Float getFloat(String key);

	/**
	 * 
	 * @Title: getBigDecimal
	 * @Description:ȡBigDecimalֵ
	 * 
	 * @param key
	 * @return
	 */
	public BigDecimal getBigDecimal(String key);

	/**
	 * 
	 * @Title: getBoolean
	 * @Description:ȡBooleanֵ
	 * @param key
	 * @return
	 */
	public Boolean getBoolean(String key);

	/**
	 * 
	 * @Title: getDate
	 * @Description:ȡ����
	 * @param key
	 * @return
	 */
	public Date getDate(String key);

	/**
	 * 
	 * @Title: getJsonArray
	 * @Description:ȡjson����
	 * @param key
	 * @return
	 */
	public JLFJsonArray getJsonArray(String key);

	/**
	 * 
	 * @Title: getJson
	 * @Description:ȡjson����
	 * @param key
	 * @return
	 */
	public JLFJson getJson(String key);

	/**
	 * 
	 * @Title: size
	 * @Description:��ȡjson�Ĵ�С
	 * @return
	 */
	public int size();

}
