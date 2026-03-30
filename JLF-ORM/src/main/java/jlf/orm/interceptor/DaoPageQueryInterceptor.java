package jlf.orm.interceptor;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lone Wolf
 * @ClassName: DaoPageQueryInterceptor
 * @Description: 分页拦截器
 * @date 2023年11月28日
 */
@Configuration
public class DaoPageQueryInterceptor {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加：分页插件
        // 参数：new PaginationInnerInterceptor(DbType.MYSQL)，是专门为mysql定制实现的内部的分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

}
