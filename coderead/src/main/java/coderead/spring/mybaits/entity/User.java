package coderead.spring.mybaits.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
//@TableName("tbl_user")
public class User {
//    @TableId("user_id")
    private Long userId;
//    @TableField("user_name")
    private String userName;
//    @TableField("user_age")
    private Integer userAge;
    @TableField(exist = false)
    private List<PayAccount> payAccounts;
}
