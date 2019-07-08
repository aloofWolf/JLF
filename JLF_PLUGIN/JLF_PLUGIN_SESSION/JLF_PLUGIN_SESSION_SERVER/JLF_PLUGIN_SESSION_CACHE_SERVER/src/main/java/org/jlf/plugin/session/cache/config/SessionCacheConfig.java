package org.jlf.plugin.session.cache.config;

import org.jlf.common.exception.JLFException;
import org.jlf.plugin.check.server.api.JLFCheckAnn;
import org.jlf.plugin.session.user.api.JLFSessionBean;

/**
 * 
 * @ClassName: SessionCacheConfig
 * @Description:SessionCache配置信息
 * @author Lone Wolf
 * @date 2019年5月31日
 */
public class SessionCacheConfig {

	@JLFCheckAnn
	private Integer timeOut; // session超时时间
	@JLFCheckAnn
	private String sessionBeanClsName; // sessionBean的classname
	@JLFCheckAnn(isSkipValidate = true)
	private Class<?> sessionBeanCls;

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public String getSessionBeanClsName() {
		return sessionBeanClsName;
	}

	public void setSessionBeanClsName(String sessionBeanClsName) {
		try {
			this.sessionBeanCls = Class.forName(sessionBeanClsName);
			if (!JLFSessionBean.class.isAssignableFrom(this.sessionBeanCls)) {
				throw new JLFException("sessionBeanClsName不正确");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new JLFException("sessionBeanClsName不正确");
		}
		this.sessionBeanClsName = sessionBeanClsName;
	}

	public Class<?> getSessionBeanCls() {
		return sessionBeanCls;
	}

	public void setSessionBeanCls(Class<?> sessionBeanCls) {
		this.sessionBeanCls = sessionBeanCls;
	}

}
