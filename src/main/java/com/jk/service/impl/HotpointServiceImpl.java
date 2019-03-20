package com.jk.service.impl;


import com.jk.bean.HotPoint;
import com.jk.bean.Specialist;
import com.jk.mapper.HotPointMapper;
import com.jk.service.HotpointService;
import com.jk.untils.PageUtil;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class HotpointServiceImpl implements HotpointService {

    @Resource
    private HotPointMapper hotPointMapper;

    //条件查询热点资讯
    //分页查询
    @Override
    public ResultPage getHotpoint(HotPoint hotPoint, Integer page, Integer rows) {
        ResultPage resultPage = new ResultPage();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("HotPoint",hotPoint);
        int count = hotPointMapper.getHotPointlistTotalCount();
        PageUtil<HotPoint> pageUtil = new PageUtil<HotPoint>(count,page,rows);
        hashMap.put("start",pageUtil.getStartIndex());
        hashMap.put("end",pageUtil.getEndIndex());
        List<HotPoint> list = hotPointMapper.getHotpoint(hashMap);
        resultPage.setRows(list);
        resultPage.setTotal(count);
        return resultPage;
    }

    //删除
    @Override
    public void deleteOne(Integer id) {
        hotPointMapper.deleteOne(id);
    }

    @Override
    public void saveEssay(HotPoint hotPoint) {
        hotPointMapper.saveEssay(hotPoint);
    }

}
