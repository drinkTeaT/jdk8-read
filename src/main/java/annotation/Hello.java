package annotation;

/**
 * @Description :
 * @Author : Administrator
 * @Date : 2019-10-24 13:07
 **/
public class Hello implements IHello {
    @TimeCount
    public void sayHi() {
        System.out.println("hello world!");
        try {
            Thread.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
