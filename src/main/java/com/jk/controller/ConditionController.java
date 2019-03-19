package com.jk.controller;

import com.jk.bean.Condition;
import com.jk.service.ConditionService;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("condition")
public class ConditionController {

    @Resource
    private ConditionService conditionService;

    @RequestMapping("queryByYue")
    @ResponseBody
    public Map<String, Object> histogram(){
        HashMap<String, Object> params = new HashMap<>();
        ArrayList a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        List<Condition> copySku = conditionService.histogram();
        for (Condition sku : copySku) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//设置日期格式
            String format = sdf.format(sku.getSystime());
            a.add(format);
            b.add(Integer.valueOf(sku.getNumber()));
        }
        System.out.println(a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        params.put("systime",a);
        params.put("number",b);
        System.out.println("=================>"+params);
        return params;
    }

    @ResponseBody
    @RequestMapping("/getCondition")
    public ResultPage getCondition(Integer page, Integer rows) {
        return conditionService.getCondition(page, rows);
    }

    @ResponseBody
    @RequestMapping("/saveOrUpdate")
    public String saveCondition(Condition condition) {
        //System.err.println("condition====>"+condition);
      //  System.err.println("condition"+condition);
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

    @RequestMapping("editmap")
    @ResponseBody
    public String editmap(Integer id){
        conditionService.editmap(id);
        return "1";
    }

    @RequestMapping("editConcelmap")
    @ResponseBody
    public String editConcelmap(Integer id){
        conditionService.editConcelmap(id);
        return "1";
    }



}
