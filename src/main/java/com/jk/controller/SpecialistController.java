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
        specialist.setRank(specialistService.getMaxRank()+1);
        specialistService.saveEssay(specialist);
        return "1";
    }

    @ResponseBody
    @RequestMapping("/updateStatus")
    public String updateStatus(Integer id){
        specialistService.updateStatusDown(id);
        return "1";
    }

    /**
     * 上移
     * @param id
     * @param rank
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUp")
    public String getUp(Integer id,Integer rank){
        Specialist specialist = specialistService.getIdByRank(rank);
        if( specialist != null){
            //++，交换排序值，非选中
            specialistService.updateRankById(specialist.getId(),rank);
            //--，交换排序值，选中的
            specialistService.updateRankById(id,specialist.getRank());
            return "1";
        }else{
            return "0";//已是最高了
        }


    }

    /**
     * 下移
     * @param id
     * @param rank
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDown")
    public String getDown(Integer id,Integer rank){
        Specialist specialist = specialistService.getIdByRank02(rank);
        if(specialist != null){
            //++，交换排序值，非选中
            specialistService.updateRankById(specialist.getId(),rank);
            //--，交换排序值，选中的
            specialistService.updateRankById(id,specialist.getRank());
            return "1";
        }else{
            return "0";//已是最低了
        }


    }

    /**
     * 置地
     * @param id
     * @param rank
     * @return
     */
    @ResponseBody
    @RequestMapping("/getBottom")
    public String getBottom(Integer id,Integer rank){
        Specialist specialist = specialistService.getIdByRank03(rank);
        if(!id.equals(specialist.getId())){
            //++，交换排序值，非选中
            specialistService.updateRankById(specialist.getId(),rank);
            //--，交换排序值，选中的
            specialistService.updateRankById(id,specialist.getRank());
            return "1";
        }else{
            return "0";//已是最低了
        }

    }

    /**
     * 置地
     * @param id
     * @param rank
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTop")
    public String getTop(Integer id,Integer rank){
        Specialist specialist = specialistService.getIdByRank04(rank);
        if(!id.equals(specialist.getId())){
            //++，交换排序值，非选中
            specialistService.updateRankById(specialist.getId(),rank);
            //--，交换排序值，选中的
            specialistService.updateRankById(id,specialist.getRank());
            return "1";
        }else{
            return "0";//已是最低了
        }

    }
}
