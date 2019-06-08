package org.jlf.product.workflow.user.api;

public interface JLFBusinessService {
	
	public void doPass(Long billId);
	
	public void doReject(Long billId);
	
	public void getTableName();
	
	public void getTableNameAlias();
	
	public void getIdField();
	
	public String getBussinessFields();

}
