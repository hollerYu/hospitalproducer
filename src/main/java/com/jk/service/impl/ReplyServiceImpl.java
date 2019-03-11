package com.jk.service.impl;

import com.jk.mapper.ReplyMapper;
import com.jk.service.ReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 10:45
 * @Description:
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    private ReplyMapper replyMapper;

    @Override
    @Transactional
    public void replyComment(Integer id, Integer toReplyId, String replyContent, Integer forReplyId) {
        replyMapper.replyComment(id,toReplyId,replyContent,forReplyId);
        //评论是否成功
        replyMapper.changeReplyState(id);
    }
}
