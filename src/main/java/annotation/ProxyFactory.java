package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;

/**
 * @Description :
 * @Author : Administrator
 * @Date : 2019-10-24 13:05
 **/
public class ProxyFactory {
    public static Object proxyObject(Object obj){
        Annotation annotation = obj.getClass().getMethods()[0].getAnnotations()[0];
        obj = Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new TimeCountHandler(new Hello()));
        return obj;
    }
}
