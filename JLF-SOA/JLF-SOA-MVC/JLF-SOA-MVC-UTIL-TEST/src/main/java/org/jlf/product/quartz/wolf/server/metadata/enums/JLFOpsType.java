package org.jlf.product.quartz.wolf.server.metadata.enums;

import org.jlf.common.enums.api.IEnum;

/**
 * 
 * @ClassName: JLFOpsType
 * @Description:运维类型
 * @author Lone Wolf
 * @date 2019年7月4日
 */
public enum JLFOpsType implements IEnum {

	START(0, "启动服务端"), STOP(1, "停止服务端"), RESTART(2, "重启服务端"), REBIND(3, "客户端重新绑定"), RELOADCONFIG(4, "重新加载配置文件");
	private Integer id;
	private String desc;

	JLFOpsType(Integer id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public Integer getId() {
		return this.id;
	}

	public String getDesc() {
		return desc;
	}

}
