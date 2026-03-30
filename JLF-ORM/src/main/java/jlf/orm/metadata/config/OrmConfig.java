package jlf.orm.metadata.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Lone Wolf
 * @ClassName: ProjectConfig
 * @Description: 系统配置信息
 * @date 2019年9月10日
 */
@Component
@Getter
public class OrmConfig {

    private static OrmConfig config;

    @Value("${jlf.orm.cachePeriod}")
    private Integer cachePeriod; // 缓存有效期

    @Value("${jlf.orm.sqlExecTimeOut}")
    private Integer sqlExecTimeOut; // sql执行超时时间

    private OrmConfig() {
        config = this;
    }

    public static OrmConfig get() {
        return config;
    }

}
