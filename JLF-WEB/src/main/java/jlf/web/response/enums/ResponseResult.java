package jlf.web.response.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import jlf.plus.enums.EnumApi;
import lombok.Getter;

/**
 * 
 * @ClassName: ResponseResult
 * @Description: web接口响应结果
 * @author Lone Wolf
 * @date 2019年9月10日
 */
@Getter
public enum ResponseResult implements EnumApi<Integer> {

	SUCCESS(0, "成功"), FAIL(1, "失败");

	@EnumValue
	private Integer id;

	private String name;

	private ResponseResult(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
