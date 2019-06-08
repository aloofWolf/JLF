package org.jlf.product.workflow.user.api;

public interface JLFUserService {
	
	public JLFUser getUser(Long userId) throws Exception;
	
	public Long getUpCompanyId(Long companyId);
	
	public String getUserTableName();
	
	public String getUserTableAlias();
	
	public String getUserIdField();
	
	public String getUserNameField();

    public String getPostTableName();
    
    public String getPostTableAlias();
	
	public String getPostIdField();
	
	public String getPostNameField();
	
    public String getDeptTableName();
    
    public String getDeptTableAlias();
	
	public String getDeptIdField();
	
	public String getDeptNameField();
	
    public String getCompanyTableName();
    
    public String getCompanyTableAlias();
	
	public String getCompanyIdField();
	
	public String getCompanyNameField();
	

}
