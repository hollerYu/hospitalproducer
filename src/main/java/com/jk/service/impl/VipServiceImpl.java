package com.jk.service.impl;

import com.jk.bean.Condition;
import com.jk.bean.Vip;
import com.jk.mapper.VipMapper;
import com.jk.service.VipService;
import com.jk.untils.PageUtil;
import com.jk.untils.PinyinSortUtil;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {


    @Resource
    private VipMapper vipMapper;

    @Override
    public ResultPage getVipList(Integer page, Integer rows) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<>();
        int count = vipMapper.getVipTotalCount();
        PageUtil<Vip> pageUtil = new PageUtil<Vip>(count,page,rows);
        hashMap.put("start",pageUtil.getStartIndex());
        hashMap.put("end",pageUtil.getEndIndex());
        List<Vip> list = vipMapper.getVipList(hashMap);
        //按照title排序
        //List<Condition> title = PinyinSortUtil.sortListByFstSpell(list, "title");
        resultPage.setRows(list);
        resultPage.setTotal(count);
        return resultPage;
    }
}
