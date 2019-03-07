package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 10:02
 * @Description:   评论回复表
 */
@Data
public class CommentReply {

    private Integer id;   //评论  id

    private Integer userId;   //用户id

    private Integer  forReplyId;   //回复人id

    private Integer  toReplyId;   //被回复 人id

    private String  replyContent;   //被回复 人内容

    @JsonFormat(timezone = "GTM+8",pattern = "yyyy-MM-dd")
    private Date replyTime;   //回复时间




}
