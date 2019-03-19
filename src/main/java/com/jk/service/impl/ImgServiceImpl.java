package com.jk.service.impl;

import com.jk.bean.Img;
import com.jk.bean.Specialist;
import com.jk.mapper.ImgMapper;
import com.jk.service.ImgService;
import com.jk.untils.PageUtil;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {

    @Resource
    private ImgMapper imgMapper;

    @Override
    public ResultPage getimglistAll(Img img, Integer page, Integer rows) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Img",img);
        int count = imgMapper.getimglistTotalCount();
        PageUtil<Img> pageUtil = new PageUtil<Img>(count,page,rows);
        hashMap.put("start",pageUtil.getStartIndex());
        hashMap.put("end",pageUtil.getEndIndex());
        List<Img> list = imgMapper.getimglistAll(hashMap);
        resultPage.setRows(list);
        resultPage.setTotal(count);
        return resultPage;
    }

    @Override
    public void deleteOne(Integer id) {
        imgMapper.deleteOne(id);

    }

    @Override
    public void saveEssay(Img img) {
        imgMapper.saveEssay(img);
    }
}
