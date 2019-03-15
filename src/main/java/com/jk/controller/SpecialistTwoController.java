package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.SpecialistTwo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.jk.untils.ExportExcel;
import com.jk.untils.ImportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SpecialistTwoController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ServletContext context;
    //跳转到专家页面
    @RequiresPermissions("user:zhuanjia")
    @RequestMapping("zhuanjia")
    public String zhuanjia() {

        return "specialisttwo";
    }

    //查询/分页
    @ResponseBody
    @RequestMapping("querySpecialist")
    public JSONObject querySpecialist(Integer page, Integer rows) {
        Query query = new Query();
        JSONObject json = new JSONObject();
        query.skip((page - 1) * rows);
        query.limit(rows);
        List<SpecialistTwo> list = mongoTemplate.find(query, SpecialistTwo.class);
        long count = mongoTemplate.count(query, SpecialistTwo.class);
        json.put("rows", list);
        json.put("total", count);
        return json;
    }
    //新增
    @ResponseBody
    @RequestMapping("addForm")
    public String addForm(SpecialistTwo specialistTwo){
        specialistTwo.setPortion("2");
        mongoTemplate.insert(specialistTwo);
      return "success";
    }
    @ResponseBody
    @RequestMapping("deleteInfotwo")
    public String yydelete(String[] ids){
        SpecialistTwo specialistTwo = new SpecialistTwo();
        Query query = new Query();
        mongoTemplate.remove(query.addCriteria(Criteria.where("id").in(ids)),specialistTwo.getClass());
        return "success";
    }
    //poi导出
    @RequestMapping("exportSpecialist")
    public void importpoi(HttpServletResponse response) {
        Query query = new Query();
        List<SpecialistTwo> list = mongoTemplate.find(query, SpecialistTwo.class);
        //使用poi将导出
        String title="专家列表";
        String[] rowName = {"专家姓名","毕业学院","教师图片","专家分类"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] obj = null;
        for (SpecialistTwo task : list) {
            obj = new Object[rowName.length];
            obj[0] = task.getName();
            obj[1] = task.getAddress();
            obj[2] = task.getDataimg();
            obj[3] = task.getFenlei();
            dataList.add(obj);
        }
        ExportExcel exportExcel = new ExportExcel(title, rowName, dataList, response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //poi导入
    @ResponseBody
    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file) throws Exception{
        String filePath = file.getOriginalFilename();
        // System.out.println(filePath);
        String path = filePath.substring(filePath.lastIndexOf("."));
        if (path.equals(".xls")) {
            int startRow = 2;//从表格的哪一行开始读取
            int endRow = 0;
            List<SpecialistTwo> bookList = (List<SpecialistTwo>) ImportExcel.importExcel(file.getInputStream(), startRow, endRow, SpecialistTwo.class);
            for (SpecialistTwo book : bookList) {
                book.setId(null);
                mongoTemplate.insert(bookList);
            }
            return "1";//成功
        } else {
            return "0";
        }
    }

}
