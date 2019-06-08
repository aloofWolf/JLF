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
	 * @throws Exception
	 */
	public String toStr();

	/**
	 * 
	 * @Title: toMap
	 * @Description:jsonתmap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> toMap() throws Exception;

	/**
	 * 
	 * @Title: toBean
	 * @Description:jsonתbean
	 * @param beanCls
	 * @return
	 * @throws Exception
	 */
	public <T> T toBean(Class<T> beanCls) throws Exception;

	/**
	 * 
	 * @Title: put
	 * @Description:��json�и�ֵ
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void put(String key, Object value) throws Exception;
	
	/**
	 * 
	 * @Title: put
	 * @Description:��json�����json
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void put(String key, JLFJson value) throws Exception;
	
	/**
	 * 
	 * @Title: put
	 * @Description:��json�����value
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void put(String key, JLFJsonArray value) throws Exception;

	/**
	 * 
	 * @Title: remove
	 * @Description:��json���Ƴ�ָ��key
	 * @param key
	 * @throws Exception
	 */
	public void remove(String key) throws Exception;

	/**
	 * 
	 * @Title: get
	 * @Description:����keyȡ����
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public <T> T get(String key) throws Exception;

	/**
	 * 
	 * @Title: getStr
	 * @Description:����keyȡ�ַ���value
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getStr(String key) throws Exception;

	/**
	 * 
	 * @Title: getByte
	 * @Description:ȡbyyeֵ
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Byte getByte(String key) throws Exception;

	/**
	 * 
	 * @Title: getShort
	 * @Description:ȡshortֵ
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Short getShort(String key) throws Exception;

	/**
	 * 
	 * @Title: getInt
	 * @Description:ȡintֵ
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Integer getInt(String key) throws Exception;

	/**
	 * 
	 * @Title: getLong
	 * @Description:ȡlongֵ
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long getLong(String key) throws Exception;

	/**
	 * 
	 * @Title: getDouble
	 * @Description:ȡdoubleֵ
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Double getDouble(String key) throws Exception;

	/**
	 * 
	 * @Title: getFloat
	 * @Description:ȡfloatֵ
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Float getFloat(String key) throws Exception;

	/**
	 * 
	 * @Title: getBigDecimal
	 * @Description:ȡBigDecimalֵ
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public BigDecimal getBigDecimal(String key) throws Exception;

	/**
	 * 
	 * @Title: getBoolean
	 * @Description:ȡBooleanֵ
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Boolean getBoolean(String key) throws Exception;

	/**
	 * 
	 * @Title: getDate
	 * @Description:ȡ����
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Date getDate(String key) throws Exception;

	/**
	 * 
	 * @Title: getJsonArray
	 * @Description:ȡjson����
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public JLFJsonArray getJsonArray(String key) throws Exception;

	/**
	 * 
	 * @Title: getJson
	 * @Description:ȡjson����
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public JLFJson getJson(String key) throws Exception;

	/**
	 * 
	 * @Title: size
	 * @Description:��ȡjson�Ĵ�С
	 * @return
	 * @throws Exception
	 */
	public int size() throws Exception;

}
