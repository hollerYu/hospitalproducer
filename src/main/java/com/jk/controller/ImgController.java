package com.jk.controller;

import com.jk.bean.HotPoint;
import com.jk.bean.Img;
import com.jk.bean.Specialist;
import com.jk.service.ImgService;
import com.jk.untils.OssUpFileUtil;
import com.jk.untils.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("img")
public class ImgController {

    @Resource
    private ImgService imgService;

    @RequestMapping("toimg")
    public String toimg(){
        return "img";
    }

    @RequestMapping("/getimglistAll")
    @ResponseBody
    public ResultPage getSpecialistAll(Img img, Integer page, Integer rows) {
        return imgService.getimglistAll(img,page,rows);
    }

    @ResponseBody
    @RequestMapping("/deleteOne")
    public String deleteOne(Integer id) {
        imgService.deleteOne(id);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/saveEssay")
    public String saveEssay(Img img){
        imgService.saveEssay(img);
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
}
