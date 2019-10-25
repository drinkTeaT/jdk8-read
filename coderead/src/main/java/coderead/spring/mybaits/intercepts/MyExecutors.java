package coderead.spring.mybaits.intercepts;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Executor的拦截
 */
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
@Component// 会废掉setProperties方法
public class MyExecutors implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object obj = invocation.proceed();
        System.out.println("拦截器：" + obj.toString());
        return obj;
    }

    @Override
    public Object plugin(Object target) {// 类的选择器
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("setProperties");
    }
}
