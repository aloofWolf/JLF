package org.jlf.core.exception;

/**
 * 
 * @ClassName: JLFException
 * @Description:JLF框架异常
 * @author Lone Wolf
 * @date 2019年5月22日
 */
public class JLFException extends RuntimeException {

	private static final long serialVersionUID = -8160733995315079111L;

	public JLFException(String message) {
		super(message);
	}

	public JLFException(Exception e) {
		super(e);
	}
	
	public JLFException(Throwable e) {
		super(e);
	}

}
