package com.jk.mapper;

import com.jk.bean.Comment;
import com.jk.bean.Permission;
import com.jk.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 19:22
 * @Description:
 */
public interface ContentMapper {

    User insertForm(User user);

    List<Permission> getTreeData(@Param("pid") Integer pid, @Param("id") Integer id);

    List selectContent(Comment comment);

    void changeState(Integer state, Integer id);

    User queryByUserName(String username);

    List<String> queryPermissionByUserId(Integer id);

    List<Integer> getPermissionById(Integer id);
}
