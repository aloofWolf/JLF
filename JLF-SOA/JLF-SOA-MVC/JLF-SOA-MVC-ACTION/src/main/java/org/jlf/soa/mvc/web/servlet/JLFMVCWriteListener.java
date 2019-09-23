package org.jlf.soa.mvc.web.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.WriteListener;

public class JLFMVCWriteListener implements WriteListener {

	private AsyncContext asyncContext;

	public JLFMVCWriteListener(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	@Override
	public void onWritePossible() throws IOException {
		asyncContext.complete();
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub

	}

}
