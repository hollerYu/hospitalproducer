package com.jk.controller;

import com.jk.bean.Comment;
import com.jk.bean.CommentReply;
import com.jk.bean.Condition;
import com.jk.bean.Lhouse;
import com.jk.service.ConditionService;
import com.jk.untils.ResultPage;
import org.apache.poi.ss.formula.functions.Count;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @RequestMapping("getEchartsByCountAuthor")
    @ResponseBody
    public Map<String, Object> getEchartsByCountAuthor() {
        Map<String, Object> param = new HashMap<>();

        ArrayList<String> a = new ArrayList<>();

        ArrayList<Integer> b = new ArrayList<>();

        List<Lhouse> house = conditionService.getEchartsByCountAuthor();

        for (Lhouse lhouse : house) {
            a.add(lhouse.getUserMch());
            b.add(Integer.valueOf(lhouse.getCountMch()));
        }

        param.put("categories", a);
        param.put("data", b);
        System.out.println(param);
        return param;
    }

    //查询 评论 回复
    @RequestMapping("getEchartsComment")
    @ResponseBody
    public Map<String, Object> getEchartsComment() {
        Map<String, Object> param = new HashMap<>();

        ArrayList a = new ArrayList<>();

        ArrayList b = new ArrayList<>();

        ArrayList c = new ArrayList<>();
        ArrayList d = new ArrayList<>();

        List<Comment> house = conditionService.getEchartsComment();

        List<CommentReply> commentReply = conditionService.getEchartsCommentReply();

        for (Comment lhouse : house) {
            a.add(lhouse.getCreateTime().toLocaleString());
            b.add(Integer.valueOf(lhouse.getId()));
        }
        for (CommentReply reply : commentReply) {
            c.add(reply.getReplyTime().toLocaleString());
            d.add(Integer.valueOf(reply.getId()));
        }

        param.put("categories", a);
        param.put("data", b);

        param.put("ccategories", c);
        param.put("ddata", d);
      //  System.out.println(param);
        return param;
    }



}
