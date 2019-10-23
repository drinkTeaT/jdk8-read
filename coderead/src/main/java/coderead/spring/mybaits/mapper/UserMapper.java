package coderead.spring.mybaits.mapper;

import coderead.spring.mybaits.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface UserMapper {
    List<User> getUsers(@Param("id") long id);
}