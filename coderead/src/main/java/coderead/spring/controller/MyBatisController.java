package coderead.spring.controller;

import coderead.spring.entity.Person;
import coderead.spring.mybaits.entity.PayAccount;
import coderead.spring.mybaits.entity.User;
import coderead.spring.mybaits.service.MyService;
import coderead.spring.mybaits.service.PayAccountService;
import coderead.spring.mybaits.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyBatisController {
    @Autowired
    private UserService userService;
    @Autowired
    private PayAccountService payAccountService;

    @Autowired
    MyService service;

    @GetMapping("/users")
    @Transactional(rollbackForClassName = "Exception.class")
    public List<User> lists() {
        return userService.getUsers();
    }

    @RequestMapping("/page")
    public List<User> queryPage() {
        List<User> result = service.queryUser(1, 2);
        return result;
    }

    @PostMapping("/")
    public String getStringFromWeb(@RequestParam(required = false) String userId, @RequestParam(required = false) String phone) {
        return userId + " " + phone;
    }

    @RequestMapping("/entity")
    public String getEntityFromWeb(@RequestBody Person person) {
        return person.toString();
    }

    @RequestMapping("/pay")
    public PayAccount getPayAccountInfo(long id) {
        return payAccountService.getPayAccountBlog(id);
    }
}
