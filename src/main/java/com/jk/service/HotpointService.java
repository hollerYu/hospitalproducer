package com.jk.service;

import com.jk.bean.HotPoint;
import com.jk.untils.ResultPage;

public interface HotpointService {

    //查询热点资讯
    ResultPage getHotpoint(Integer page, Integer rows);

    void deleteOne(Integer id);

    void saveEssay(HotPoint hotPoint);

}
