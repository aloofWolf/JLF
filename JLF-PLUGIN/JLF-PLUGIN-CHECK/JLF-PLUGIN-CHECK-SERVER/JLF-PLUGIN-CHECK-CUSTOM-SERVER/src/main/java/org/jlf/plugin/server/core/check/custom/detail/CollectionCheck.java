package org.jlf.plugin.server.core.check.custom.detail;

import java.lang.reflect.Field;

import org.jlf.core.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

/**
 * 
 * @ClassName: CollectionCheck
 * @Description:集合类型校验
 * @author Lone Wolf
 * @date 2019年5月24日
 * @param <C>
 */
public abstract class CollectionCheck<C extends Object> extends ICheck<C> {

	/**
	 * 
	 * @Title: getSize
	 * @Description:获取集合的size
	 * @param value
	 * @return
	 */
	protected abstract int getSize(C value);

	/**
	 * 
	 * @Title: checkMaxLength
	 * @Description:集合最大长度校验
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void checkMaxLength(JLFCheckAnn ann, Field field, C value) {
		if (value != null) {
			int maxLength = (ann == null ? JLFCheckAnn.maxLength : ann.maxLength());
			if (getSize(value) > maxLength) {
				throw new JLFException(getExceptionDesc(ann, field, MAX_LENGTH_EXCEPTION_DESC));
			}
		}

	}

	/**
	 * 
	 * @Title: checkMinLength
	 * @Description:集合最小长度校验
	 * @param ann
	 * @param field
	 * @param value
	 */
	@JLFCheckAnn
	public void checkMinLength(JLFCheckAnn ann, Field field, C value) {
		if (value != null) {
			int minLength = (ann == null ? JLFCheckAnn.minLength : ann.minLength());
			if (getSize(value) < minLength) {
				throw new JLFException(getExceptionDesc(ann, field, MIN_LENGTH_EXCEPTION_DESC));
			}
		}

	}

}
