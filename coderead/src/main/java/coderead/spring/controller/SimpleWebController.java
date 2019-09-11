package coderead.spring.controller;

import coderead.spring.bean.smallclasses.Car;
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

    @RequestMapping("/hi")
    public void responseQuest(@Qualifier("benz") Car car) {
        car.printInfo();
    }
}
