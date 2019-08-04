package org.jlf.plugin.server.core.threadPool.custom;

import java.util.concurrent.Future;

/**
 * 
 * @ClassName: FutureExt
 * @Description:Future扩展
 * @author Lone Wolf
 * @date 2019年7月5日
 * @param <T>
 */
public class FutureExt<T extends Object> {

	private Future<String> future;
	private T bean;

	public FutureExt(Future<String> future, T bean) {
		this.future = future;
		this.bean = bean;
	}

	public Future<String> getFuture() {
		return future;
	}

	public void setFuture(Future<String> future) {
		this.future = future;
	}

	public T getBean() {
		return bean;
	}

	public void setBean(T bean) {
		this.bean = bean;
	}

}
