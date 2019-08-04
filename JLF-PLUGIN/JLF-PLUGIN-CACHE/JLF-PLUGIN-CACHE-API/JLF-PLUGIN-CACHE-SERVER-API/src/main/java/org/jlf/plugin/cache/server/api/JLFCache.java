package org.jlf.plugin.cache.server.api;

import java.io.Serializable;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFCache
 * @Description: cacheApi
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFCache extends JLFPluginServerApi {
	
	public static final String PLUGIN_NAME = "cache";

	/**
	 * 
	 * @Title: save
	 * @Description:���ַ����浽����
	 * @param key
	 * @param value
	 */
	public void save(String key, String value);

	/**
	 * 
	 * @Title: save
	 * @Description:�����л�����浽����
	 * @param key
	 * @param bean
	 */
	public void save(String key, Serializable bean);

	/**
	 * 
	 * @Title: save
	 * @Description:���ַ����浽����,���趨��Ч��
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public void save(String key, String value, int seconds);

	/**
	 * 
	 * @Title: save
	 * @Description:�����л�����浽����,���趨��Ч��
	 * @param key
	 * @param bean
	 * @param seconds
	 */
	public void save(String key, Serializable bean, int seconds);

	/**
	 * 
	 * @Title: update
	 * @Description:�������е��ַ�������
	 * @param key
	 * @param value
	 */
	public void update(String key, String value);

	/**
	 * 
	 * @Title: update
	 * @Description:�������е����л��������
	 * @param key
	 * @param bean
	 */
	public void update(String key, Serializable bean);

	/**
	 * 
	 * @Title: update
	 * @Description:�������е��ַ�������,���趨��Ч��
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public void update(String key, String value, int seconds);

	/**
	 * 
	 * @Title: update
	 * @Description:�������е����л��������,���趨��Ч��
	 * @param key
	 * @param bean
	 * @param seconds
	 */
	public void update(String key, Serializable bean, int seconds);

	/**
	 * 
	 * @Title: getString
	 * @Description:�ӻ�����ȡ���ַ���
	 * @param key
	 * @return
	 */
	public String getString(String key);

	/**
	 * 
	 * @Title: getObj
	 * @Description:�ӻ�����ȡ�����л�����
	 * @param key
	 * @param cls
	 * @return
	 */
	public <T extends Serializable> T getObj(String key, Class<T> cls);

	/**
	 * 
	 * @Title: save
	 * @Description:���ַ���������뻺��
	 * @param key
	 * @param values
	 */
	public void save(String key, String... values);

	/**
	 * 
	 * @Title: add
	 * @Description:�򻺴��е��ַ������������ֵ
	 * @param key
	 * @param values
	 */
	public void add(String key, String... values);

	/**
	 * 
	 * @Title: save
	 * @Description:���ַ���������뻺��,���趨��Ч��
	 * @param key
	 * @param seconds
	 * @param values
	 */
	public void save(String key, int seconds, String... values);

	/**
	 * 
	 * @Title: add
	 * @Description:�򻺴��е��ַ������������ֵ,���趨��Ч��
	 * @param key
	 * @param seconds
	 * @param values
	 */
	public void add(String key, int seconds, String... values);

	/**
	 * 
	 * @Title: getArrSize
	 * @Description:��ȡ����������Ĵ�С
	 * @param key
	 * @return
	 * 
	 */
	public int getArrSize(String key);

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ��key
	 * @param key
	 */
	public void delete(String key);

	/**
	 * 
	 * @Title: setKeyPeriod
	 * @Description:�趨key����Ч��
	 * @param key
	 */
	public void setKeyPeriod(String key, int seconds);

}
