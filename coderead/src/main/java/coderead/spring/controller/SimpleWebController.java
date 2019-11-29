package coderead.spring.controller;

import coderead.spring.bean.annotationbean.A;
import coderead.spring.bean.smallclasses.Car;
import com.tacbin.starter.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-10 22:51
 **/
@RestController
public class SimpleWebController {
    @Qualifier("benz")
    @Autowired
    Car car;

    @Autowired
    A a;

    @Autowired
    Person person;

    @RequestMapping("/hi")
    public String responseQuest() {
        car.printInfo();
        System.out.println(person.toString());
        return car.toString();
    }

    @RequestMapping("ab")
    public String ab() {
        return a.toString();
    }
}
