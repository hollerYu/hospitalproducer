/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuizzesmarController
 * Author:   SWORD
 * Date:     2019/3/7 16:08
 * Description: 智力测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Quizzesmar;
import com.jk.service.QuizzesmarService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈智力测试〉
 *
 * @author SWORD
 * @create 2019/3/7
 * @since 1.0.0
 */
@Controller
public class QuizzesmarController {

    @Autowired
    private QuizzesmarService quizzesmarService;

    @Resource
    private MongoTemplate mongoTemplate;

    @RequiresPermissions("user:toQuizzesmar")
    @RequestMapping("toQuizzesmar")
    public String toQuizzesmar(){
        return "Quizzesmar";
    }

    //跳转新增页面
    @RequestMapping("toaddQuizzesmarHtml")
    public String toaddQuizzesmarHtml(){
        return "toaddQuizzesmar";
    }


    //MongoDB查询智力表
    @RequestMapping("queryQuizzesmarlist")
    @ResponseBody
    public JSONObject queryQuizzesmarlist(int page,int rows){
        Query query = new Query();
        JSONObject json = new JSONObject();
        query.skip((page-1)*rows);
        query.limit(rows);
        List<Quizzesmar> list =  mongoTemplate.find(query, Quizzesmar.class);
        long count = mongoTemplate.count(query,Quizzesmar.class);
        json.put("rows",list);
        json.put("total",count);
        return json;


    }

    @RequestMapping("addQuizzesmar")
    @ResponseBody
    public String add(Quizzesmar book){
        mongoTemplate.insert(book);
        return "success";
    }

    //批量删除
    @RequestMapping("deleteInfo")
    @ResponseBody
    public String deleteInfo(String[] ids){
        Quizzesmar quizzesmar = new Quizzesmar();
        Query query = new Query();
        mongoTemplate.remove(query.addCriteria(Criteria.where("id").in(ids)),quizzesmar.getClass());
        return "1";
    }


}