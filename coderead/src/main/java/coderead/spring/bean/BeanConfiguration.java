package coderead.spring.bean;

import coderead.spring.bean.smallclasses.BigCar;
import coderead.spring.bean.smallclasses.Car;
import coderead.spring.bean.smallclasses.MiniCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.concurrent.ConcurrentMapCacheFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Description: 配置bean，观察bean加载
 * Author: tacbin
 * Date: 2019-09-09 18:20
 **/
@Configuration
public class BeanConfiguration {
    @Bean("benz")
    public Car createBenz() {
        return new BigCar("benz", 30000);
    }

    @Bean("kupi")
    public Car createKupi() {
        return new MiniCar("kupi", 25000);
    }

    @Bean
    public SimpleCacheManager getSimpleCacheManager(@Autowired ConcurrentMapCacheFactoryBean factoryBean) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(factoryBean.getObject()));
        return cacheManager;
    }

    @Bean
    public ConcurrentMapCacheFactoryBean getMapCacheFactoryBean() {
        return new ConcurrentMapCacheFactoryBean();
    }
}
