package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.SpecialistTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpecialistTwoController {
    @Autowired
    private MongoTemplate mongoTemplate;

    //跳转到专家页面
    @RequestMapping("zhuanjia")
    public String zhuanjia() {

        return "specialisttwo";
    }

    //查询/分页
    @ResponseBody
    @RequestMapping("querySpecialist")
    public JSONObject querySpecialist(Integer page, Integer rows) {
        Query query = new Query();
        JSONObject json = new JSONObject();
        query.skip((page - 1) * rows);
        query.limit(rows);
        List<SpecialistTwo> list = mongoTemplate.find(query, SpecialistTwo.class);
        long count = mongoTemplate.count(query, SpecialistTwo.class);
        json.put("rows", list);
        json.put("total", count);
        return json;
    }
    //新增
    @ResponseBody
    @RequestMapping("addForm")
    public String addForm(SpecialistTwo specialistTwo){
        specialistTwo.setPortion("2");
        mongoTemplate.insert(specialistTwo);
      return "success";
    }
    @ResponseBody
    @RequestMapping("deleteInfotwo")
    public String yydelete(String[] ids){
        SpecialistTwo specialistTwo = new SpecialistTwo();
        Query query = new Query();
        mongoTemplate.remove(query.addCriteria(Criteria.where("id").in(ids)),specialistTwo.getClass());
        return "success";
    }




}
