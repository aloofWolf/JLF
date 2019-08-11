package org.jlf.soa.mvc.metadata.response;

import org.jlf.soa.mvc.metadata.enums.JLFMVCOperatorResult;

/**
 * 
 * @ClassName: JLFMVCResponse
 * @Description:��Ӧ����������Ϣ
 * @author Lone Wolf
 * @date 2019��5��25��
 */
public final class JLFMVCResponse<T extends Object> {

	private JLFMVCOperatorResult result; // ������
	private String message; // ���󷵻���Ϣ
	private T resp;

	public JLFMVCResponse() {
		this.result = JLFMVCOperatorResult.SUCCESS;
		this.message = "�����ɹ�";
	}
	
	public JLFMVCResponse(T resp) {
		this.result = JLFMVCOperatorResult.SUCCESS;
		this.message = "�����ɹ�";
		this.resp = resp;
	}

	public JLFMVCResponse(JLFMVCOperatorResult result, String message) {
		this.result = result;
		this.message = message;
	}

	public JLFMVCOperatorResult getResult() {
		return result;
	}

	public void setResult(JLFMVCOperatorResult result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getResp() {
		return resp;
	}

	public void setResp(T resp) {
		this.resp = resp;
	}

	@Override
	public String toString() {
		return "BaseResponse [result=" + result + ", message=" + message + "]";
	}

}
