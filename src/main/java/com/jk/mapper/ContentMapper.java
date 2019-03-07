package com.jk.mapper;

import com.jk.bean.Tree;
import com.jk.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 19:22
 * @Description:
 */
public interface ContentMapper {

    User insertForm(User user);

    @Select("select * from y_tree2 where pid = #{i}")
    List<Tree> getTreeData(int i);

    List queryDiscu();

    void changeState(Integer state, Integer id);


}
