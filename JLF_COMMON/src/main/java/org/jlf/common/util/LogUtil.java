package org.jlf.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: LogUtil
 * @Description:log������
 * @author Lone Wolf
 * @date 2019��6��4��
 */
public class LogUtil {

	private static Logger log = LoggerFactory.getLogger(LogUtil.class);

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡlogger����
	 * @return
	 */
	public static Logger get() {
		return log;
	}
}
