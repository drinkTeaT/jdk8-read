package coderead.spring.mybaits.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId("id")
    private long id;
    @TableField("money")
    private BigDecimal money;
    @TableField("country")
    private String country;
    @TableField("account")
    private String acc;
    @TableField("password")
    private String pwd;
    @TableField("userid")
    private long userId;
}
