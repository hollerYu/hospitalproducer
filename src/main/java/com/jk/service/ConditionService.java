package com.jk.service;

import com.jk.bean.Comment;
import com.jk.bean.CommentReply;
import com.jk.bean.Condition;
import com.jk.bean.Lhouse;
import com.jk.untils.ResultPage;

import java.util.List;

public interface ConditionService {
    ResultPage getCondition(Integer page, Integer rows);

    void saveCondition(Condition condition);

    void deleteOne(Integer id);

    Condition queryById(Integer id);

    void updateById(Condition condition);

    void editmap(Integer id);

    void editConcelmap(Integer id);

    List<Lhouse> getEchartsByCountAuthor();

    List<Comment> getEchartsComment();

    List<CommentReply> getEchartsCommentReply();

    List<Condition> histogram();

}
