package com.jk.service.impl;

import com.jk.bean.Specialist;
import com.jk.mapper.SpecialistMapper;
import com.jk.service.SpecialistService;
import com.jk.untils.PageUtil;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class SpecialistServiceImpl implements SpecialistService {

    @Resource
    private SpecialistMapper specialistMapper;

    @Override
    public ResultPage getSpecialistAll(Integer page, Integer rows) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<>();
        int count = specialistMapper.getSpecialistTotalCount();
        PageUtil<Specialist> pageUtil = new PageUtil<Specialist>(count,page,rows);
        hashMap.put("start",pageUtil.getStartIndex());
        hashMap.put("end",pageUtil.getEndIndex());
        List<Specialist> list = specialistMapper.getSpecialistAll(hashMap);
        resultPage.setRows(list);
        resultPage.setTotal(count);
        return resultPage;
    }

    @Override
    public void deleteOne(Integer id) {
        specialistMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveEssay(Specialist specialist) {
        specialistMapper.insertSelective(specialist);
    }

    @Override
    public void updateStatus(Integer id) {
        specialistMapper.updateStatus(id);
    }

    @Override
    public void updateStatusDown(Integer id) {
        specialistMapper.updateStatusDown(id);
    }
}
