package coderead.spring.bean.annotationbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/27 17:32
 **/
@Component("b")
public class B {
    @Autowired
    A a;

    public B() {
        System.out.println("B 实例化");
    }
}
