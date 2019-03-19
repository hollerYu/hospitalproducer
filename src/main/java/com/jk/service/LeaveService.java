package com.jk.service;

import com.jk.bean.Leave;
import com.jk.untils.ResultPage;

public interface LeaveService {
    ResultPage getlistAll(Leave leave, Integer page, Integer rows);

    void deleteOne(Integer id);

    void saveEssay(Leave leave);

}
