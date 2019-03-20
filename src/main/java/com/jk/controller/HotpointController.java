package com.jk.controller;

import com.jk.bean.HotPoint;
import com.jk.bean.Img;
import com.jk.bean.Specialist;
import com.jk.service.HotpointService;
import com.jk.untils.OssUpFileUtil;
import com.jk.untils.ResultPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping("/saveEssay")
    public String saveEssay(HotPoint hotPoint){
        hotpointService.saveEssay(hotPoint);
        return "1";
    }

    //OOS图片上传
    @ResponseBody
    @RequestMapping("addFiletwo")
    public String addFile(@RequestParam("headimg") MultipartFile file){
        Map<String, Object> stringObjectMap = OssUpFileUtil.uploadFile(file);
        String count = "";
        for(String key : stringObjectMap.keySet()){
            Object o = stringObjectMap.get(key);
            System.out.println("key: " + key + " value: " + o);
            if(key=="url"){
                count+=o;
            }
        }
        return count;
    }

    @RequestMapping("queryByYue")
    @ResponseBody
    public Map<String, Object> histogram(){
        HashMap<String, Object> params = new HashMap<>();
        ArrayList a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        List<HotPoint> copySku = hotpointService.histogram();
        for (HotPoint sku : copySku) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//设置日期格式
            String format = sdf.format(sku.getTimes());
            a.add(format);
            b.add(Integer.valueOf(sku.getNumber()));
        }
        System.out.println(a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        params.put("times",a);
        params.put("number",b);
        System.out.println("=================>"+params);
        return params;
    }
}
