package com.jk.controller;

import com.jk.bean.Condition;
import com.jk.service.ConditionService;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("condition")
public class ConditionController {

    @Resource
    private ConditionService conditionService;

    @ResponseBody
    @RequestMapping("/getCondition")
    public ResultPage getCondition(Integer page, Integer rows) {
        return conditionService.getCondition(page, rows);
    }

    @ResponseBody
    @RequestMapping("/saveOrUpdate")
    public String saveCondition(Condition condition) {
        if (condition.getId()==null){
            conditionService.saveCondition(condition);
            return "1";
        }else{
            conditionService.updateById(condition);
            return "1";
        }

    }

    @ResponseBody
    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id) {
        conditionService.deleteOne(id);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/queryById")
    public Condition queryById(Integer id) {
        Condition condition = conditionService.queryById(id);
        return condition;
    }

}
