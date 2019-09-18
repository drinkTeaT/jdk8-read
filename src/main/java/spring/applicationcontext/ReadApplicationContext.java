package spring.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.loadbean.Car;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-09 22:00
 **/
public class ReadApplicationContext {
    public static void main(String[] args) {
        LoadBean.readFromXML();
    }

    /**
     * 读取bean
     */
    private static class LoadBean {
        /**
         * xml的方式
         */
        static void readFromXML() {
            ApplicationContext context = new ClassPathXmlApplicationContext("fakebean");
            Car car = (Car) context.getBean("car");
            System.out.println(car.toString());
        }
    }
}
