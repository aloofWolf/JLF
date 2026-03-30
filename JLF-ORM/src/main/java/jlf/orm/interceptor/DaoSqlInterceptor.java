package jlf.orm.interceptor;

import jlf.orm.metadata.config.OrmConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Component;

import java.sql.Statement;

/**
 * @author Lone Wolf
 * @ClassName: DaoInterceptor
 * @Description: dao拦截器，拦截并打印sql信息
 * @date 2019年9月10日
 */
@Slf4j
@Component
@Intercepts({
        @Signature(method = "query", type = StatementHandler.class, args = {Statement.class, ResultHandler.class}),
        @Signature(method = "queryCursor", type = StatementHandler.class, args = {Statement.class}),
        @Signature(method = "update", type = StatementHandler.class, args = {Statement.class}),
        @Signature(method = "batch", type = StatementHandler.class, args = {Statement.class})})
public class DaoSqlInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = invocation.proceed();
        long endTime = System.currentTimeMillis();
        long consumTime = endTime - startTime;
        if (consumTime > OrmConfig.get().getSqlExecTimeOut()) {
            /**
             * 持久化到数据库或ES
             */
            recordLog(consumTime, invocation);
        }

        return proceed;
    }

    /**
     * @param consumTime
     * @param invocation
     * @Title: printSql
     * @Description: 将sql耗时超过200毫秒的sql打印出来
     */
    public void recordLog(long consumTime, Invocation invocation) {

        if (consumTime > OrmConfig.get().getSqlExecTimeOut()) {
            // 获取查询sql
            RoutingStatementHandler statement = (RoutingStatementHandler) invocation.getTarget();
            String sql = statement.getBoundSql().getSql();
            // 打印日志信息
            log.info("sql执行耗时 {}ms", consumTime);
            log.info("sql is : {}", sql);
        }

    }

}
