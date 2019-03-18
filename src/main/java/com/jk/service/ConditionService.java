package com.jk.service;

import com.jk.bean.Condition;
import com.jk.untils.ResultPage;

public interface ConditionService {
    ResultPage getCondition(Integer page, Integer rows);

    void saveCondition(Condition condition);

    void deleteOne(Integer id);

    Condition queryById(Integer id);

    void updateById(Condition condition);

    void editmap(Integer id);

    void editConcelmap(Integer id);
}
