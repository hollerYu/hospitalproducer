package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 热点资讯
 */
@Data
public class HotPoint {

    private Integer id;

    private String titles; //标题

    private String photo; //图片

    private String video; //视频

    private Integer seeCount; //观看人数

    @JsonFormat(timezone = "GTM+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date times; //时间

    private String content; //文章

    //临时字段
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private Integer number;

}
