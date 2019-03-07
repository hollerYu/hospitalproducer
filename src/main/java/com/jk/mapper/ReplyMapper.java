package com.jk.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 10:45
 * @Description:
 */
@Controller
@RequestMapping("replyYjm")
public interface ReplyMapper {
    //评论回复
    void replyComment(@Param("id")Integer id,@Param("toReplyId")Integer toReplyId,@Param("replyContent")String replyContent,@Param("forReplyId")Integer forReplyId);

    void changeReplyState(Integer id);
}
