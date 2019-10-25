package annotation;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description :
 * @Author : Administrator
 * @Date : 2019-10-24 13:08
 **/
public class ProxyLauncher {
    public static void main(String[] args) {
        IHello hello = (IHello) ProxyFactory.proxyObject(new Hello());
        hello.sayHi();
        hello.sayBye();
    }
}

interface IHello {
    public void sayHi();

    public void sayBye();
}

class Hello implements IHello {
//    @NoticeBeforeOperation
    public void sayHi() {
        System.out.println("hello world!");
    }

//    @NoticeBeforeOperation
    @Override
    public void sayBye() {
        System.out.println("bye");
    }
}

abstract class MyBeforeHandler implements InvocationHandler {
    private Object target;

    public MyBeforeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method implMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        Annotation[] annotations = implMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof NoticeBeforeOperation) {
                beforeOperation();
            }
        }
        Object obj = method.invoke(target, args);
        return obj;
    }

    public abstract void beforeOperation();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface NoticeBeforeOperation {
}

class ProxyFactory {

    public static Object proxyObject(Object obj) {
        obj = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new MyBeforeHandler(obj) {
            @Override
            public void beforeOperation() {
                System.out.println("time " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 执行");
            }
        });
        return obj;
    }
}