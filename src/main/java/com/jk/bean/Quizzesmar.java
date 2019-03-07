/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Quizzesmar
 * Author:   SWORD
 * Date:     2019/3/7 15:50
 * Description: 智力测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈智力测试〉
 *
 * @author SWORD
 * @create 2019/3/7
 * @since 1.0.0
 */
@Document(collection="Quizzesmar") //mongodb 自动生成表
@Data
public class Quizzesmar implements Serializable {

    private String  id;
    private String  title;  //标题
    private String  one;    //选择题a
    private String  two;    //选择题b
    private String  three;  //选择题c
    private String  five;   //选择题d
    private String  parse;  //正确解析
    private Integer userid; //关联登陆人id
    private Integer result; //正确答案
    private Integer start;  //状态

}