/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuizzesmarServiceImpl
 * Author:   SWORD
 * Date:     2019/3/7 16:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.mapper.QuizzesmarMapper;
import com.jk.service.QuizzesmarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author SWORD
 * @create 2019/3/7
 * @since 1.0.0
 */
@Service
public class QuizzesmarServiceImpl implements QuizzesmarService {

    @Autowired
    private QuizzesmarMapper quizzesmarMapper;

}