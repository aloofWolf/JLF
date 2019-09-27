package org.jlf.soa.mvc.metadata.threadLocal;

import javax.servlet.AsyncContext;

/**
 * 
 * @ClassName: JLFMVCThreadLocal
 * @Description:当前线程的ThreadLocal变量
 * @author Lone Wolf
 * @date 2019年6月1日
 */
public class JLFMVCThreadLocal {

	/**
	 * 当前线程以及子线程的dbName
	 */
	private static InheritableThreadLocal<String> dbName = new InheritableThreadLocal<String>();// 当前session保存的实体
	
	/**
	 * 当前线程以及子线程的asyncContext
	 */
	private static InheritableThreadLocal<AsyncContext> asyncContext = new InheritableThreadLocal<AsyncContext>();// 当前session保存的实体

	/**
	 * 
	 * @Title: get
	 * @Description:获取当前线程的dbName
	 * @return
	 */
	public static String getDbName() {
		return dbName.get();
	}

	/**
	 * 
	 * @Title: set
	 * @Description:设置当前线程的dbName
	 * @param value
	 */
	public static void setDbName(String value) {
		dbName.set(value);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description:删除当前线程的dbName
	 */
	public static void deleteDbName() {
		dbName.remove();
	}
	
	/**
	 * 
	 * @Title: getAsyncContext
	 * @Description:获取当前线程的asyncContext
	 * @return
	 */
	public static AsyncContext getAsyncContext() {
		return asyncContext.get();
	}

	/**
	 * 
	 * @Title: setAsyncContext
	 * @Description:设置当前线程的asyncContext
	 * @param value
	 */
	public static void setAsyncContext(AsyncContext value) {
		asyncContext.set(value);
	}

	/**
	 * 
	 * @Title: deleteAsyncContext
	 * @Description:删除当前线程的asyncContext
	 */
	public static void deleteAsyncContext() {
		asyncContext.remove();
	}
}
