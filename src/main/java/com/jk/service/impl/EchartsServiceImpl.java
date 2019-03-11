package com.jk.service.impl;

import com.jk.bean.AnswerSurvey;
import com.jk.bean.PieBean;
import com.jk.service.EchartsService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EchartsServiceImpl implements EchartsService {

    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public List<PieBean> getgetChart() {

        Query query = new Query();
        query.addCriteria(Criteria.where("answerValue").is("B、女"));
        int count = (int) mongoTemplate.count(query, AnswerSurvey.class);

        Query query2 = new Query();
        query2.addCriteria(Criteria.where("answerValue").is("A、男"));
        int count2 = (int) mongoTemplate.count(query2, AnswerSurvey.class);

        List<PieBean> pieBeans = new ArrayList<>();
        if(count2>0){
            pieBeans.add(new PieBean(count2,"男"));
        }
        if(count>0){
            pieBeans.add(new PieBean(count,"女"));
        }
        return pieBeans;
    }

    @Override
    public List<PieBean> getChart02() {
        Query queryA = new Query();
        queryA.addCriteria(Criteria.where("answerValue").is("A、三甲医院"));
        int countA = (int) mongoTemplate.count(queryA, AnswerSurvey.class);

        Query queryB = new Query();
        queryB.addCriteria(Criteria.where("answerValue").is("B、私立医院"));
        int countB = (int) mongoTemplate.count(queryB, AnswerSurvey.class);

        Query queryC = new Query();
        queryC.addCriteria(Criteria.where("answerValue").is("C、社区服务中心"));
        int countC = (int) mongoTemplate.count(queryC, AnswerSurvey.class);

        Query queryD = new Query();
        queryD.addCriteria(Criteria.where("answerValue").is("D、诊所"));
        int countD = (int) mongoTemplate.count(queryD, AnswerSurvey.class);

        Query queryE = new Query();
        queryE.addCriteria(Criteria.where("answerValue").is("E、其他"));
        int countE = (int) mongoTemplate.count(queryE, AnswerSurvey.class);

        List<PieBean> pieBeans = new ArrayList<>();
        if(countA>0){
            pieBeans.add(new PieBean(countA,"三甲医院"));
        }
        if(countB>0){
            pieBeans.add(new PieBean(countB,"私立医院"));
        }
        if(countC>0){
            pieBeans.add(new PieBean(countC,"社区服务中心"));
        }
        if(countD>0){
            pieBeans.add(new PieBean(countD,"诊所"));
        }
        if(countE>0){
            pieBeans.add(new PieBean(countE,"其他"));
        }

        return pieBeans;
    }
}
