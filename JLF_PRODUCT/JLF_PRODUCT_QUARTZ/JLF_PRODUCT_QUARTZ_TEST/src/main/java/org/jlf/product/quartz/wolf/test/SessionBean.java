package org.jlf.product.quartz.wolf.test;

import org.jlf.plugin.session.user.api.JLFSessionBean;

/**
 * 
 * @ClassName: SessionBean
 * @Description:SessionBean
 * @author Lone Wolf
 * @date 2019Äê6ÔÂ4ÈÕ
 */
public class SessionBean extends JLFSessionBean {

	private static final long serialVersionUID = 8174920874360831344L;

	private Long deptId;

	private Long postId;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "SessionBean [deptId=" + deptId + ", postId=" + postId + ", toString()=" + super.toString() + "]";
	}

}
