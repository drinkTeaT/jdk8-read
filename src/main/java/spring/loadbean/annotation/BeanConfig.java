package spring.loadbean.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.loadbean.Car;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-10 22:05
 **/
@Configuration
public class BeanConfig {
    @Bean
    public Car newCar() {
        return new Car("benben");
    }
}
