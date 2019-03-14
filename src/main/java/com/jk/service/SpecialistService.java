package com.jk.service;

import com.jk.bean.Specialist;
import com.jk.untils.ResultPage;

public interface SpecialistService {
    ResultPage getSpecialistAll(Integer page, Integer rows);

    void deleteOne(Integer id);

    void saveEssay(Specialist specialist);

    void updateStatus(Integer id);

    void updateStatusDown(Integer id);

    Specialist getIdByRank(Integer rank);


    void updateRankById(int rankId, Integer rank);

    Specialist getIdByRank02(Integer rank);

    Specialist getIdByRank03(Integer rank);

    Specialist getIdByRank04(Integer rank);

    int getMaxRank();
}
