package com.jk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 15:56
 * @Description:
 */
@Data
@Document(collection="QuestSurvey")
@AllArgsConstructor
@NoArgsConstructor
public class QuestSurvey {

    @Id
    private String id; // 对应 选项表  的(questId)  字段

    private String questionOne;    //问题 1序号

    private String answerOne;   //答案  1

    private String answerTwo;   //答案  2

    private String answerThree;   //答案  3

    private String answerFour;   //答案  4

    private String answerFive;   //答案  5

    private String answerSix;   //答案  6

    private String state;   //表示答案的  值


}
