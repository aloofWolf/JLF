package org.jlf.product.workflow.server.api;

public interface JLFWorkFlow {
	
	public void submit(Long flowVersionId,Integer BusinessId,Long billId)throws Exception;
	
	public void agree(Long runInstanceId,String message)throws Exception;
	
	public void reject(Long runInstanceId,String message)throws Exception;
	
	public void append(Long runInstanceId,String message)throws Exception;

}
