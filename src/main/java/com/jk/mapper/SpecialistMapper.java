package com.jk.mapper;

import com.jk.bean.Specialist;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface SpecialistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Specialist record);

    int insertSelective(Specialist record);

    Specialist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Specialist record);

    int updateByPrimaryKeyWithBLOBs(Specialist record);

    int updateByPrimaryKey(Specialist record);

    @Select("select count(*) from c_specialist")
    int getSpecialistTotalCount();

    List<Specialist> getSpecialistAll(HashMap<String, Object> hashMap);

    void updateStatus(Integer id);

    void updateStatusDown(Integer id);
}