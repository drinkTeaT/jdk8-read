package coderead.spring.controller;

import coderead.spring.mybaits.entity.User;
import coderead.spring.mybaits.service.MyService;
import coderead.spring.mybaits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyBatisController {
    @Autowired
    private UserService userService;

    @Autowired
    MyService service;

    @GetMapping("/users")
    @Transactional(rollbackForClassName = "Exception.class")
    public List<User> lists() {
          User user = new User();
          user.setUserName("jimmy");
          user.setUserAge(13);
          userService.insertUser(user);
//          userService.insertUser(new User());
        return userService.getUsers();
    }

    @RequestMapping("/page")
    public List<User> queryPage() {
        List<User> result = service.queryUser(1, 2);
        return result;
    }
}
