package spring.loadbean;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.File;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-08 18:02
 **/
public class ReadBeanFactory {
    public static void main(String[] args) {
        BeanInstanceLife.life();
    }

    /*** bean实例化的生命周期*/
    private static class BeanInstanceLife {
        /*** DefaultListableBeanFactory是beanfactory默认的bean工厂 */
        static void life() {
            System.out.println(new File("fakebean").exists());
            ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
            Resource resource = resourcePatternResolver.getResource("classpath:fakebean");
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
            reader.loadBeanDefinitions(resource);
            // bean开始实例化，生命周期开始
            Car car = factory.getBean("car", Car.class);
            Car car1 = factory.getBean("car", Car.class);
            System.out.println("第一次加载bean" + car.toString());
            System.out.println("第二次加载bean" + car1.toString());
        }
    }
}
