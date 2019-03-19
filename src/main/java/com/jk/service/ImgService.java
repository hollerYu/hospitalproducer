package com.jk.service;

import com.jk.bean.Img;
import com.jk.untils.ResultPage;

public interface ImgService {
    ResultPage getimglistAll(Img img, Integer page, Integer rows);

    void deleteOne(Integer id);

    void saveEssay(Img img);

}
