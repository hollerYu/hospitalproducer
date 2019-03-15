package com.jk.bean;

import lombok.Data;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/13 19:40
 * @Description:
 */
@Data
public class Role {

    private Integer id; // 角色标识程序中判断使用,如"admin"

    private String roleName; // 一个角色可以有多个权限

    private List<Permission> permissions; // 一个角色对应多个用户

    private List<User> userInfos;

}
