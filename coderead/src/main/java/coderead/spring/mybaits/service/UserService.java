package coderead.spring.mybaits.service;

import coderead.spring.mybaits.entity.User;
import coderead.spring.mybaits.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers(14);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
