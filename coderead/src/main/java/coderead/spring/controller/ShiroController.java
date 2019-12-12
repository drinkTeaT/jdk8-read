package coderead.spring.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description shiro控制器
 * Author liuweibin
 * Date 2019/12/12 17:09
 **/
@RestController
@RequestMapping("/shiro")
public class ShiroController {
    @RequestMapping("/login")
    public String login(@RequestParam String account, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        // 设置账号密码
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "登录成功" + account + " " + password;
    }
}
