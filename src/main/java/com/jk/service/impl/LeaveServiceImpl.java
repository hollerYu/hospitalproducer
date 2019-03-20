package com.jk.service.impl;

import com.jk.bean.Leave;
import com.jk.mapper.LeaveMapper;
import com.jk.service.LeaveService;
import com.jk.untils.PageUtil;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Resource
    private LeaveMapper leaveMapper;

    @Override
    public ResultPage getlistAll(Leave leave, Integer page, Integer rows) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Leave",leave);
        int count = leaveMapper.getimglistTotalCount();
        PageUtil<Leave> pageUtil = new PageUtil<Leave>(count,page,rows);
        hashMap.put("start",pageUtil.getStartIndex());
        hashMap.put("end",pageUtil.getEndIndex());
        List<Leave> list = leaveMapper.getlistAll(hashMap);
        resultPage.setRows(list);
        resultPage.setTotal(count);
        return resultPage;

    }

    @Override
    public void deleteOne(Integer id) {
        leaveMapper.deleteOne(id);
    }

    @Override
    public void saveEssay(Leave leave) {
        leaveMapper.saveEssay(leave);
    }

    @Override
    public List<Leave> histogram() {
        return leaveMapper.histogram();
    }
}
