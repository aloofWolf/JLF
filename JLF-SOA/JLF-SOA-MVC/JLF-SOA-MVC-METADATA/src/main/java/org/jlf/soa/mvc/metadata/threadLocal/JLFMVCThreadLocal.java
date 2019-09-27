package org.jlf.soa.mvc.metadata.threadLocal;

import javax.servlet.AsyncContext;

/**
 * 
 * @ClassName: JLFMVCThreadLocal
 * @Description:��ǰ�̵߳�ThreadLocal����
 * @author Lone Wolf
 * @date 2019��6��1��
 */
public class JLFMVCThreadLocal {

	/**
	 * ��ǰ�߳��Լ����̵߳�dbName
	 */
	private static InheritableThreadLocal<String> dbName = new InheritableThreadLocal<String>();// ��ǰsession�����ʵ��
	
	/**
	 * ��ǰ�߳��Լ����̵߳�asyncContext
	 */
	private static InheritableThreadLocal<AsyncContext> asyncContext = new InheritableThreadLocal<AsyncContext>();// ��ǰsession�����ʵ��

	/**
	 * 
	 * @Title: get
	 * @Description:��ȡ��ǰ�̵߳�dbName
	 * @return
	 */
	public static String getDbName() {
		return dbName.get();
	}

	/**
	 * 
	 * @Title: set
	 * @Description:���õ�ǰ�̵߳�dbName
	 * @param value
	 */
	public static void setDbName(String value) {
		dbName.set(value);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:ɾ����ǰ�̵߳�dbName
	 */
	public static void deleteDbName() {
		dbName.remove();
	}
	
	/**
	 * 
	 * @Title: getAsyncContext
	 * @Description:��ȡ��ǰ�̵߳�asyncContext
	 * @return
	 */
	public static AsyncContext getAsyncContext() {
		return asyncContext.get();
	}

	/**
	 * 
	 * @Title: setAsyncContext
	 * @Description:���õ�ǰ�̵߳�asyncContext
	 * @param value
	 */
	public static void setAsyncContext(AsyncContext value) {
		asyncContext.set(value);
	}

	/**
	 * 
	 * @Title: deleteAsyncContext
	 * @Description:ɾ����ǰ�̵߳�asyncContext
	 */
	public static void deleteAsyncContext() {
		asyncContext.remove();
	}
}
