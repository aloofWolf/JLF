package org.jlf.core.exception;

import org.jlf.common.util.LogUtil;

/**
 * 
 * @ClassName: JLFException
 * @Description:JLF����쳣
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class JLFException extends RuntimeException {

	private static final long serialVersionUID = -8160733995315079111L;
	
	private static ThreadLocal<String> exceptionMsg = new ThreadLocal<String>();

	public JLFException(String message) {
		super(message);
		exceptionMsg.set(message);
		LogUtil.get().error(message);
	}

	public JLFException(Exception e) {
		super(e);
		LogUtil.get().error(e.getMessage(),e);
	}
	
	public JLFException(Throwable e) {
		super(e);
		LogUtil.get().error(e.getMessage(),e);
	}

	public static String getExceptionMsg(){
		return exceptionMsg.get();
	}
	
	public static void deleteExceptionMsg(){
		exceptionMsg.set(null);
	}
}
