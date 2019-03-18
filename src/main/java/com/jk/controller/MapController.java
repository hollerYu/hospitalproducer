package com.jk.controller;

import com.jk.bean.Condition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: yjm
 * @Date: 2019/3/17 16:50
 * @Description:
 */
@Controller
@RequestMapping("map")
public class MapController {

    @RequestMapping("toMap")
    public String toMap(){
        return "map";
    }

    @RequestMapping("addMapNode")
    @ResponseBody
    public Condition addMapNode(String pointxs,String pointys){
        Condition condition=new Condition();
        condition.setPointxs(pointxs);
        condition.setPointys(pointys);

        return condition;
    }

}
