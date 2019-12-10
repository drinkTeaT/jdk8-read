package coderead.spring.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

/**
 * Description 缓存银行的数据
 * Author liuweibin
 * Date 2019/12/5 9:59
 **/
@Component
@Slf4j
public class BankCache {
    @CachePut(cacheNames = "banks",key = "#userId")
    public int queryMoney(int userId) {
        int money = 0;
        switch (userId) {
            case 10:
                money = 12;
                break;
            case 20:
                money = 22;
                break;
        }
        log.info("查询数据库");
        return money;
    }
}
