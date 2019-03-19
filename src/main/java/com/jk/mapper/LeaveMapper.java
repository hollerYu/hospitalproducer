package com.jk.mapper;

import com.jk.bean.Leave;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface LeaveMapper {

    @Select("select count(*) from l_leave")
    int getimglistTotalCount();

    List<Leave> getlistAll(HashMap<String, Object> hashMap);

    void deleteOne(Integer id);

    void saveEssay(Leave leave);

}
