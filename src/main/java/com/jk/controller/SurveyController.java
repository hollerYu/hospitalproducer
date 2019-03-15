package com.jk.controller;

import com.jk.bean.QuestSurvey;
import com.jk.service.SurveyService;
import com.jk.untils.ReturnPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/9 11:27
 * @Description:
 */
@Controller
@RequestMapping("survey")
public class SurveyController {

    @Resource
    private SurveyService questSurveyService;

    //去问卷调查  页面
    @RequiresPermissions("user:toSurvey")
    @RequestMapping("toSurvey")
    public String toSurvey(){
        return "survey";
    }

    //查询  问卷内容
    @RequestMapping("selectSurvey")
    @ResponseBody
    public ReturnPage selectSurvey(Integer page,Integer rows){
        ReturnPage list= questSurveyService.selectSurvey(page,rows);
        return list;
    }

    //去回显页面
    @RequestMapping("toUpdateHtml")
    public String toUpdateHtml(){
        return "updateSurvy";
    }

    //回显
    @RequestMapping("querySurveyById")
    @ResponseBody
    public QuestSurvey querySurveyById(@RequestParam("id") String id){
        QuestSurvey questSurvey= questSurveyService.querySurveyById(id);
        return questSurvey;
    }

    //修改
    @RequestMapping("updateSurvey")
    @ResponseBody
    public boolean updateSurvey(QuestSurvey questSurvey, HttpSession session){
        try {
            questSurveyService.updateSurvey(questSurvey, session);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
