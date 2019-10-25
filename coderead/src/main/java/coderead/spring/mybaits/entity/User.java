package coderead.spring.mybaits.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class User {
    private Long userId;
    private String userName;
    private Integer userAge;

    private List<PayAccount> payAccounts;
}
