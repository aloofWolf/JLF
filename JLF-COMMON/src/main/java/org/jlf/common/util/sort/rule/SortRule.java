package org.jlf.common.util.sort.rule;

/**
 * 
 * @ClassName: SortRule
 * @Description:�������ӿ�
 * @author Lone Wolf
 * @date 2019��7��4��
 * @param <T>
 */
public interface SortRule<T extends Object> {

	/**
	 * 
	 * @Title: compare
	 * @Description:�������
	 * @param t1
	 * @param t2
	 * @return
	 */
	public boolean compare(T t1, T t2);

}
