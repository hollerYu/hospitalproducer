package com.jk.controller;

import com.jk.bean.Img;
import com.jk.bean.Leave;
import com.jk.service.LeaveService;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("leave")
public class LeaveController {

    @Resource
    private LeaveService leaveService;

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
