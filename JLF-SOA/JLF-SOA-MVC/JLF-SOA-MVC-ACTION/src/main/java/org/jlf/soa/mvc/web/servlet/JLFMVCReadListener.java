package org.jlf.soa.mvc.web.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

import org.jlf.common.util.LogUtil;

public class JLFMVCReadListener implements ReadListener{
	
	private AsyncContext asyncContext;
	private ServletInputStream inputStream;
	private ServletOutputStream outputStream;
	private String paramsStr;
	
	public JLFMVCReadListener(AsyncContext asyncContext,ServletInputStream inputStream,ServletOutputStream outputStream){
		this.asyncContext = asyncContext;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}


	@Override
	public void onDataAvailable() throws IOException {
		LogUtil.get().debug("JLFMVCParamsFilter过滤器开始执行.......");
		int len = -1;
		byte b[] = new byte[1024];
		while (inputStream.isReady() && (len = inputStream.read(b)) != -1) {
			paramsStr = new String(b, 0, len,"UTF-8");
		}
		
		LogUtil.get().debug("JLFMVCParamsFilter过滤器执行结束.......");
	}

	@Override
	public void onAllDataRead() throws IOException {
		
		JLFMVCThreadPool.submit(asyncContext,paramsStr,outputStream);
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
