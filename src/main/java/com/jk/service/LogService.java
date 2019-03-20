package com.jk.service;

import com.jk.bean.Log;
import com.jk.untils.ReturnPage;
import org.apache.poi.ss.formula.functions.Count;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LogService {

    ReturnPage queryLog(Log log, Integer page, Integer rows);

    //ercharts  日志报表
    List<Log> getEachersTwo();


}
