package org.jlf.common.util.concurrent;

/**
 * 
 * @ClassName: ConcurrentResult
 * @Description:并发操作返回结果
 * @author Lone Wolf
 * @date 2019年8月11日
 */
public class ConcurrentResult {

	private Long time; // 花费时间,返回毫秒数
	private Integer successNum; // 执行成功数量

	public ConcurrentResult(Long time, Integer successNum) {
		this.time = time;
		this.successNum = successNum;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getSuccessNum() {
		return successNum;
	}

	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}

}
