package coderead.spring.bean;

import coderead.spring.bean.smallclasses.BigCar;
import coderead.spring.bean.smallclasses.Car;
import coderead.spring.bean.smallclasses.MiniCar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: 配置bean，观察bean加载
 * Author: tacbin
 * Date: 2019-09-09 18:20
 **/
@Configuration
public class BeanConfiguration {
    @Bean
    public Car createBenz() {
        return new BigCar("benz", 30000);
    }

    @Bean
    public Car createKupi() {
        return new MiniCar("kupi", 25000);
    }
}
