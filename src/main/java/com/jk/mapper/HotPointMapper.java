package com.jk.mapper;

import com.jk.bean.HotPoint;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface HotPointMapper {

    //总条数
    @Select("select count(*) from y_hotspot")
    int getHotPointlistTotalCount();

    //查询
    List<HotPoint> getHotpoint(HashMap<String, Object> hashMap);

    void deleteOne(Integer id);

    void saveEssay(HotPoint hotPoint);

}
