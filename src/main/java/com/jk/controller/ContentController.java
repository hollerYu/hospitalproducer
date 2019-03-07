package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.ContentService;
import com.jk.untils.ReturnPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 18:43
 * @Description:
 */
@Controller
@RequestMapping("contentYjm")
public class ContentController {

    @Resource
    private ContentService contentService;

    @RequestMapping("toPage")
    public String toPage(String page){
        return "/"+page;
    }

    //登录验证
    @RequestMapping("insertForm")
    @ResponseBody
    public String insertForm(User user,HttpSession session){
        User userData=contentService.insertForm(user);
        if(userData !=null){
            session.setAttribute("user",userData);
            return "1";
        }
        return "0";
    }

    /**
     * 加载同步树
     */
	@RequestMapping("getTreeData")
	@ResponseBody
	public List<Tree> getTreeData(HttpSession session){
		List<Tree> list = contentService.getTreeData();
		return list;
	}

    @RequestMapping("toContent")
    public String toIndex(){
        return "centent";
    }

    @RequestMapping("selectContent")
    @ResponseBody
    public ReturnPage selectContent(Integer page,Integer rows){
        ReturnPage returnPage=contentService.selectContent(page,rows);
        return returnPage;
    }

    //审核  用户评论
    @RequestMapping("changeState")
    @ResponseBody
    public Boolean changeState(Integer state,Integer id){
        try {
            contentService.changeState(state,id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
