package com.jk.controller;
import com.jk.bean.Log;
import com.jk.service.LogService;
import com.jk.untils.ReturnPage;
import org.apache.poi.ss.formula.functions.Count;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("log")
public class LogController {

    @Resource
    private LogService logService;

    @RequestMapping("tolog")
    @RequiresPermissions("user:tolog")
    public String tolog(){
        return "log";
    }

    @RequestMapping("queryLog")
    @ResponseBody
    public ReturnPage queryLog(Log log, Integer page, Integer rows){
        ReturnPage list= logService.queryLog(log,page,rows);
        return list;
    }

    //登录 日志ercharts 报表
    @RequestMapping("getEachersTwo")
    @ResponseBody
    public Map<String, Object> getEachersTwo(){
        Map<String, Object> param = new HashMap<>();

        ArrayList<String> a = new ArrayList<>();

        ArrayList<Integer> b = new ArrayList<>();

        List<Log> logs = logService.getEachersTwo();

        for (Log log : logs) {

            a.add(log.getUserName());
            b.add(Integer.valueOf(log.getUserId()));
        }

        param.put("categories", a);
        param.put("data", b);
        System.out.println(param);
        return param;
    }



}
