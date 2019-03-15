package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Log;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("log")
public class LogController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequiresPermissions("user:tolog")
    @RequestMapping("tolog")
    public String tolog(){
        return "log";
    }

    @RequestMapping("queryLog")
    @ResponseBody
    public JSONObject querySpecialist(Integer page, Integer rows) {
        Query query = new Query();
        JSONObject json = new JSONObject();
        query.skip((page - 1) * rows);
        query.limit(rows);
        List<Log> list = mongoTemplate.find(query, Log.class);
        long count = mongoTemplate.count(query, Log.class);
        json.put("rows", list);
        json.put("total", count);
        return json;
    }
}
