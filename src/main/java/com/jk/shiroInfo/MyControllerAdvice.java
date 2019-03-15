package com.jk.shiroInfo;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Auther: yjm
 * @Date: 2019/3/13 13:42
 * @Description:
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = AuthenticationException.class)
    public String errorHandler(Exception ex) {
        System.out.println("查询全局异常了");
        return "weishouquan";
    }

    @ExceptionHandler(value = AuthorizationException.class)
    public String errorHandlerAuthorizationException(Exception ex) {
        System.out.println("查询全局异常了!!!");
        return "weishouquan";//index
    }


}
