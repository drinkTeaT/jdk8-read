package coderead.spring.controller;

import coderead.spring.cache.BankCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description 缓存控制器
 * Author liuweibin
 * Date 2019/12/9 16:50
 **/
@RestController
public class CacheController {
    @Autowired
    BankCache bankCache;

    @RequestMapping(value = "/queryMoney", method = RequestMethod.GET)
    public int queryMoney(@RequestParam int count) {
        int initMoney = bankCache.queryMoney(count);
        return initMoney + bankCache.queryMoney(count);
    }
}
