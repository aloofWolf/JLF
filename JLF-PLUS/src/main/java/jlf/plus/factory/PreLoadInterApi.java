package jlf.plus.factory;

/**
 * 
 * @ClassName: PreLoadInterApi
 * @Description: PreLoadInterApi
 * @author Lone Wolf
 * @date 2019年9月10日
 * @param <K>
 */
public interface PreLoadInterApi<K> {

	/**
	 * 
	 * @Title: match
	 * @Description: 判断是否匹配key
	 * @param key
	 * @return
	 */
	public boolean match(K key);
}
