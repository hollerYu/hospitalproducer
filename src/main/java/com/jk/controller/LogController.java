package com.jk.controller;
import com.jk.bean.Log;
import com.jk.service.LogService;
import com.jk.untils.ReturnPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

}
