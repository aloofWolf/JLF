package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRule
 * @Description:排序规则接口
 * @author Lone Wolf
 * @date 2019年7月4日
 * @param <T>
 */
public interface SortRule<T extends Object> {

	/**
	 * 
	 * @Title: compare
	 * @Description:排序规则
	 * @param t1
	 * @param t2
	 * @return
	 */
	public boolean compare(T t1, T t2);

}
