package com.jk.service;

import com.jk.bean.Comment;
import com.jk.bean.User;
import com.jk.untils.ReturnPage;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Set;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 19:21
 * @Description:
 */
public interface ContentService {
    User insertForm(User user);

    List<Tree> getTreeData();

    ReturnPage selectContent(Comment comment, Integer page, Integer rows);

    void changeState(Integer state, Integer id);

    User queryByUserName(String username);

    /**
     * 根据  用户id 查询 用户  所拥有的权限
     * @param id
     * @return
     */
    List<String> queryPermissionByUserId(Integer id);



}
