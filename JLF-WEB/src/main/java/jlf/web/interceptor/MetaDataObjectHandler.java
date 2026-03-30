package jlf.web.interceptor;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import jlf.plus.threadLocal.ThreadLocalPlus;
import jlf.web.log.bean.RequestLog;
import jlf.web.session.bean.UserSession;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MetaDataObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        RequestLog requestLog = ThreadLocalPlus.get("requestLog");
        UserSession<?> session = ThreadLocalPlus.get("userSession");
        Date date = new Date();
        if(requestLog != null){
            this.strictInsertFill(metaObject,"createRequestLogCode", String.class,requestLog.getCode());
            this.strictInsertFill(metaObject,"updateRequestLogCode", String.class,requestLog.getCode());
        }
        if(session != null){
            this.strictInsertFill(metaObject,"createUserId", Long.class,session.getUserId());
            this.strictInsertFill(metaObject,"createUserName", String.class,session.getUserName());
            this.strictInsertFill(metaObject,"updateUserId", Long.class,session.getUserId());
            this.strictInsertFill(metaObject,"updateUserName", String.class,session.getUserName());
        }
        this.strictInsertFill(metaObject,"createTime", Date.class,date);
        this.strictInsertFill(metaObject,"updateTime", Date.class,date);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        RequestLog requestLog = ThreadLocalPlus.get("requestLog");
        UserSession<?> session = ThreadLocalPlus.get("userSession");
        Date date = new Date();
        if(requestLog != null){
            this.strictUpdateFill(metaObject,"updateRequestLogCode", String.class,requestLog.getCode());
        }
        if(session != null){
            this.strictUpdateFill(metaObject,"updateUserId", Long.class,session.getUserId());
            this.strictUpdateFill(metaObject,"updateUserName", String.class,session.getUserName());
        }
        this.strictUpdateFill(metaObject,"updateTime", Date.class,date);
    }
}
