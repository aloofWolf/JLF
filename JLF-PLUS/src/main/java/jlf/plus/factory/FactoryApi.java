package jlf.plus.factory;

/**
 * 
 * @ClassName: FactoryApi
 * @Description: 工程类api
 * @author Lone Wolf
 * @date 2019年9月10日
 * @param <K>
 * @param <V>
 */
public interface FactoryApi<K, V> {
	
	/**
	 * 
	 * @Title: get
	 * @Description: 根据key匹配到对应的接口实现类
	 * @param key
	 * @return
	 */
	public V get(K key);
	

	/**
	 * 
	 * @Title: getDefault
	 * @Description: 接口的默认实现,如果根据key匹配不到到对应的实现类,则返回此默认实现
	 * @return
	 */
	public V getDefault();

	

}
