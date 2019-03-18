package com.jk.controller;

import com.jk.bean.Comment;
import com.jk.service.ContentService;
import com.jk.untils.ReturnPage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("toPage")
    public String toPage(String page){
        return "/"+page;
    }

    //登录验证
    @RequestMapping("insertForm")
    public String insertForm(String username, String password,HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//登录分两种情况 一种是成功 另一种是失败{1.账号不存在  2.密码错误}
        } catch (IncorrectCredentialsException e) { // catch只会走进其中一个代码块 所以大的异常放到小的异常下面
            System.out.println("用户名和密码不匹配");
            session.setAttribute("msg", "用户名和密码不匹配");
            return "login";
        } catch (UnknownAccountException e) {
            System.out.println("未知账号");
            session.setAttribute("msg", "未知账号");
            return "login";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            session.setAttribute("msg", "未知异常");
            return "login";
        }
        session.setAttribute("user",token.getUsername());
      //  System.out.println("校验密码完成");
        return "index";
    }

    /**
     * 去未授权  界面
     */
    @RequestMapping("toDontHavePower")
    public String toDontHavePower(){
        return "weishouquan";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value="logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){

        //subject的实现类DelegatingSubject的logout方法，将本subject对象的session清空了
        //即使session托管给了redis ，redis有很多个浏览器的session
        //只要调用退出方法，此subject的、此浏览器的session就没了
        try {
            //退出
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "centent";
    }

    /**
     * 加载同步树
     */
   // @RequiresPermissions("user:querytree")
	@RequestMapping("getTreeData")
	@ResponseBody
	public List<Tree> getTreeData(HttpSession session){
		List<Tree> list = contentService.getTreeData();
		return list;
	}

    @RequiresPermissions("user:plcheck")
    @RequestMapping("toContent")
    public String toIndex(){
        return "centent";
    }


    @RequestMapping("selectContent")
    @ResponseBody
    public ReturnPage selectContent(Comment comment, Integer page, Integer rows){
        ReturnPage returnPage=contentService.selectContent(comment,page,rows);
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
