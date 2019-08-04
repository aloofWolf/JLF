package org.jlf.core.exception;

/**
 * 
 * @ClassName: JLFException
 * @Description:JLF����쳣
 * @author Lone Wolf
 * @date 2019��5��22��
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
