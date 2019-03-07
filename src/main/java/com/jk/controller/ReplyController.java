package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 10:44
 * @Description:
 */
@Controller
@RequestMapping("replyYjm")
public class ReplyController {

    @Resource
    private ReplyService replyService;

    //回复评论
    @RequestMapping("replyComment")
    @ResponseBody
    public String replyComment(Integer id, Integer toReplyId, String replyContent, HttpSession session){
        User user=(User) session.getAttribute("user");
        if(user==null){
            return "0";  //没登录  去登录
        }
        try {
            replyService.replyComment(id,toReplyId,replyContent,user.getId());

            return "1";   //成功
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";   //失败
        }
    }

}
