package com.jk.mapper;

import com.jk.bean.Comment;
import com.jk.bean.Permission;
import com.jk.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 19:22
 * @Description:
 */
public interface ContentMapper {

    User insertForm(User user);

    @Select("select * from y_tree2 where pid = #{i}")
    List<Permission> getTreeData(int i);

    List selectContent(Comment comment);

    void changeState(Integer state, Integer id);

    User queryByUserName(String username);

    List<String> queryPermissionByUserId(Integer id);


}
