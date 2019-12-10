package coderead.spring.lifecircle;

import coderead.spring.bean.annotationbean.A;
import coderead.spring.bean.annotationbean.B;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description Bean的生命周期
 * Author liuweibin
 * Date 2019/12/3 15:58
 **/
@Component("lifeOfBean")
@Slf4j
public class LifeOfBean {
    @Autowired
    private A a;

    @Autowired
    private B b;

    public LifeOfBean() {
        log.info("LifeOfBean实例化");
    }
}