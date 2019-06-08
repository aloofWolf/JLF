package org.jlf.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: LogUtil
 * @Description:log工具类
 * @author Lone Wolf
 * @date 2019年6月4日
 */
public class LogUtil {

	private static Logger log = LoggerFactory.getLogger(LogUtil.class);

	/**
	 * 
	 * @Title: get
	 * @Description:获取logger对象
	 * @return
	 */
	public static Logger get() {
		return log;
	}
}
