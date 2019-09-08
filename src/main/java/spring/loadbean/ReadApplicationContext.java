package spring.loadbean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-08 17:19
 **/
public class ReadApplicationContext {
    public static void main(String[] args) {

    }

    /**
     * ApplicationContext继承类
     */
    private static class SubClass {
        /*** 从文件加载bean */
        static ClassPathXmlApplicationContext classPathXmlApplicationContext;// 构造参数等同于 classpath: path
        static FileSystemXmlApplicationContext systemXmlApplicationContext;// 等同于文件加载器的 file : path

        static {
            classPathXmlApplicationContext = new ClassPathXmlApplicationContext("fakebean");
        }

        /*** 通过注解加载bean */
        static AnnotationConfigApplicationContext annotationConfigApplicationContext;

    }
}
