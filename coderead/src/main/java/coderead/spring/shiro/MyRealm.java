package coderead.spring.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * Description 认证和授权
 * Author liuweibin
 * Date 2019/12/12 10:15
 **/
@Component
public class MyRealm extends AuthorizingRealm {

    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account = (String) token.getPrincipal();
        char[] pwdChars = (char[]) token.getCredentials();
        String password = String.valueOf(pwdChars);
        if ("admin".equals(account) && "admin".equals(password)) {
            return new SimpleAccount(account, password, "MyRealm");
        } else {
            throw new AuthenticationException("账号或密码错误" + account + " " + password);
        }
    }
}
