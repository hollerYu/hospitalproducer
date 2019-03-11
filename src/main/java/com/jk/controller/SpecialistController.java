package com.jk.controller;

import com.jk.bean.Specialist;
import com.jk.service.SpecialistService;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("specialist")
public class SpecialistController {

    @Resource
    private SpecialistService specialistService;

    @RequestMapping("/getSpecialistAll")
    @ResponseBody
    public ResultPage getSpecialistAll(Integer page, Integer rows) {
        return specialistService.getSpecialistAll(page, rows);
    }

    @ResponseBody
    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id) {
        specialistService.deleteOne(id);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/saveEssay")
    public String saveEssay(Specialist specialist){
        specialistService.saveEssay(specialist);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id){
        specialistService.updateStatusDown(id);
        return "1";
    }
}
