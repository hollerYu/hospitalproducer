/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Lhouse
 * Author:   SWORD
 * Date:     2019/3/11 14:14
 * Description: 个人收藏
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈个人收藏〉
 *
 * @author SWORD
 * @create 2019/3/11
 * @since 1.0.0
 */
@Data
public class Lhouse implements Serializable {

     private Integer id;

     private String collectiontitle;

     private Date sysDate;

     private Integer userid;

     private Integer countMch;

     private String userMch;

}