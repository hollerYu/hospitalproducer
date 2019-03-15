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
    public ResultPage getSpecialistAll(Specialist specialist,Integer page, Integer rows) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Specialist",specialist);
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

    @Override
    public Specialist getIdByRank(Integer rank) {
        return specialistMapper.getIdByRank(rank);
    }

    @Override
    public void updateRankById(int rankId, Integer rank) {
        specialistMapper.updateRankById(rankId,rank);
    }

    @Override
    public Specialist getIdByRank02(Integer rank) {
        return specialistMapper.getIdByRank02(rank);
    }

    @Override
    public Specialist getIdByRank03(Integer rank) {
        return specialistMapper.getIdByRank03(rank);
    }

    @Override
    public Specialist getIdByRank04(Integer rank) {
        return specialistMapper.getIdByRank04(rank);
    }

    @Override
    public int getMaxRank() {

        return specialistMapper.getMaxRank();
    }

}
