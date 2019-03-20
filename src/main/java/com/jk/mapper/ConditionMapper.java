package com.jk.mapper;

import com.jk.bean.Comment;
import com.jk.bean.CommentReply;
import com.jk.bean.Condition;
import com.jk.bean.Lhouse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface ConditionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Condition record);

    int insertSelective(Condition record);

    Condition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Condition record);

    int updateByPrimaryKey(Condition record);

    @Select("select count(*) from l_condition")
    int getConditionTotalCount();

    List<Condition> getCondition(HashMap<String, Object> hashMap);

    void editmap(@Param("id") Integer id);

    void editConcelmap(@Param("id") Integer id);

    List<Lhouse> getEchartsByCountAuthor();

    List<Comment> getEchartsComment();

    List<CommentReply> getEchartsCommentReply();


    List<Condition> histogram();

}