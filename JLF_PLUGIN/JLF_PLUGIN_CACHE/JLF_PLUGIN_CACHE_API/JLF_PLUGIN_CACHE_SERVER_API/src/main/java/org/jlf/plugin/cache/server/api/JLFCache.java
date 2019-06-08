package org.jlf.plugin.cache.server.api;

import java.io.Serializable;

import org.jlf.core.api.JLFIPlugin;

/**
 * 
 * @ClassName: JLFCache
 * @Description: cacheApi
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public interface JLFCache extends JLFIPlugin {

	/**
	 * 
	 * @Title: save
	 * @Description:将字符串存到缓存
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void save(String key, String value) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:将序列化对象存到缓存
	 * @param key
	 * @param bean
	 * @throws Exception
	 */
	public void save(String key, Serializable bean) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:将字符串存到缓存,并设定有效期
	 * @param key
	 * @param value
	 * @param seconds
	 * @throws Exception
	 */
	public void save(String key, String value, int seconds) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:将序列化对象存到缓存,并设定有效期
	 * @param key
	 * @param bean
	 * @param seconds
	 * @throws Exception
	 */
	public void save(String key, Serializable bean, int seconds) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:将缓存中的字符串更新
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void update(String key, String value) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:将缓存中的序列化对象更新
	 * @param key
	 * @param bean
	 * @throws Exception
	 */
	public void update(String key, Serializable bean) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:将缓存中的字符串更新,并设定有效期
	 * @param key
	 * @param value
	 * @param seconds
	 * @throws Exception
	 */
	public void update(String key, String value, int seconds) throws Exception;

	/**
	 * 
	 * @Title: update
	 * @Description:将缓存中的序列化对象更新,并设定有效期
	 * @param key
	 * @param bean
	 * @param seconds
	 * @throws Exception
	 */
	public void update(String key, Serializable bean, int seconds) throws Exception;

	/**
	 * 
	 * @Title: getString
	 * @Description:从缓存中取出字符串
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getString(String key) throws Exception;

	/**
	 * 
	 * @Title: getObj
	 * @Description:从缓存中取出序列化对象
	 * @param key
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public <T extends Serializable> T getObj(String key, Class<T> cls) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:将字符串数组存入缓存
	 * @param key
	 * @param values
	 * @throws Exception
	 */
	public void save(String key, String... values) throws Exception;

	/**
	 * 
	 * @Title: add
	 * @Description:向缓存中的字符串数组中添加值
	 * @param key
	 * @param values
	 * @throws Exception
	 */
	public void add(String key, String... values) throws Exception;

	/**
	 * 
	 * @Title: save
	 * @Description:将字符串数组存入缓存,并设定有效期
	 * @param key
	 * @param seconds
	 * @param values
	 * @throws Exception
	 */
	public void save(String key, int seconds, String... values) throws Exception;

	/**
	 * 
	 * @Title: add
	 * @Description:向缓存中的字符串数组中添加值,并设定有效期
	 * @param key
	 * @param seconds
	 * @param values
	 * @throws Exception
	 */
	public void add(String key, int seconds, String... values) throws Exception;

	/**
	 * 
	 * @Title: getArrSize
	 * @Description:获取缓存中数组的大小
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public int getArrSize(String key) throws Exception;

	/**
	 * 
	 * @Title: delete
	 * @Description:删除key
	 * @param key
	 * @throws Exception
	 */
	public void delete(String key) throws Exception;

	/**
	 * 
	 * @Title: setKeyPeriod
	 * @Description:设定key的有效期
	 * @param key
	 * @throws Exception
	 */
	public void setKeyPeriod(String key,int seconds) throws Exception;

}
