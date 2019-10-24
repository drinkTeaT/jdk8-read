package annotation;

/**
 * @Description :
 * @Author : Administrator
 * @Date : 2019-10-24 13:08
 **/
public class ProxyLauncher {
    public static void main(String[] args) {
        IHello hello = (IHello) ProxyFactory.proxyObject(new Hello());
        hello.sayHi();
    }
}
