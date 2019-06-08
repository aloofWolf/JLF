package org.jlf.plugin.cache.server.api;

import java.io.Serializable;

import org.jlf.core.api.JLFIPlugin;

/**
 * 
 * @ClassName: JLFCache
 * @Description: cacheApi
 * @author Lone Wolf
 * @date 2019��5��31��
 */
public interface JLFCache extends JLFIPlugin {

	/**
	 * 
	 * @Title: save
	 * @Description:���ַ����浽����
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void save(String key, String value) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:�����л�����浽����
	 * @param key
	 * @param bean
	 * @throws Exception
	 */
	public void save(String key, Serializable bean) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:���ַ����浽����,���趨��Ч��
	 * @param key
	 * @param value
	 * @param seconds
	 * @throws Exception
	 */
	public void save(String key, String value, int seconds) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:�����л�����浽����,���趨��Ч��
	 * @param key
	 * @param bean
	 * @param seconds
	 * @throws Exception
	 */
	public void save(String key, Serializable bean, int seconds) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:�������е��ַ�������
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void update(String key, String value) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:�������е����л��������
	 * @param key
	 * @param bean
	 * @throws Exception
	 */
	public void update(String key, Serializable bean) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:�������е��ַ�������,���趨��Ч��
	 * @param key
	 * @param value
	 * @param seconds
	 * @throws Exception
	 */
	public void update(String key, String value, int seconds) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:�������е����л��������,���趨��Ч��
	 * @param key
	 * @param bean
	 * @param seconds
	 * @throws Exception
	 */
	public void update(String key, Serializable bean, int seconds) throws Exception;

	/**
	 * 
	 * @Title: getString
	 * @Description:�ӻ�����ȡ���ַ���
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getString(String key) throws Exception;

	/**
	 * 
	 * @Title: getObj
	 * @Description:�ӻ�����ȡ�����л�����
	 * @param key
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public <T extends Serializable> T getObj(String key, Class<T> cls) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:���ַ���������뻺��
	 * @param key
	 * @param values
	 * @throws Exception
	 */
	public void save(String key, String... values) throws Exception;

	/**
	 * 
	 * @Title: add
	 * @Description:�򻺴��е��ַ������������ֵ
	 * @param key
	 * @param values
	 * @throws Exception
	 */
	public void add(String key, String... values) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:���ַ���������뻺��,���趨��Ч��
	 * @param key
	 * @param seconds
	 * @param values
	 * @throws Exception
	 */
	public void save(String key, int seconds, String... values) throws Exception;

	/**
	 * 
	 * @Title: add
	 * @Description:�򻺴��е��ַ������������ֵ,���趨��Ч��
	 * @param key
	 * @param seconds
	 * @param values
	 * @throws Exception
	 */
	public void add(String key, int seconds, String... values) throws Exception;

	/**
	 * 
	 * @Title: getArrSize
	 * @Description:��ȡ����������Ĵ�С
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public int getArrSize(String key) throws Exception;

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ��key
	 * @param key
	 * @throws Exception
	 */
	public void delete(String key) throws Exception;

	/**
	 * 
	 * @Title: setKeyPeriod
	 * @Description:�趨key����Ч��
	 * @param key
	 * @throws Exception
	 */
	public void setKeyPeriod(String key,int seconds) throws Exception;

}
