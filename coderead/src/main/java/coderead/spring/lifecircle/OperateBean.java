package coderead.spring.lifecircle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description
 * Author liuweibin
 * Date 2019/12/3 16:40
 **/
@Component
@Slf4j
public class OperateBean extends InstantiationAwareBeanPostProcessorAdapter {
    private static final String SPECIFIC_BEAN_NAME = "lifeOfBean";
    private static AtomicInteger integer = new AtomicInteger(0);

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (SPECIFIC_BEAN_NAME.equals(beanName)) {
            log.info("capture beanName {}", beanName);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (SPECIFIC_BEAN_NAME.equals(beanName)) {
            log.info("bean 实例化：{}", beanName);
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        if (SPECIFIC_BEAN_NAME.equals(beanName)) {
            System.out.println(pvs + " bean: " + bean + " beanName: " + beanName);
        }
        return null;
    }
}