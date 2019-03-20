package com.jk.mapper;

import com.jk.bean.Vip;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface VipMapper {

    @Select("select count(*) from c_vip")
    int getVipTotalCount();

    List<Vip> getVipList(HashMap<String, Object> hashMap);
}
