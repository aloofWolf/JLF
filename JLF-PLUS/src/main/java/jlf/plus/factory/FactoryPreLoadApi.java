package jlf.plus.factory;


import jlf.util.GenericityUtil;
import jlf.util.packages.PackageUtil;
import jlf.util.packages.filter.PackageUtilFilter;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @ClassName: FactoryPreLoadApi
 * @Description: 复杂工厂类接口的抽象实现
 * @author Lone Wolf
 * @date 2019年9月10日
 * @param <K>
 * @param <V>
 */
public abstract class FactoryPreLoadApi<K, V extends PreLoadInterApi<K>> implements FactoryApi<K, V> {

	private ConcurrentHashMap<Class<? extends FactoryPreLoadApi<K, V>>, HashSet<? extends V>> globalSet = new ConcurrentHashMap<>();

	private ConcurrentHashMap<Class<? extends FactoryPreLoadApi<K, V>>, ConcurrentHashMap<K, V>> globalMap = new ConcurrentHashMap<>();

	/**
	 * 
	 * @Title: getPackageName
	 * @Description: 获取实现类所在的package
	 * @return
	 */
	public abstract String getPackageName();

	@Override
	public V get(K key) {
		ConcurrentHashMap<K, V> innerMap = globalMap.get(this.getClass());
		if (innerMap == null) {
			initInnerMap();
			innerMap = globalMap.get(this.getClass());
		}

		V v = innerMap.get(key);
		if (v != null) {
			return v;
		}
		HashSet<? extends V> innerSet = globalSet.get(this.getClass());
		if (innerSet == null) {
			initInnerSet();
			innerSet = globalSet.get(this.getClass());
		}
		return get(innerSet, innerMap, key);
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
				globalMap.put((Class<? extends FactoryPreLoadApi<K, V>>) this.getClass(), innerMap);
			}
		}
	}

	/**
	 * 
	 * @Title: initInnerSet
	 * @Description: 初始化innerSet
	 */
	@SuppressWarnings("unchecked")
	protected void initInnerSet() {
		synchronized (this.getClass()) {
			HashSet<? extends V> innerSet = globalSet.get(this.getClass());
			if (innerSet == null) {
				innerSet = (HashSet<? extends V>) PackageUtil.getPackageObjs(getPackageName(), HashSet.class,
						getFilter());
			}
			globalSet.put((Class<? extends FactoryPreLoadApi<K, V>>) this.getClass(), innerSet);
		}
	}

	/**
	 * 
	 * @Title: getVCls
	 * @Description: 获取泛型V的class对象
	 * @return
	 */
	private Class<V> getVCls() {
		return GenericityUtil.getObjSuperClsGenerCls(this.getClass(), 1);
	}

	/**
	 * 
	 * @Title: getFilter
	 * @Description: 获取PackageUtilFilter对象,用来过滤掉无效的实现类的class
	 * @return
	 */
	protected PackageUtilFilter getFilter() {
		return new PackageUtilFilter() {
			@Override
			public boolean doFilter(Class<?> cls) {
				Class<?> VCls = getVCls();
				if (!VCls.isAssignableFrom(cls)) {
					return true;
				}
				int getModifiers = cls.getModifiers();
				if (Modifier.isAbstract(getModifiers) || Modifier.isInterface(getModifiers)) {
					return true;
				}
				return false;
			}
		};
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 根据key,则遍历innerSet, 返回能match上的实现类
	 * @param innerSet
	 * @param innerMap
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected V get(HashSet<? extends V> innerSet, ConcurrentHashMap<K, V> innerMap, K key) {

		V v = null;
		for (PreLoadInterApi<K> api : innerSet) {
			if (api.match(key)) {
				v = (V) api;
				break;
			}
		}

		if (v == null) {
			v = getDefault();
		}
		innerMap.put(key, v);
		return v;
	}

}
