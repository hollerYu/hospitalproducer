package com.jk.service;

import com.jk.bean.User;
import com.jk.untils.ReturnPage;
import sun.reflect.generics.tree.Tree;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 19:21
 * @Description:
 */
public interface ContentService {
    User insertForm(User user);

    List<Tree> getTreeData();

    ReturnPage selectContent(Integer page, Integer rows);

    void changeState(Integer state, Integer id);
}
