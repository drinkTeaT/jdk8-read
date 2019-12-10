package coderead.spring.mybaits.service;

import coderead.spring.mybaits.entity.PayAccount;
import coderead.spring.mybaits.mapper.PayAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description
 * Author liuweibin
 * Date 2019/12/10 15:46
 **/
@Service
public class PayAccountService {
    @Autowired
    PayAccountMapper payAccountMapper;

    public PayAccount getPayAccountBlog(long userId) {
        return payAccountMapper.getPayAccountBlog(userId);
    }

}
