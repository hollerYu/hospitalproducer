package com.jk.controller;

import com.jk.bean.PieBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jk.service.EchartsService;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("echarts")
public class EchartController {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private EchartsService echartsService;


    @ResponseBody
    @RequestMapping("/getChart")
    public List<PieBean> getChart(){

        List<PieBean>  pieBean=echartsService.getgetChart();
        return pieBean;
    }

    @ResponseBody
    @RequestMapping("/getChart02")
    public List<PieBean> getChart02(){

        List<PieBean>  pieBean=echartsService.getChart02();
        return pieBean;
    }
}
