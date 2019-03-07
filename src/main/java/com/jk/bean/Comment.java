package com.jk.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 09:42
 * @Description:   评论表
 */
@Data
public class Comment {

    private Integer id;     //评论  id

    private Integer hotPointId;   //回复id   文章id  hotPoint  的id

    private Integer userId;     //用户id

    private String userContent;  //评论内容

    private Integer state;    //待审核状态  0待审核    1 通过   2不通过

    private Integer praseCount;   //点赞数

    private Date createTime;  //评论时间

    private Date updateTime;  //修改时间

    private String yhTx;   //用户头像

    private String yhMch;

    private String  replyContent;   //被回复 人内容

    private String titles;    //标题

}
