package coderead.spring.mybaits.pro.mapper;

import coderead.spring.mybaits.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author liuweibin
 * @Date 2019/10/28 10:34
 **/
@Mapper
public interface IMyMapper extends BaseMapper<User> {
}
