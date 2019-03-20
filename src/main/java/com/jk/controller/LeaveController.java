package com.jk.controller;

import com.jk.bean.Leave;
import com.jk.service.LeaveService;
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
@RequestMapping("leave")
public class LeaveController {

    @Resource
    private LeaveService leaveService;

    @RequestMapping("queryByYue")
    @ResponseBody
    public Map<String, Object> histogram(){
        HashMap<String, Object> params = new HashMap<>();
        ArrayList a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        List<Leave> copySku = leaveService.histogram();
        for (Leave sku : copySku) {
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

    @RequestMapping("toleave")
    public String toleave(){
        return "leave";
    }

    @RequestMapping("/getlistAll")
    @ResponseBody
    public ResultPage getSpecialistAll(Leave leave, Integer page, Integer rows) {
        return leaveService.getlistAll(leave,page,rows);
    }

    @ResponseBody
    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id) {
        leaveService.deleteOne(id);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/saveEssay")
    public String saveEssay(Leave leave){
        leaveService.saveEssay(leave);
        return "1";
    }
}
