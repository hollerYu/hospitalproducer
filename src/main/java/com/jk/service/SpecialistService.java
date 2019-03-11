package com.jk.service;

import com.jk.bean.Specialist;
import com.jk.untils.ResultPage;

public interface SpecialistService {
    ResultPage getSpecialistAll(Integer page, Integer rows);

    void deleteOne(Integer id);

    void saveEssay(Specialist specialist);

    void updateStatus(Integer id);

    void updateStatusDown(Integer id);
}
