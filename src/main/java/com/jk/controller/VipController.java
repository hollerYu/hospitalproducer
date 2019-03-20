package com.jk.controller;

import com.jk.mapper.VipMapper;
import com.jk.service.VipService;
import com.jk.untils.ResultPage;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("vip")
public class VipController {

    @Resource
    private VipService vipService;

    @RequestMapping("tovipList")
    @RequiresPermissions("user:vip")
    public String tovipList() {
        return "vipList";
    }

    @ResponseBody
    @RequestMapping("getVipList")
    public ResultPage getVipList(Integer page, Integer rows) {
        ResultPage vipList = vipService.getVipList(page, rows);
        return vipList;
    }

    @ResponseBody
    @RequestMapping("/test")
    public Map<String, String> exchangeJson() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "content");

        return map;
    }

}
