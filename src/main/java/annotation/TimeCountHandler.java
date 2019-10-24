package annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description :
 * @Author : Administrator
 * @Date : 2019 10 24 13:01
 **/
public class TimeCountHandler implements InvocationHandler {
    private Object target;

    public TimeCountHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = method.invoke(target, args);
        System.out.println("执行了 " + (System.currentTimeMillis() - start) + " ms");
        return obj;
    }
}
