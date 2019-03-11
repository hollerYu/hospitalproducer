package com.jk.service.impl;

import com.jk.bean.QuestSurvey;
import com.jk.bean.User;
import com.jk.service.SurveyService;
import com.jk.untils.ReturnPage;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/9 11:33
 * @Description:
 */
@Service
public class SurveyServiceImpl implements SurveyService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public ReturnPage selectSurvey(Integer page,Integer rows) {
        Query query = new Query();
        // 查询数据的总条数 没有任何限制
        int count = (int) mongoTemplate.count(query, QuestSurvey.class);

        // skipNum = (pageNow-1)*pageSize
        Query skip = query.skip((page - 1) * rows);
        query.limit(rows);// 每页展示的条数
        List<QuestSurvey> buyCarList = mongoTemplate.find(query, QuestSurvey.class);
        ReturnPage sendPage = new ReturnPage(count, buyCarList);

        return sendPage;
    }

    //回显
    @Override
    public QuestSurvey querySurveyById(String id) {
        QuestSurvey questSurvey = mongoTemplate.findById(id, QuestSurvey.class);
        return questSurvey;
    }



    //修改
    @Override
    public void updateSurvey(QuestSurvey questSurvey, HttpSession session) {
        Query query = new Query(Criteria.where("id").is(questSurvey.getId()));

        User user = (User) session.getAttribute("user");
        Update update = new Update();

        update.set("questionOne",questSurvey.getQuestionOne());

        update.set("answerOne",questSurvey.getAnswerOne());
        update.set("answerTwo",questSurvey.getAnswerTwo());
        update.set("answerThree",questSurvey.getAnswerThree());
        update.set("answerFour",questSurvey.getAnswerFour());
        update.set("answerFive",questSurvey.getAnswerFive());
        update.set("answerSix",questSurvey.getAnswerSix());

        mongoTemplate.updateFirst(query,update,QuestSurvey.class);
    }


}
