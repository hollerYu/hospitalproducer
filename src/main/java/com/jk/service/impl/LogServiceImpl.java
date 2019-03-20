package com.jk.service.impl;

import com.jk.bean.Log;
import com.jk.bean.User;
import com.jk.service.LogService;
import com.jk.untils.ReturnPage;
import org.apache.poi.ss.formula.functions.Count;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.Sort.Direction;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public ReturnPage queryLog(Log log, Integer page, Integer rows) {
        Query query = new Query();
        if(!StringUtils.isEmpty(log.getRespParam())){
            query.addCriteria(Criteria.where("respParam").in(log.getRespParam()));
        }
        if(log.getEndTime()!=null && log.getStartTime()!=null){
            query.addCriteria(Criteria.where("createTime").gte(log.getStartTime()).lte(log.getEndTime()));
        }
        if(log.getStartTime()!=null && log.getEndTime()==null){
            query.addCriteria(Criteria.where("createTime").gte(log.getStartTime()));
        }
        if(log.getEndTime()!=null && log.getStartTime()==null){
            query.addCriteria(Criteria.where("createTime").lte(log.getEndTime()));
        }
        // 查询数据的总条数 没有任何限制
        int count = (int) mongoTemplate.count(query, Log.class);
        query.with(new Sort(Direction.DESC, "createTime"));
        query.skip((page - 1) * rows);//
        query.limit(rows);// 每页展示的条数
        List<Log> logList = mongoTemplate.find(query, Log.class);
        ReturnPage sendPage = new ReturnPage(count, logList);// java 的装箱和拆箱
        return sendPage;
    }

    @Override
    public List<Log> getEachersTwo() {

        Query query = new Query();

        List<Log> logList = mongoTemplate.find(query, Log.class);

        return logList;
    }


}
