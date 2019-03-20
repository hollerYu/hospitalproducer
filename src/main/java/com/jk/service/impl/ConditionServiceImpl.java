package com.jk.service.impl;

import com.jk.bean.Comment;
import com.jk.bean.CommentReply;
import com.jk.bean.Condition;
import com.jk.bean.Lhouse;
import com.jk.mapper.ConditionMapper;
import com.jk.service.ConditionService;
import com.jk.untils.PageUtil;
import com.jk.untils.PinyinSortUtil;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ConditionServiceImpl implements ConditionService {

    @Resource
    private ConditionMapper conditionMapper;

    @Override
    public ResultPage getCondition(Integer page, Integer rows) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<>();
        int count = conditionMapper.getConditionTotalCount();
        PageUtil<Condition> pageUtil = new PageUtil<Condition>(count,page,rows);
        hashMap.put("start",pageUtil.getStartIndex());
        hashMap.put("end",pageUtil.getEndIndex());
        List<Condition> list = conditionMapper.getCondition(hashMap);
        //按照title排序
        List<Condition> title = PinyinSortUtil.sortListByFstSpell(list, "title");
        resultPage.setRows(title);
        resultPage.setTotal(count);
        return resultPage;
    }

    @Override
    public void saveCondition(Condition condition) {
        conditionMapper.insertSelective(condition);
    }

    @Override
    public void deleteOne(Integer id) {
        conditionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Condition queryById(Integer id) {

        return conditionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateById(Condition condition) {
        conditionMapper.updateByPrimaryKeySelective(condition);
    }

    @Override
    public void editmap(Integer id) {
        conditionMapper.editmap(id);
    }

    @Override
    public void editConcelmap(Integer id) {
        conditionMapper.editConcelmap(id);
    }

    @Override
    public List<Condition> histogram() {
        List<Condition> list = conditionMapper.histogram();
        return list;

    }


    @Override
    public List<Lhouse> getEchartsByCountAuthor() {
        return conditionMapper.getEchartsByCountAuthor();
    }

    @Override
    public List<Comment> getEchartsComment() {
        return conditionMapper.getEchartsComment();
    }

    @Override
    public List<CommentReply> getEchartsCommentReply() {
        return conditionMapper.getEchartsCommentReply();
    }

}
