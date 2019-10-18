package coderead.spring.mybaits.service;

import coderead.spring.mybaits.mapper.UserMapper;
import coderead.spring.mybaits.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
