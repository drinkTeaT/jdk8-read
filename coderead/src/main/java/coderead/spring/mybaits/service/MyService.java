package coderead.spring.mybaits.service;
import coderead.spring.mybaits.entity.User;
import coderead.spring.mybaits.pro.mapper.IMyMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description
 * @Author liuweibin
 * @Date 2019/10/28 11:33
 **/
@Service
public class MyService {
    @Autowired
    IMyMapper myMapper;

    public List<User> queryUser(int currentPage, int mount) {
        Page<User> page = new Page<>(currentPage, mount);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().ge(User::getUserId,14);
        myMapper.selectById("14");
        IPage<User> userIPage = myMapper.selectPage(page, queryWrapper);
        System.out.println(userIPage.getPages() + "：页数");
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        return userIPage.getRecords();
    }
}
