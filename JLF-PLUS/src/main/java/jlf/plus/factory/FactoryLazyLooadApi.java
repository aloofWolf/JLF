package jlf.plus.factory;

import lombok.SneakyThrows;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @ClassName: FactoryLazyLooadApi
 * @Description: 懒加载工厂类接口的抽象实现
 * @author Lone Wolf
 * @date 2019年9月10日
 * @param <K>
 * @param <V>
 */
public abstract class FactoryLazyLooadApi<K, V> implements FactoryApi<K, V> {

	private ConcurrentHashMap<Class<? extends FactoryLazyLooadApi<K, V>>, ConcurrentHashMap<K, V>> globalMap = new ConcurrentHashMap<>();

	/**
	 * 
	 * @Title: getValueClsFullName
	 * @Description: 根据key,获取对应的实现类的class全路径名
	 * @param key
	 * @return
	 */
	public abstract String getValueClsFullName(K key);

	@Override
	public V get(K key) {
		ConcurrentHashMap<K, V> innerMap = globalMap.get(this.getClass());
		if (innerMap == null) {
			initInnerMap();
			innerMap = globalMap.get(this.getClass());
		}

		V value = get(innerMap, key);
		return value;
	}

	/**
	 * 
	 * @Title: initInnerMap
	 * @Description: 初始化innerMap
	 */
	@SuppressWarnings("unchecked")
	protected void initInnerMap() {
		synchronized (this.getClass()) {
			ConcurrentHashMap<K, V> innerMap = globalMap.get(this.getClass());
			if (innerMap == null) {
				innerMap = new ConcurrentHashMap<K, V>();
				globalMap.put((Class<? extends FactoryLazyLooadApi<K, V>>) this.getClass(), innerMap);
			}
		}
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 根据key,从innerMap中取值
	 * @param innerMap
	 * @param key
	 * @return
	 */
	protected V get(ConcurrentHashMap<K, V> innerMap, K key) {
		V value = innerMap.get(key);
		if (value == null) {
			Class<?> valueCls = getValueCls(key);
			value = getValue(innerMap, key, valueCls);

		}
		return value;
	}

	/**
	 * 
	 * @Title: getValueCls
	 * @Description: 根据key，获取对应的接口实现类的class
	 * @param key
	 * @return
	 */
	protected Class<?> getValueCls(K key) {
		String valueClsFullName = getValueClsFullName(key);
		try {
			Class<?> valueCls = Class.forName(valueClsFullName);
			return valueCls;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description: 根据key,生成对应的实现类的对象，并放入innerMap
	 * @param innerMap
	 * @param key
	 * @param valueCls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@SneakyThrows
	protected V getValue(ConcurrentHashMap<K, V> innerMap, K key, Class<?> valueCls) {
		V value;
		if (valueCls == null) {
			value = getDefault();
			innerMap.put(key, value);
			return value;
		}
		synchronized (valueCls) {
			value = innerMap.get(key);
			if (value == null) {
				value = (V) valueCls.newInstance();
				innerMap.put(key, value);
			}
			return value;

		}

	}
}
