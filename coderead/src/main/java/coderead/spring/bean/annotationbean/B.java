package coderead.spring.bean.annotationbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/27 17:32
 **/
@Component
public class B {
    @Autowired
    A a;

    public B(){
    }
}
