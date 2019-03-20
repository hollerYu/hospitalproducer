package com.jk.mapper;

import com.jk.bean.Img;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface ImgMapper {

    @Select("select count(*) from t_img")
    int getimglistTotalCount();

    List<Img> getimglistAll(HashMap<String, Object> hashMap);

    void deleteOne(Integer id);

    void saveEssay(Img img);

    List<Img> histogram();

}
