package com.jk.service;

import com.jk.bean.Log;
import com.jk.untils.ReturnPage;

import javax.servlet.http.HttpSession;

public interface LogService {

    ReturnPage queryLog(Log log, Integer page, Integer rows, HttpSession session);

}
