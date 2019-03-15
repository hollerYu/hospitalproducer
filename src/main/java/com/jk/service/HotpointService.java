package com.jk.service;

import com.jk.bean.HotPoint;
import com.jk.untils.ResultPage;

public interface HotpointService {

    //查询热点资讯
    ResultPage getHotpoint(HotPoint hotPoint,Integer page, Integer rows);

    void deleteOne(Integer id);

    void saveEssay(HotPoint hotPoint);

}
