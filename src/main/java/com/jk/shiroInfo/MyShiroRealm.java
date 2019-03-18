package com.jk.shiroInfo;

import com.jk.bean.Permission;
import com.jk.bean.Role;
import com.jk.bean.User;
import com.jk.service.ContentService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/2/28 17:14
 * @Description:    实现AuthorizingRealm接口用户用户认证
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private ContentService contentService;

    /**
     * @param principals
     * @return              角色权限和对应权限添加
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User)principals.getPrimaryPrincipal();
        //System.out.println("user====>"+user);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();      //创建授权

        List<String> userData =contentService.queryPermissionByUserId(user.getId());
        for (String userDatum : userData) {
            //System.err.println("userDatum=========>"+userDatum);
            if (userDatum == null) {
              continue;
            }
        }
        authorizationInfo.addStringPermissions(userData);

        return authorizationInfo;
    }

    /**
     * 认证   登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //当前登录的用户名
        String username = token.getPrincipal().toString();
        User userData = contentService.queryByUserName(username);
        //System.err.println("userData====>"+userData);
        if(userData == null){
            return null;
        }
        //SimpleAuthenticationInfo 构造方法中只需放入正确的用户名和密码即可
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userData,
                userData.getYhMm(),
                this.getName()
        );

        super.clearCachedAuthorizationInfo(simpleAuthenticationInfo.getPrincipals());    //清之前的授权信息

        return simpleAuthenticationInfo;//如果此处返回null 会报UnknownAccountException 没有此账号的异常
        //如果用户名和密码不匹配会抛出 IncorrectCredentialsException异常
    }

}
