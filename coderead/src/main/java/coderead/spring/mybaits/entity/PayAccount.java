package coderead.spring.mybaits.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @Description
 * @Author liuweibin
 * @Date 2019/10/25 15:59
 **/
@Getter
@Setter
@ToString
public class PayAccount {
    private long id;
    private BigDecimal money;
    private String country;
    private String acc;
    private String pwd;
    private long userId;
}
