package com.jk.service;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 10:44
 * @Description:
 */
public interface ReplyService {
    //  回复评论
    void replyComment(Integer id, Integer toReplyId, String replyContent, Integer forReplyId);


}
