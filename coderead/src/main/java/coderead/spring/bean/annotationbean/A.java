package coderead.spring.bean.annotationbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/27 17:31
 **/
@Component("a")
public class A {
    @Autowired
    B b;

    public A() {
        System.out.println("A 实例化");
    }
}
