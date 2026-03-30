package jlf.plus.async.enums;

import jlf.plus.enums.EnumApi;
import lombok.Getter;

/**
 * @author Lone Wolf
 * @ClassName: BooleanType
 * @Description: boolean类型枚举
 * @date 2023年9月18日
 */
@Getter
public enum BooleanType implements EnumApi<Integer> {
    TRUE(0, true, "是"), FALSE(1, false, "否");

    private Integer id;

    private boolean flag;

    private String name;

    private BooleanType(int id, boolean flag, String name) {
        this.id = id;
        this.flag = flag;
        this.name = name;
    }

}
