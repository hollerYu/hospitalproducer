package com.jk.service;

import com.jk.untils.ResultPage;

public interface VipService {
    ResultPage getVipList(Integer page, Integer rows);
}
