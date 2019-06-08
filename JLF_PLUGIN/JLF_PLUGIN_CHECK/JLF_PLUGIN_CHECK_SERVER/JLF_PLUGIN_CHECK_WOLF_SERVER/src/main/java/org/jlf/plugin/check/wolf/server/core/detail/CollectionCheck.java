package org.jlf.plugin.check.wolf.server.core.detail;

import java.lang.reflect.Field;

import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: CollectionCheck
 * @Description:��������У��
 * @author Lone Wolf
 * @date 2019��5��24��
 * @param <C>
 */
public abstract class CollectionCheck<C extends Object> extends ICheck<C> {

	/**
	 * 
	 * @Title: getSize
	 * @Description:��ȡ���ϵ�size
	 * @param value
	 * @return
	 */
	protected abstract int getSize(C value);

	/**
	 * 
	 * @Title: checkMaxLength
	 * @Description:������󳤶�У��
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkMaxLength(JLFCheckAnn ann, Field field, C value) throws Exception {
		if (value != null) {
			int maxLength = ann.maxLength();
			if (getSize(value) > maxLength) {
				throw new Exception(getExceptionDesc(ann, field, MAX_LENGTH_EXCEPTION_DESC));
			}
		}

	}

	/**
	 * 
	 * @Title: checkMinLength
	 * @Description:������С����У��
	 * @param ann
	 * @param field
	 * @param value
	 * @throws Exception
	 */
	@JLFCheckAnn
	public void checkMinLength(JLFCheckAnn ann, Field field, C value) throws Exception {
		if (value != null) {
			int minLength = ann.minLength();
			if (getSize(value) < minLength) {
				throw new Exception(getExceptionDesc(ann, field, MIN_LENGTH_EXCEPTION_DESC));
			}
		}

	}

}
