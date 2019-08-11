package org.jlf.common.util.concurrent;

/**
 * 
 * @ClassName: ConcurrentResult
 * @Description:�����������ؽ��
 * @author Lone Wolf
 * @date 2019��8��11��
 */
public class ConcurrentResult {

	private Long time; // ����ʱ��,���غ�����
	private Integer successNum; // ִ�гɹ�����

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
