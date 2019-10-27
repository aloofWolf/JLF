package org.jlf.plugin.server.core.rpc.dubbo.config;

import org.jlf.common.enums.BooleanType;
import org.jlf.plugin.check.server.api.JLFCheckAnn;

import com.alibaba.dubbo.config.ArgumentConfig;

/**
 * 
 * @ClassName: DubboMethodArgumentConfig
 * @Description: 方法的参数配置
 * @author Lone Wolf
 * @date 2019年10月26日
 */
public class DubboMethodArgumentConfig {
	
	@JLFCheckAnn(isSkipValidate = true)
	private ArgumentConfig methodArgument = new ArgumentConfig();

	private Integer index = -1;

	private String type;

	@JLFCheckAnn(isNull = true)
	private BooleanType callback;

	public ArgumentConfig getMethodArgument() {
		return methodArgument;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
		methodArgument.setIndex(index);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		methodArgument.setType(type);
	}

	public BooleanType getCallback() {
		return callback;
	}

	public void setCallback(BooleanType callback) {
		this.callback = callback;
		methodArgument.setCallback(callback.isBln());
	}

}
