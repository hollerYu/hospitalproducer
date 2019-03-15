package com.jk.controller;

import com.jk.bean.HotPoint;
import com.jk.bean.Specialist;
import com.jk.service.HotpointService;
import com.jk.untils.ResultPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("hotpoint")
public class HotpointController {

    @Resource
    private HotpointService hotpointService;

    //去往热点资讯查询后台
    @RequiresPermissions("user:hotp")
    @RequestMapping("tohotpoint")
    public String tohotpoint(){
        return "hotpoint";
    }

    //查询热点资讯
    @RequestMapping("queryHotpoint")
    @ResponseBody
    public ResultPage getHotpoint(HotPoint hotPoint,Integer page,Integer rows){
        return hotpointService.getHotpoint(hotPoint,page,rows);
    }

    //删除
    @ResponseBody
    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id) {
        hotpointService.deleteOne(id);
        return "1";
    }

    //新增
    @ResponseBody
    @RequestMapping("/saveEssay")
    public String saveEssay(HotPoint hotPoint){
        hotpointService.saveEssay(hotPoint);
        return "1";
    }
}
