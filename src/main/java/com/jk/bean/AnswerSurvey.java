package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 16:29
 * @Description:     积分表
 */
@Data
@Document(collection="AnswerSurvey")
public class AnswerSurvey {

    private String id;

    private Integer userId;   //

    private String questionOne;    //   调查对象  的  问题

    private String answerValue;    //问题   字段   关联  提问 的问题表


}
