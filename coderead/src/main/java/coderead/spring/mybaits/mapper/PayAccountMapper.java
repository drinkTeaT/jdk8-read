package coderead.spring.mybaits.mapper;

import coderead.spring.mybaits.entity.PayAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Description
 * Author liuweibin
 * Date 2019/12/10 15:30
 **/
public interface PayAccountMapper {
    public PayAccount getPayAccountBlog(@Param("id") long userId);
}
