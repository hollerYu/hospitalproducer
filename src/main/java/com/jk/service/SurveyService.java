package com.jk.service;

import com.jk.bean.QuestSurvey;
import com.jk.untils.ReturnPage;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/8 14:22
 * @Description:
 */
public interface SurveyService {
    ReturnPage selectSurvey(Integer page,Integer rows);

    QuestSurvey querySurveyById(String id);

    void updateSurvey(QuestSurvey questSurvey, HttpSession session);
}
