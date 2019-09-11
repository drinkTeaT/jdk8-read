package spring.loadbean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import spring.loadbean.Car;

import java.util.Arrays;

/**
 * Description: 看如何加载注解，怎么解析注解。
 * Author: tacbin
 * Date: 2019-09-10 21:56
 **/
public class ReadBeanFromAnnotation {
    public static void main(String[] args) {
        LoadAnnotationBean.loadBean();
    }

    /**
     * 通过注解的方式加载bean
     */
    private static class LoadAnnotationBean {
        @Autowired
        static Car car;

        static void loadBean() {
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(factory);
            reader.register(BeanConfig.class);
            System.out.println("car's instance " + car);
            Arrays.asList(factory.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
