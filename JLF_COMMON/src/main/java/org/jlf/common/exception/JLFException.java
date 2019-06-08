package org.jlf.common.exception;

/**
 * 
 * @ClassName: JAFException
 * @Description:JAF����쳣
 * @author Lone Wolf
 * @date 2019��5��22��
 */
public class JLFException extends Exception {

	private static final long serialVersionUID = -8160733995315079111L;

	public JLFException(String message) {
		super(message);
	}

	public JLFException(Exception e) {
		super(e);
	}

}
