package org.jlf.plugin.cache.server.api;

import java.io.Serializable;

import org.jlf.core.api.JLFPluginServerApi;

/**
 * 
 * @ClassName: JLFCache
 * @Description: cacheApi
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public interface JLFCache extends JLFPluginServerApi {
	
	public static final String PLUGIN_NAME = "cache";

	/**
	 * 
	 * @Title: save
	 * @Description:将字符串存到缓存
	 * @param key
	 * @param value
	 */
	public void save(String key, String value);

	/**
	 * 
	 * @Title: save
	 * @Description:将序列化对象存到缓存
	 * @param key
	 * @param bean
	 */
	public void save(String key, Serializable bean);

	/**
	 * 
	 * @Title: save
	 * @Description:将字符串存到缓存,并设定有效期
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public void save(String key, String value, int seconds);

	/**
	 * 
	 * @Title: save
	 * @Description:将序列化对象存到缓存,并设定有效期
	 * @param key
	 * @param bean
	 * @param seconds
	 */
	public void save(String key, Serializable bean, int seconds);

	/**
	 * 
	 * @Title: update
	 * @Description:将缓存中的字符串更新
	 * @param key
	 * @param value
	 */
	public void update(String key, String value);

	/**
	 * 
	 * @Title: update
	 * @Description:将缓存中的序列化对象更新
	 * @param key
	 * @param bean
	 */
	public void update(String key, Serializable bean);

	/**
	 * 
	 * @Title: update
	 * @Description:将缓存中的字符串更新,并设定有效期
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public void update(String key, String value, int seconds);

	/**
	 * 
	 * @Title: update
	 * @Description:将缓存中的序列化对象更新,并设定有效期
	 * @param key
	 * @param bean
	 * @param seconds
	 */
	public void update(String key, Serializable bean, int seconds);

	/**
	 * 
	 * @Title: getString
	 * @Description:从缓存中取出字符串
	 * @param key
	 * @return
	 */
	public String getString(String key);

	/**
	 * 
	 * @Title: getObj
	 * @Description:从缓存中取出序列化对象
	 * @param key
	 * @param cls
	 * @return
	 */
	public <T extends Serializable> T getObj(String key, Class<T> cls);

	/**
	 * 
	 * @Title: save
	 * @Description:将字符串数组存入缓存
	 * @param key
	 * @param values
	 */
	public void save(String key, String... values);

	/**
	 * 
	 * @Title: add
	 * @Description:向缓存中的字符串数组中添加值
	 * @param key
	 * @param values
	 */
	public void add(String key, String... values);

	/**
	 * 
	 * @Title: save
	 * @Description:将字符串数组存入缓存,并设定有效期
	 * @param key
	 * @param seconds
	 * @param values
	 */
	public void save(String key, int seconds, String... values);

	/**
	 * 
	 * @Title: add
	 * @Description:向缓存中的字符串数组中添加值,并设定有效期
	 * @param key
	 * @param seconds
	 * @param values
	 */
	public void add(String key, int seconds, String... values);

	/**
	 * 
	 * @Title: getArrSize
	 * @Description:获取缓存中数组的大小
	 * @param key
	 * @return
	 * 
	 */
	public int getArrSize(String key);

	/**
	 * 
	 * @Title: delete
	 * @Description:删除key
	 * @param key
	 */
	public void delete(String key);

	/**
	 * 
	 * @Title: setKeyPeriod
	 * @Description:设定key的有效期
	 * @param key
	 */
	public void setKeyPeriod(String key, int seconds);

}
