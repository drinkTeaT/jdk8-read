package spring.loadbean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.Arrays;

/**
 * Description: 文件中添加bean的步骤<br>
 * <p/>             1 资源加载器读取并返回资源<br>
 * </p>             2 传入一个bean工厂到Bean注册器中
 * <p/>             3 注册器解析文件并返回该bean工厂
 * caution: 注册到单例
 * Author: tacbin
 * Date: 2019-09-08 12:27
 **/
public class ReadLoadBean {
    public static void main(String[] args) {
        ReadBean.viewSingletonBean();
    }

    static class ReadBean {
        static DefaultListableBeanFactory factory;

        /**
         * 获取bean工厂
         */
        static {
            ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
            Resource resource = resourcePatternResolver.getResource("classpath:fakebean");
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
            reader.loadBeanDefinitions(resource);
            Car car = factory.getBean("car", Car.class);
            System.out.println("加载bean" + car.toString());
            ReadBean.factory = factory;
        }

        /**
         * 手动添加bean
         */
        static void regBeanIntoFactory() {
            BeanDefinitionRegistry registry = factory;
            BeanDefinition definition = new GenericBeanDefinition();
            definition.setBeanClassName("spring.loadbean.Car");
            factory.registerBeanDefinition("littlecar", definition);
            Arrays.asList(registry.getBeanDefinitionNames()).forEach(x -> System.out.println("definition bean : " + x));
        }

        /**
         * 展示bean的数量
         */
        static void showBeanNumber() {
            regBeanIntoFactory();
            System.out.println(factory.getBeanDefinitionCount());
        }

        static void viewSingletonBean() {
            SingletonBeanRegistry registry = factory;
            registry.registerSingleton("littlecar", new Car("tank"));
            Arrays.asList(factory.getSingletonNames()).forEach(System.out::println);
            Arrays.asList(factory.getBeanDefinitionNames()).forEach(x -> System.out.println("definition bean : " + x));
            System.out.println(factory.getBean("littlecar"));
        }
    }
}
